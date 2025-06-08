# Depth-First Search (DFS)

**Depth-First Search (DFS)** is a graph traversal algorithm that explores as far as possible along a branch before backtracking. It can be implemented **recursively** or **iteratively** using a stack.

---

## 1. Characteristics

- Explores depth before breadth
- Can be used on **directed** or **undirected** graphs
- Detects **cycles**, **connected components**, **topological sorting**, and more
- Time complexity: **O(V + E)**
- Space complexity: **O(V)** for visited and recursion stack

---

## 2. Applications

- Cycle detection
- Topological sorting (for DAGs)
- Solving mazes and puzzles
- Connected components in a graph
- Path finding and reachability

---

## 3. DFS Algorithm Steps (Recursive)

1. Start from a node and mark it as visited.
2. Recur for all its unvisited neighbors.
3. Backtrack once all adjacent vertices are explored.

---

## 4. Java Implementation (Recursive)

### Example Graph:
```
0 — 1
|   |
2 — 3
```

### Code:

```java
import java.util.*;

public class DFSExample {
    public static void dfs(List<List<Integer>> adj, boolean[] visited, int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(adj, visited, neighbor);
            }
        }
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Undirected graph
        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(0).add(2); adj.get(2).add(0);
        adj.get(1).add(3); adj.get(3).add(1);
        adj.get(2).add(3); adj.get(3).add(2);

        boolean[] visited = new boolean[V];
        System.out.print("DFS Traversal starting from node 0: ");
        dfs(adj, visited, 0);  // Output: 0 1 3 2
    }
}
```

---

## 5. Iterative DFS Using Stack

```java
public static void dfsIterative(List<List<Integer>> adj, int start) {
    boolean[] visited = new boolean[adj.size()];
    Stack<Integer> stack = new Stack<>();

    stack.push(start);

    while (!stack.isEmpty()) {
        int node = stack.pop();

        if (!visited[node]) {
            visited[node] = true;
            System.out.print(node + " ");

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }
}
```

---

## 6. DFS vs BFS

| Feature       | DFS                 | BFS                 |
|---------------|---------------------|---------------------|
| Data Structure| Stack / Recursion   | Queue               |
| Exploration   | Depth-first         | Level-order         |
| Space         | O(V)                | O(V)                |
| Use Case      | Components, cycles  | Shortest paths      |

---

## Summary

- DFS is ideal for **exploring depth**, detecting **cycles**, and solving **recursive problems**.
- It can be implemented both **recursively** and **iteratively**.
- DFS is a key technique in many graph-related algorithms.
