# Queue

Queue is a linear data structure that follows the **FIFO — First In, First Out.** 

This means that the first element added to the queue will be the first one to be removed, just like a real-world queue (like people waiting in line at a bank or ticket counter).

## Key Characteristics
- Enqueue: Adding an element to the end of the queue.

- Dequeue: Removing an element from the front of the queue.

- You can't access elements in the middle like in a list or array — only from the front or rear.

## Common Use Cases:
- Task scheduling (e.g., print queue)

- Breadth-First Search (BFS) in graphs/trees

- Buffer handling in IO operations

- Order processing systems

## Pros of Using a Queue
- Simple and Easy to Use

Queues have a straightforward logic: enqueue at the back, dequeue from the front.

- Maintains Order

Preserves the exact order in which items were added (FIFO), which is great for scheduling and processing tasks fairly.

- Efficient Operations

Enqueue and dequeue operations are generally O(1) when implemented properly (e.g., with a linked list or deque).

- Concurrency-Friendly

Useful in multithreaded environments for managing tasks (like in producer-consumer problems).

- Useful in algorithms

Essential for Breadth-First Search, level-order traversal, and buffering data streams.

## Cons of Using a Queue
- Limited Access

You can't randomly access or update elements like you can with arrays or lists — only the front and rear.

- Potentially inefficient in some Implementations

If implemented with a dynamic array (like Python lists), dequeuing from the front can be O(n) unless optimized.

- Fixed Size in Some Languages

In lower-level languages or fixed-size implementations (like circular queues), you have to manually handle overflow.

- Not Ideal for Priority Handling

If you need to process based on importance or urgency (not just order), you'd want a priority queue, not a basic one.

