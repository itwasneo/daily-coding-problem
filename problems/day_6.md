# Good morning! Here's your coding interview problem for today

This problem was asked by <mark>&nbsp;Google&nbsp;</mark>

An XOR linked list is a more memory efficient doubly linked list. Instead of each node holding next and prev fields, 
it holds a field named both, which is an XOR of the next node and the previous node. Implement an XOR linked list; 
it has an add(element) which adds the element to the end, and a get(index) which returns the node at index.

If using a language that has no pointers (such as Python), you can assume you have access to get_pointer and 
dereference_pointer functions that converts between nodes and memory addresses.

## About Solution

XOR Linked Lists are specialized Linked List implementations that provide less **memory usage**, by keeping only one address pointer for both previous and next nodes inside a Node struct.

The single address pointer keeps the result of XOR Bitwise Operation between the next and previous address pointer values. This idea comes from the following two facts about XOR operation.

```
X⊕0 = X
X⊕X = 0
```

Using this two formula, you can traverse the linked list either from left to right or right to left easily.

[#hard]() [#data-stuctures](), [#linked-list](), [#google](), [#solved]()