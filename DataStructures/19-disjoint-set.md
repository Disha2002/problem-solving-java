# Disjoint Set (Union-Find) Data Structure

---

## 1. What is a Disjoint Set?

A **Disjoint Set** or **Union-Find** data structure keeps track of a set of elements partitioned into **disjoint (non-overlapping) subsets**. It supports two primary operations efficiently:

- **Find:** Determine which subset a particular element belongs to. This can be used to check if two elements are in the same subset.
- **Union:** Join two subsets into a single subset.

---

## 2. Applications

- Detecting cycles in undirected graphs.
- Kruskal’s algorithm for Minimum Spanning Trees.
- Network connectivity.
- Image processing (connected components).
- Equivalence queries.

---

## 3. Data Structure Overview

- Each subset is represented by a **tree**.
- Each element points to a parent; the root is the representative of the subset.
- Initially, each element is its own parent (singleton sets).

---

## 4. Optimizations

- **Path Compression (Find):** Flattens the structure by making nodes point directly to the root.
- **Union by Rank/Size:** Always attach the smaller tree under the root of the larger tree to keep trees shallow.

These optimizations reduce amortized time per operation to almost **O(1)** (inverse Ackermann function).

---

## 5. Java Implementation

```java
public class DisjointSet {
    private int[] parent;
    private int[] rank;

    // Initialize n disjoint sets (0 to n-1)
    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;  // each element is its own parent
            rank[i] = 0;    // initial rank is zero
        }
    }

    // Find the representative (root) of the set that element x belongs to
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    // Union two sets containing elements x and y
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return false; // Already in the same set
        }

        // Union by rank
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootY] < rank[rootX]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }

        return true;
    }

    // Check if two elements are in the same set
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
```

---

## 6. Example Usage

```java
public class DisjointSetDemo {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(5);

        ds.union(0, 1);
        ds.union(1, 2);
        ds.union(3, 4);

        System.out.println(ds.connected(0, 2)); // true
        System.out.println(ds.connected(0, 4)); // false

        ds.union(2, 4);
        System.out.println(ds.connected(0, 4)); // true
    }
}
```

---

## Summary

- Disjoint Set is useful for grouping elements into distinct sets.
- Supports efficient union and find operations with path compression and union by rank.
- Widely used in graph algorithms, especially MST and cycle detection.

---