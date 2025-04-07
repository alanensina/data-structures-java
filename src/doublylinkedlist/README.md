# DoublyLinkedList

A Doubly Linked List (DLL) is a type of linked data structure that consists of a sequence of nodes, where each node contains three components:

- **Data:** The actual value stored in the node.

- **Next Pointer:** A reference to the next node in the sequence.

- **Previous Pointer:** A reference to the previous node in the sequence.

## Key Features of a Doubly Linked List:
- **Bidirectional Traversal:** You can move forward and backward through the list, unlike a singly linked list where you can only go in one direction.

- **Dynamic Size:** Like other linked lists, DLLs can grow and shrink easily without reallocating or reorganizing the whole structure.

- **More Memory Usage:** Each node requires an extra pointer (for the previous node), so it uses more memory than a singly linked list.

## Advantages:
- Easier deletion of a node when you have a pointer to it (since you can access the previous node directly).

- Can be traversed in both directions.

## Disadvantages:
- Slightly more complex to implement.

- Extra memory for the previous pointer.
  
## Key Facts about 'java.util.LinkedList':
  
- It is a doubly linked list under the hood.

- Implements List, Deque, and Queue interfaces.

- Allows efficient insertions and deletions at both ends and at any position.

- Can be used as a stack, queue, or deque.

## Singly Linked Lists (SLL) vs Doubly Linked Lists (DLL)

Both are dynamic data structures made of nodes, but they differ in how those nodes are connected and what operations they're best suited for.

| Feature | Singly Linked List (SLL) | Doubly Linked List (DLL)             |
|----------|----------|--------------------------------------|
| Node structure   | One pointer: next | Two pointers: next and previous      |
| Traversal direction   | Forward only | Forward and backward |
| Memory usage   | Less (one pointer per node) | More (two pointers per node) |
| Insertion/Deletion   | Easier at head; trickier in middle/tail | Easier at both ends and in middle |
| Search performance   | Same as DLL (O(n)) | Same as SLL (O(n)) |
| Reverse traversal   | Not possible without extra effort | Naturally supported |
| Complexity   | Simpler to implement and manage | Slightly more complex |

## When to Use Each One?
✅ Use Singly Linked List when:
- You only need one-way traversal (e.g., going through a list in order).

- You're optimizing for memory (only 1 pointer per node).

- Insertions and deletions mostly happen at the head or you're okay traversing to the node before the one to delete.

- You're working with simpler data flows, like stacks or basic queues.

✅ Use Doubly Linked List when:
- You need two-way traversal (e.g., go back and forth like in a browser history or undo-redo system).

- You need frequent insertions/deletions at both ends or in the middle.

- You're building complex data structures like Deque, LRU Cache, or navigation systems.

- You want to avoid full traversal when deleting a node (if you already have the reference).