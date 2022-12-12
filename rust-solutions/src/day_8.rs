use std::mem;

pub struct BinaryTree {
    root: Link,
}

impl BinaryTree {
    pub fn new() -> Self {
        Self {
            root: Link::Occupied(Box::new(Node::new(0))),
        }
    }
}

pub enum Link {
    Empty,
    Occupied(Box<Node>),
}

pub struct Node {
    val: i32,
    left: Link,
    right: Link,
}

impl Node {
    pub fn new(val: i32) -> Self {
        Self {
            val,
            left: Link::Empty,
            right: Link::Empty,
        }
    }
}
//(2*i+1)-> Left   (2*i+2)-> Right
pub fn fill_tree(curr_link: &mut Link, tree_array: &[i32], idx: usize) {
    let left_index = 2 * idx + 1;
    let right_index = 2 * idx + 2;
    match curr_link {
        Link::Empty => {}
        Link::Occupied(node) => {
            if left_index < tree_array.len() {
                if tree_array[left_index] != -1 {
                    node.left = Link::Occupied(Box::new(Node::new(tree_array[left_index])));
                    fill_tree(&mut node.left, tree_array, left_index)
                } else {
                    node.left = Link::Empty
                }
            }
            if right_index < tree_array.len() {
                if tree_array[right_index] != -1 {
                    node.right = Link::Occupied(Box::new(Node::new(tree_array[right_index])));
                    fill_tree(&mut node.right, tree_array, right_index)
                } else {
                    node.right = Link::Empty
                }
            }
        }
    }
}

pub fn print_tree_inorder(node: Link) {
    match node {
        Link::Empty => {}
        Link::Occupied(node) => {
            print_tree_inorder(node.left);
            print!("{} ", node.val);
            print_tree_inorder(node.right);
        }
    }
}
pub fn print_tree_preorder(node: Link) {
    match node {
        Link::Empty => {}
        Link::Occupied(node) => {
            print!("{} ", node.val);
            print_tree_inorder(node.left);
            print_tree_inorder(node.right);
        }
    }
}
pub fn print_tree_postorder(node: Link) {
    match node {
        Link::Empty => {}
        Link::Occupied(node) => {
            print_tree_inorder(node.left);
            print_tree_inorder(node.right);
            print!("{} ", node.val);
        }
    }
}

#[allow(dead_code)]
fn day_8(tree: &[i32]) -> i32 {
    69
}

#[cfg(test)]
mod tests {
    use super::{day_8, fill_tree, print_tree_inorder, BinaryTree};

    #[test]
    fn day_8_test() {
        let input = [0, 1, 0, -1, -1, 1, 0, -1, -1, -1, -1, 1, 1];
        let mut b_tree = BinaryTree::new();
        fill_tree(&mut b_tree.root, &input, 0);
        print_tree_inorder(b_tree.root);
        assert_eq!(69, day_8(&input));
    }
}
