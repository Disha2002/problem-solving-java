# Balanced Trees

Balanced trees are special types of binary search trees (BSTs) designed to maintain **height balance** to ensure operations like search, insertion, and deletion stay efficient, typically **O(log n)**.

---

## Why Balance?

- A regular BST can become skewed, degrading performance to O(n).
- Balanced trees keep the height low, improving efficiency.
- They automatically perform rotations to maintain balance after insertions/deletions.

---

## 1. AVL Trees

### Overview

- Named after **Adelson-Velsky and Landis** who introduced it in 1962.
- Strictly balanced BST.
- For every node, the **balance factor** (height of left subtree - height of right subtree) is either **-1, 0, or 1**.
- If balance factor goes out of this range after insertion/deletion, **rotations** are performed to rebalance.

### Balance Factor

```
balanceFactor = height(left subtree) - height(right subtree)
```

### Rotations

- **Right Rotation (LL Rotation)**
- **Left Rotation (RR Rotation)**
- **Left-Right Rotation (LR Rotation)**
- **Right-Left Rotation (RL Rotation)**

### Node Structure (Java)

```java
class AVLNode {
    int data, height;
    AVLNode left, right;

    AVLNode(int data) {
        this.data = data;
        this.height = 1;
    }
}
```

---

## 2. Red-Black Trees

### Overview

- Another type of self-balancing BST.
- Each node contains an extra bit for **color** (red or black).
- Balances the tree by enforcing certain properties during insertion/deletion.
- Guarantees path from root to leaves contains roughly the same number of black nodes, limiting height to **O(log n)**.

### Properties

1. Each node is either **red** or **black**.
2. The root is always **black**.
3. All leaves (null nodes) are **black**.
4. Red nodes cannot have red children (no two reds in a row).
5. Every path from a node to its descendant leaves contains the same number of black nodes.

### Advantages

- Easier to implement than AVL.
- Less strict balancing; fewer rotations on insertion and deletion.

---

## Comparison: AVL vs Red-Black Trees

| Feature              | AVL Tree                        | Red-Black Tree                  |
|----------------------|--------------------------------|--------------------------------|
| Balance Strictness   | More strict (balance factor ±1) | Less strict (color properties)  |
| Search Performance   | Faster lookup (more balanced)   | Slightly slower lookup          |
| Insertion/Deletion   | More rotations, slower updates  | Fewer rotations, faster updates |
| Use Cases            | Read-heavy applications         | Insert/delete-heavy applications|

---

## Summary

Balanced trees ensure **O(log n)** time for dynamic set operations by maintaining height constraints.

- **AVL trees** maintain stricter balance and provide faster lookups.
- **Red-Black trees** provide better insertion and deletion performance with simpler balancing rules.

---