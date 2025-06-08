# Graph Representations

Graphs can be represented in multiple ways, each with its own trade-offs in terms of space and time complexity. The most common representations are:

1. **Adjacency List**
2. **Adjacency Matrix**
3. **Edge List**

---

## 1. Adjacency List

An **adjacency list** maintains a list of neighbors for each vertex.

### Example (Undirected Graph)

Graph:
```
0 — 1
|   |
2 — 3
```

### Representation:
```java
List<List<Integer>> adjList = new ArrayList<>();
adjList.add(Arrays.asList(1, 2));     // 0 → 1, 2
adjList.add(Arrays.asList(0, 3));     // 1 → 0, 3
adjList.add(Arrays.asList(0, 3));     // 2 → 0, 3
adjList.add(Arrays.asList(1, 2));     // 3 → 1, 2
```

### Space Complexity:
- O(V + E) where V = vertices, E = edges

### Pros:
- Efficient for **sparse graphs**
- Easy to iterate over neighbors

### Cons:
- Less efficient for checking the existence of a specific edge

---

## 2. Adjacency Matrix

An **adjacency matrix** is a 2D array where `matrix[i][j] = 1` (or weight) if there is an edge from `i` to `j`.

### Example:
```
0 — 1
|   |
2 — 3
```

### Representation:
```java
int[][] adjMatrix = {
    {0, 1, 1, 0},
    {1, 0, 0, 1},
    {1, 0, 0, 1},
    {0, 1, 1, 0}
};
```

### Space Complexity:
- O(V²)

### Pros:
- Fast edge lookup: O(1)
- Simple implementation

### Cons:
- Inefficient for **sparse graphs**
- Uses more space even for few edges

---

## 3. Edge List

An **edge list** stores all edges as pairs (or triples if weighted).

### Example:
```
0 — 1
|   |
2 — 3
```

### Representation:
```java
int[][] edgeList = {
    {0, 1},
    {0, 2},
    {1, 3},
    {2, 3}
};
```

For weighted graphs:
```java
int[][] edgeList = {
    {0, 1, 5},
    {0, 2, 3},
    {1, 3, 2},
    {2, 3, 4}
};
```

### Space Complexity:
- O(E)

### Pros:
- Very space-efficient
- Ideal for edge-centric algorithms like Kruskal's MST

### Cons:
- Slower to find neighbors
- Inefficient for adjacency lookups

---

## Summary Table

| Representation     | Space Complexity | Edge Lookup | Best For              |
|--------------------|------------------|-------------|------------------------|
| Adjacency List     | O(V + E)         | O(k)        | Sparse graphs          |
| Adjacency Matrix   | O(V²)            | O(1)        | Dense graphs, fast lookup |
| Edge List          | O(E)             | O(E)        | Edge-based algorithms  |

---

## Conclusion

Choose a graph representation based on the nature of the problem:
- Use **Adjacency List** for general purposes and sparse graphs.
- Use **Adjacency Matrix** when fast edge existence checks are needed.
- Use **Edge List** for edge-centric problems like MSTs.
