# Breadth-First Search (BFS)

**Breadth-First Search (BFS)** is a graph traversal algorithm that explores all neighbors of a node before moving to the next level of neighbors. It uses a **queue** to maintain the traversal order.

---

## 1. Characteristics

- Explores layer by layer (level-order)
- Works on both directed and undirected graphs
- Finds the **shortest path** in an unweighted graph
- Time complexity: **O(V + E)**
- Space complexity: **O(V)** for visited and queue

---

## 2. Applications

- Shortest path in unweighted graphs
- Social network analysis
- Web crawling
- Connected components
- Cycle detection (in undirected graphs)

---

## 3. Algorithm Steps

1. Initialize a queue and mark the starting node as visited.
2. While the queue is not empty:
   - Dequeue the front node.
   - Process it.
   - Enqueue all unvisited neighbors and mark them as visited.

---

## 4. Java Implementation (Adjacency List)

### Graph Example:

```
0 — 1
|   |
2 — 3
```

### Code:

```java
import java.util.*;

public class BFSExample {
    public static void bfs(List<List<Integer>> adj, int start) {
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Undirected Graph Edges
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        System.out.print("BFS Traversal starting from node 0: ");
        bfs(adj, 0);  // Output: 0 1 2 3
    }
}
```

---

## 5. BFS vs DFS

| Feature       | BFS                 | DFS                 |
|---------------|---------------------|---------------------|
| Data Structure| Queue               | Stack / Recursion   |
| Space         | O(V)                | O(V)                |
| Use Case      | Shortest paths, levels | Topology, components |
| Nature        | Level-wise          | Depth-wise          |

---

## Summary

- BFS is ideal for **shortest path** problems in unweighted graphs.
- It explores all neighbors before diving deeper.
- The use of a queue ensures **FIFO** processing and level-order traversal.
