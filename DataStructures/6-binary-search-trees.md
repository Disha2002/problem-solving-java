# Binary Search Trees (BST)

## Overview

A **Binary Search Tree (BST)** is a binary tree with the following properties:

- For each node:
  - All nodes in its **left subtree** contain values **less than** the node’s value.
  - All nodes in its **right subtree** contain values **greater than** the node’s value.
- No duplicate nodes (usually).

---

## Properties

- Inorder traversal of a BST yields sorted elements in ascending order.
- Average height is **O(log n)** for balanced BSTs.
- Worst case height is **O(n)** (degenerate tree like a linked list).

---

## Node Structure (Java)

```java
class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}
```

---

## Basic Operations

### 1. Search

```java
TreeNode search(TreeNode root, int key) {
    if (root == null || root.data == key) return root;
    if (key < root.data) return search(root.left, key);
    else return search(root.right, key);
}
```

### 2. Insert

```java
TreeNode insert(TreeNode root, int key) {
    if (root == null) return new TreeNode(key);

    if (key < root.data) {
        root.left = insert(root.left, key);
    } else if (key > root.data) {
        root.right = insert(root.right, key);
    }
    return root;
}
```

### 3. Delete

Deleting a node in BST has three cases:

- Node is a leaf (no children): simply remove it.
- Node has one child: replace node with child.
- Node has two children: replace node’s value with inorder successor (smallest value in right subtree), then delete the successor.

```java
TreeNode delete(TreeNode root, int key) {
    if (root == null) return null;

    if (key < root.data) {
        root.left = delete(root.left, key);
    } else if (key > root.data) {
        root.right = delete(root.right, key);
    } else {
        // Node found
        if (root.left == null) return root.right;
        else if (root.right == null) return root.left;

        // Node with two children: get inorder successor
        root.data = minValue(root.right);
        root.right = delete(root.right, root.data);
    }
    return root;
}

int minValue(TreeNode node) {
    int minv = node.data;
    while (node.left != null) {
        minv = node.left.data;
        node = node.left;
    }
    return minv;
}
```

---

## Traversal (Inorder)

```java
void inorder(TreeNode root) {
    if (root == null) return;
    inorder(root.left);
    System.out.print(root.data + " ");
    inorder(root.right);
}
```

---

## Time Complexity

| Operation | Average Case | Worst Case   |
|-----------|--------------|--------------|
| Search    | O(log n)     | O(n)         |
| Insert    | O(log n)     | O(n)         |
| Delete    | O(log n)     | O(n)         |

---

## Applications

- Efficient searching, insertion, and deletion.
- Implementing dynamic sets and lookup tables.
- Basis for more complex data structures like AVL and Red-Black Trees.

---
