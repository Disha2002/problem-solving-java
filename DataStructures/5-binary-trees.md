# Binary Trees

## Overview

A **binary tree** is a hierarchical data structure in which each node has **at most two children**, referred to as the **left child** and the **right child**.

---

## Terminology

- **Root**: The top node in the tree.
- **Node**: Each element in the tree.
- **Parent**: A node with children.
- **Child**: A node descended from another node.
- **Leaf**: A node with no children.
- **Subtree**: Any node with its descendants.
- **Depth**: Number of edges from root to a node.
- **Height**: Number of edges on the longest path from a node to a leaf.
- **Level**: Depth + 1.

---

## Properties

- Maximum nodes at level `l` = 2^(l-1)
- Maximum nodes in a binary tree of height `h` = 2^h - 1
- A binary tree with `n` nodes has `n + 1` null pointers.

---

## Node Structure (Java)

```java
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}
```

---

## Types of Binary Trees

- **Full Binary Tree**: Every node has 0 or 2 children.
- **Complete Binary Tree**: All levels are fully filled except possibly the last, which is filled from left to right.
- **Perfect Binary Tree**: All internal nodes have two children and all leaves are at the same level.
- **Balanced Binary Tree**: Height difference between left and right subtree of any node is at most 1.
- **Degenerate (or Pathological) Tree**: Each parent node has only one child, resembling a linked list.

---

## Tree Traversals

### 1. Inorder (Left, Root, Right)

```java
void inorder(TreeNode root) {
    if (root == null) return;
    inorder(root.left);
    System.out.print(root.data + " ");
    inorder(root.right);
}
```

### 2. Preorder (Root, Left, Right)

```java
void preorder(TreeNode root) {
    if (root == null) return;
    System.out.print(root.data + " ");
    preorder(root.left);
    preorder(root.right);
}
```

### 3. Postorder (Left, Right, Root)

```java
void postorder(TreeNode root) {
    if (root == null) return;
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.data + " ");
}
```

### 4. Level Order (Breadth-First Search)

```java
void levelOrder(TreeNode root) {
    if (root == null) return;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
        TreeNode current = queue.poll();
        System.out.print(current.data + " ");
        if (current.left != null) queue.add(current.left);
        if (current.right != null) queue.add(current.right);
    }
}
```

---

## Applications

- Expression parsing and expression trees.
- Binary Search Trees (BST) (special type of binary tree).
- Priority queues (heaps).
- Syntax trees in compilers.
- Network routing algorithms.

---