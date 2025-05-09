# Tree

A **tree** is a widely used abstract data structure that simulates a hierarchical tree-like structure with a set of connected nodes.

Here’s a simple breakdown:

- **Node**: Each element in a tree is called a node. A node contains some data and may link to other nodes.

- **Root**: The top node of a tree is called the root. It has no parent.

- **Parent and Child**: A parent node is a node that has links to one or more child nodes.

- **Leaf**: A leaf node is a node that has no children.

- **Edge**: The connection between one node and another.

- **Subtree**: Any node along with its descendants forms a subtree.

- **Height**: The number of edges from the node to the deepest leaf.
  
## Common types of Trees:

- Binary Tree: Each node has at most two children (left and right).

- Binary Search Tree (BST): A binary tree where the left child is less than the parent, and the right child is greater.

- AVL Tree, Red-Black Tree: Self-balancing binary search trees.

- Trie: A tree for storing strings, especially used for dictionaries.

- Heap: A special tree used for efficient priority queue operations.

## Why are Trees Useful?

- Organizing hierarchical data (like file systems, HTML DOM)

- Fast searching and sorting (binary search trees)

- Database indexing (B-trees)

- Efficient autocomplete features (tries)

## What is a Binary Search Tree (BST)?
A Binary Search Tree is a special type of binary tree where:

- Each node contains a key (value).

- The left subtree of a node contains only nodes with keys smaller than the node’s key.

- The right subtree contains only nodes with keys greater than the node’s key.

- Both the left and right subtrees must also be binary search trees.

In short:
`Left child < Parent < Right child`

## Example of a BST:
```
        8
      /   \
     3     10
    / \      \
   1   6      14
      / \     /
     4   7   13
```

- 3 is less than 8, so it goes to the left.

- 10 is greater than 8, so it goes to the right.

- 1 is less than 3, so it goes to the left of 3, and so on.

## Main Operations in a BST:

- Search

  - Start at the root.

  - If the value is less, move left. If greater, move right.

  - Keep moving until you find the value or reach a leaf.


- Insert

  - Similar to search.

  - Find the correct position based on comparisons and insert the new node.


- Delete

  - Three cases:

    - Node has no children (just remove it).

    - Node has one child (replace the node with its child).

    - Node has two children (find the in-order successor or in-order predecessor to replace it).


- Traversal

  - Visit all nodes in some order.

  - Common orders:

    - In-order (Left, Root, Right) → Produces sorted order.

    - Pre-order (Root, Left, Right)

    - Post-order (Left, Right, Root)

## Why use a BST?
- Efficient searching: average case
𝑂
(
log
⁡
𝑛
)
O(logn) time.

- Efficient insertion and deletion: average case
𝑂
(
log
⁡
𝑛
)
O(logn).

- Sorted traversal: by doing an in-order traversal, you get the keys in sorted order.

**But important:** 
    
If the BST becomes unbalanced (like a linked list), the time complexity degrades to
𝑂
(
𝑛
)
O(n).

That's why there are balanced BSTs like AVL trees and Red-Black trees.

## What is Breadth-First Search (BFS)?
**Breadth-First Search (BFS)** is a graph or tree traversal algorithm that explores all the nodes level by level — meaning it visits all nodes at a certain depth before moving to the next level.

### How BFS works:
- Start from the root (or starting node).

- Visit all immediate neighbors (children in a tree).

- Then visit their neighbors, and so on.

- It uses a queue (FIFO structure) to keep track of which node to visit next.
  
### Use Cases of BFS:
- Finding the shortest path in unweighted graphs.

- Exploring things level-by-level (e.g., friend suggestions in social networks).

- Level-order traversal in binary trees.

### Example:
Given this binary tree:

```
       10
      /  \
     6    15
    / \     \
   3   8     20
```

BFS traversal order will be:
`10 → 6 → 15 → 3 → 8 → 20`

## What is DFS (Depth-First Search)?
**Depth-First Search (DFS)** is a graph/tree traversal algorithm that explores as far as possible along each branch before backtracking.

### How DFS works:
- Start at the root (or a starting node).

- Go deep into one branch until you hit a leaf (or a node with no unvisited children).

- Then backtrack and explore other branches.

- DFS uses a stack (LIFO) — either explicitly (with a stack) or implicitly (with recursion).

### Example:
  Given this tree:
```
       10
      /  \
     6    15
    / \     \
   3   8     20
```
A pre-order DFS (root, left, right) would visit the nodes in this order:
`10 → 6 → 3 → 8 → 15 → 20`

### Types of DFS Traversal in Trees:
- Pre-order: visit root → left → right

- In-order: left → root → right (commonly used in BSTs to get sorted order)

- Post-order: left → right → root

## DFS vs BFS:

  | Feature      | DFS                         | BFS                                |
  | ------------ | --------------------------- | ---------------------------------- |
  | Order        | Deep first, then backtrack  | Level by level                     |
  | Uses         | Stack or recursion          | Queue                              |
  | Best for     | Finding paths, maze-solving | Finding shortest path (unweighted) |
  | Memory usage | Lower in wide/deep trees    | Higher (due to full level storage) |
