# Graph Basics

Graphs are a fundamental data structure used to model relationships and connections between entities. A graph consists of a set of **vertices** (or **nodes**) and a set of **edges** that connect pairs of vertices.

---

## 1. Definitions

- **Vertex (Node):** A fundamental unit represented as a point in a graph.
- **Edge:** A connection between two vertices.
- **Graph (G):** A pair `(V, E)` where `V` is a set of vertices and `E` is a set of edges.

### Types of Graphs

---

## 2. By Direction

### 2.1 Undirected Graph

- Edges have **no direction**.
- An edge `(u, v)` means there is a connection both from `u` to `v` and `v` to `u`.

**Example:**

```
A — B
|   |
C — D
```

### 2.2 Directed Graph (Digraph)

- Edges have a **direction**.
- An edge `(u → v)` means there is a connection from `u` to `v`, but not necessarily from `v` to `u`.

**Example:**

```
A → B
↓   ↓
C ← D
```

---

## 3. By Weight

### 3.1 Weighted Graph

- Each edge has an associated numerical **weight** or **cost**.
- Common in shortest path problems (e.g., Dijkstra's Algorithm).

### 3.2 Unweighted Graph

- All edges are considered equal (no associated weight).

---

## 4. By Connectivity

### 4.1 Connected Graph (Undirected)

- There is a path between every pair of vertices.

### 4.2 Strongly Connected Graph (Directed)

- Every vertex is reachable from every other vertex via directed paths.

### 4.3 Weakly Connected Graph (Directed)

- The underlying undirected version is connected, but not all directed paths exist.

---

## 5. By Cycles

### 5.1 Acyclic Graph

- A graph with **no cycles**.
- **DAG (Directed Acyclic Graph):** Important in scheduling and dependency resolution.

### 5.2 Cyclic Graph

- A graph that contains at least one **cycle** (a path that starts and ends at the same vertex).

---

## 6. Special Graph Types

- **Tree:** A connected, acyclic undirected graph.
- **Forest:** A collection of trees (disconnected acyclic graph).
- **Complete Graph:** Every pair of distinct vertices is connected by a unique edge.
- **Bipartite Graph:** Vertices can be divided into two disjoint sets such that no two vertices within the same set are adjacent.

---

## 7. Representation

Graphs can be represented in multiple ways:

- **Adjacency List**
- **Adjacency Matrix**
- **Edge List**

---

## Summary

Graphs model pairwise relationships and come in many forms — directed, undirected, weighted, cyclic, and more. Understanding graph types is essential before exploring algorithms like BFS, DFS, Dijkstra, and Kruskal.

