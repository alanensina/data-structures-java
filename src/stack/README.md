# Stack

**Stack** is a data structure that follows the **Last In, First Out (LIFO)** principle.

This means that the last item added to the stack is the first one to be removed—kind of like a stack of plates or books: you put new ones on top, and you take the top one off first.

## Key Operations:
- Push: Add an item to the top of the stack.

- Pop: Remove the top item from the stack.

- Peek (or Top): View the top item without removing it.

- IsEmpty: Check if the stack has no elements.

## Real-world Analogies:
- A stack of dishes.

- Undo functionality in applications.

- Backtracking (e.g., in maze-solving or navigating back in a web browser).

## Uses in Computing:
- Function calls and recursion (the call stack).

- Expression evaluation (e.g., converting infix to postfix).

- Syntax parsing.

- Backtracking algorithms.

## Pros of Using a Stack
- Simple and Fast Operations

Push (add) and pop (remove) are both O(1) operations when implemented well.

- Excellent for Reversing Data

Useful when you need to reverse strings, backtrack through paths (like mazes), or undo actions.

- Used in Function Calls

The call stack in programming uses stacks to manage function calls and returns.

- Memory Efficiency (in specific contexts)

When using recursion, the stack can help manage state without manual bookkeeping.

- Supports Nested Structures

Perfect for parsing expressions, validating balanced brackets, and evaluating postfix notation.

## Cons of Using a Stack
- Limited Access

Like queues, stacks only allow access to the top element — you can’t peek deeper without popping elements off.

- Overflow & Underflow

In low-level or fixed-size implementations, you need to handle stack overflow (too many elements) or underflow (trying to pop from an empty stack).

- Not Ideal for Order-Preserving Tasks

Since stacks reverse the order of input, they’re not suitable when you need to maintain the original sequence.

- Can Lead to Deep Recursion Issues

In recursive algorithms, especially without tail-call optimization, you can hit the maximum call stack size.