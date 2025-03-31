# LinkedList

A LinkedList in Java is a data structure that consists of a sequence of nodes, where each node contains two parts:

- Data: The actual value stored in the node.

- Pointer (Reference): A reference to the next (and sometimes previous) node in the sequence.

Java provides a built-in LinkedList class in the java.util package, which implements the List and Deque interfaces. This allows it to be used as both a doubly-linked list and a queue.

## Types of Linked Lists
- Singly Linked List: Each node has a reference to the next node.

- Doubly Linked List: Each node has references to both the next and previous nodes.

- Circular Linked List: The last node points back to the first node, forming a loop.

## Advantages of LinkedList
- Dynamic size: No need to specify an initial size.

- Efficient insertions and deletions: Adding/removing elements from the middle is faster than an ArrayList (O(1) for head/tail, O(n) for middle).

- Implements Deque: Can be used as a stack, queue, or deque.

## Disadvantages of LinkedList
- Higher memory usage: Each node requires extra memory for pointers.

- Slower access time: Unlike arrays, LinkedLists do not support direct indexing (O(n) lookup).
  

## Differences Between LinkedList and ArrayList in Java
  
Both `LinkedList` and `ArrayList` are implementations of the `List` interface in Java, but they have different performance characteristics and use cases.

| Feature | ArrayList | LinkedList                          |
|----------|----------|-------------------------------------|
| Implementation   | Uses a dynamic array internally | Uses a doubly linked list internally|
| Memory Usage   | Less memory because it only stores elements   | More memory due to additional pointers for each node|
| Access Time (get(index))  | Fast (O(1)) because it supports direct indexing  | Slow (O(n)) because traversal is required from the head or tail |
| Insertion (add(index, value))   | Slow (O(n)) because shifting is required when inserting in the middle | Fast (O(1) at head/tail, O(n) in the middle) since it only updates pointers   |
| Deletion (remove(index))  | Slow (O(n)) due to shifting elements after removal  | Fast (O(1) at head/tail, O(n) in the middle) since only pointers are updated  |
| Iteration Performance  | Faster because elements are stored in a contiguous block in memory | Slower because of pointer traversal between nodes |
| Best Use Case  | When frequent random access is needed.   | When frequent insertions and deletions are required |

## When to Use Which?
Use ArrayList when:

- You need fast random access (e.g., get(index)).

- The number of elements is known in advance.

- You have fewer insertions/deletions in the middle.

## Use LinkedList when:

- You have frequent insertions or deletions, especially at the beginning or middle.

- Memory usage is not a major concern.

- You are implementing a queue or stack.