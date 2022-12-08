/*
    This XOR Linked List implementation belongs to following
    person/repository:
    [https://github.com/Seppel3210/rust-xor-list]

    I followed his/her implementation literally line by line in
    order to understand the concept and grab the idea behind
    this spesific data structure.

*/
use std::{marker::PhantomData, ptr::NonNull};

struct LinkedList<E> {
    head: Option<NonNull<Node<E>>>,
    tail: Option<NonNull<Node<E>>>,
    len: usize,
    phantom: PhantomData<Box<Node<E>>>,
}

struct Node<E> {
    element: E,
    both: usize,
}

#[allow(dead_code)]
impl<E> Node<E> {
    fn new(element: E) -> Self {
        Self { both: 0, element }
    }

    fn other_ptr(&self, first: Option<NonNull<Self>>) -> Option<NonNull<Self>> {
        let first = first.map(|nn| nn.as_ptr() as usize).unwrap_or(0);
        let other = (self.both ^ first) as *mut Self;
        NonNull::new(other)
    }

    fn xor(&mut self, other: Option<NonNull<Self>>) {
        let other = other.map(|nn| nn.as_ptr() as usize).unwrap_or(0);
        self.both ^= other;
    }

    fn into_element(self: Box<Self>) -> E {
        self.element
    }
}

#[allow(dead_code)]
impl<E> LinkedList<E> {
    fn push_front_node(&mut self, mut node: Box<Node<E>>) {
        unsafe {
            node.xor(self.head);

            // Care using Box::leak. Since we are xor'ing the leaked
            // reference into the head we are not losing the leaked
            // reference.
            let node: Option<NonNull<Node<E>>> = Some(Box::leak(node).into());
            match self.head {
                None => self.tail = node,
                Some(head) => (*head.as_ptr()).xor(node),
            }
            self.head = node;
            self.len += 1;
        }
    }

    fn pop_front_node(&mut self) -> Option<Box<Node<E>>> {
        self.head.map(|node_ptr| unsafe {
            // Care using Box::from_raw. node_ptr is NonNull
            // and using as_ptr() we are getting the raw underlying
            // raw pointer. Box is the owner of raw pointer from
            // now on.
            let node: Box<Node<E>> = Box::from_raw(node_ptr.as_ptr());

            // Popping the head
            self.head = node.other_ptr(None);

            // If there is no head, we're removing the tail as well.
            match self.head {
                None => self.tail = None,
                // This line looks suspicious. I don't fully get it
                Some(head) => (*head.as_ptr()).xor(Some(node_ptr)),
            }
            self.len -= 1;
            node
        })
    }

    fn push_back_node(&mut self, mut node: Box<Node<E>>) {
        node.xor(self.tail);
        // Same operations as push front node. Extract the mutable
        // reference of given node. If there is no tail, create a
        // head otherwise update the current tails 'both' field.
        // Then update the tail node.
        unsafe {
            let node: Option<NonNull<Node<E>>> = Some(Box::leak(node).into());
            match self.tail {
                None => self.head = node,
                Some(tail) => (*tail.as_ptr()).xor(node),
            }
            self.tail = node;
            self.len += 1;
        }
    }

    fn pop_back_node(&mut self) -> Option<Box<Node<E>>> {
        self.tail.map(|node_ptr| unsafe {
            let node: Box<Node<E>> = Box::from_raw(node_ptr.as_ptr());

            // Popping the tail
            self.tail = node.other_ptr(None);

            match self.tail {
                None => self.head = None,
                Some(tail) => (*tail.as_ptr()).xor(Some(node_ptr)),
            }
            self.len -= 1;
            node
        })
    }
}

#[allow(dead_code)]
impl<E> LinkedList<E> {
    pub fn new() -> Self {
        LinkedList {
            head: None,
            tail: None,
            len: 0,
            phantom: PhantomData,
        }
    }

    pub fn len(&self) -> usize {
        self.len
    }

    pub fn push_front(&mut self, elem: E) {
        self.push_front_node(Box::new(Node::new(elem)));
    }

    pub fn pop_front(&mut self) -> Option<E> {
        self.pop_front_node().map(Node::into_element)
    }

    pub fn push_back(&mut self, elem: E) {
        self.push_back_node(Box::new(Node::new(elem)));
    }

    pub fn pop_back(&mut self) -> Option<E> {
        self.pop_back_node().map(Node::into_element)
    }
}

#[cfg(test)]
mod tests {
    use super::LinkedList;

    #[test]
    fn day_6_test() {
        let mut linked_list = LinkedList::new();
        linked_list.push_back(3);
        linked_list.push_back(4);
        assert_eq!(2, linked_list.len());
        assert_eq!(3, linked_list.pop_front().unwrap());
        linked_list.push_front(5);
        assert_eq!(4, linked_list.pop_back().unwrap());
        assert_eq!(5, linked_list.pop_front().unwrap());
        assert_eq!(None, linked_list.pop_front());
        assert_eq!(None, linked_list.pop_back());
        assert_eq!(0, linked_list.len());
    }
}
