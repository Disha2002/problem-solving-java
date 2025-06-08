# Heap Data Structure and Priority Queues

---

## 1. What is a Heap?

A **heap** is a specialized tree-based data structure that satisfies the **heap property**:

- **Max-Heap:** Every parent node is greater than or equal to its children.
- **Min-Heap:** Every parent node is less than or equal to its children.

Heaps are commonly implemented as **binary heaps** — complete binary trees stored efficiently using arrays.

---

## 2. Properties of Binary Heap

- Complete binary tree: all levels are fully filled except possibly the last, which is filled from left to right.
- Efficient for implementing priority queues.
- Root node is always the max or min element depending on heap type.

---

## 3. Heap Operations

| Operation       | Description                                 | Time Complexity |
|-----------------|---------------------------------------------|-----------------|
| Insert          | Add a new element to the heap                | O(log n)        |
| Extract (Remove)| Remove the root element (max or min)          | O(log n)        |
| Peek            | Get root element without removing             | O(1)            |
| Heapify         | Build heap from an unsorted array             | O(n)            |

---

## 4. Array Representation of Binary Heap

- For an element at index `i`:
  - Parent index = `(i - 1) / 2`
  - Left child index = `2 * i + 1`
  - Right child index = `2 * i + 2`

---

## 5. Java Example: Min-Heap Using PriorityQueue

Java provides a built-in **PriorityQueue** class that implements a min-heap by default.

```java
import java.util.PriorityQueue;

public class MinHeapExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Insert elements
        minHeap.offer(10);
        minHeap.offer(5);
        minHeap.offer(20);
        minHeap.offer(1);

        System.out.println("Min element: " + minHeap.peek()); // 1

        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");  // Outputs in ascending order
        }
    }
}
```

---

## 6. Java Example: Max-Heap Using PriorityQueue with Comparator

```java
import java.util.PriorityQueue;
import java.util.Collections;

public class MaxHeapExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.offer(10);
        maxHeap.offer(5);
        maxHeap.offer(20);
        maxHeap.offer(1);

        System.out.println("Max element: " + maxHeap.peek()); // 20

        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");  // Outputs in descending order
        }
    }
}
```

---

## 7. Implementing a Binary Heap from Scratch (Min-Heap)

```java
import java.util.ArrayList;

class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }

    public void insert(int val) {
        heap.add(val);
        siftUp(heap.size() - 1);
    }

    private void siftUp(int i) {
        while (i > 0 && heap.get(parent(i)) > heap.get(i)) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public int extractMin() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        int result = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            siftDown(0);
        }
        return result;
    }

    private void siftDown(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;

        if (left < heap.size() && heap.get(left) < heap.get(smallest)) smallest = left;
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) smallest = right;

        if (smallest != i) {
            swap(i, smallest);
            siftDown(smallest);
        }
    }

    public int peek() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}

public class CustomMinHeapDemo {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(20);
        minHeap.insert(1);

        System.out.println("Min element: " + minHeap.peek()); // 1

        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.extractMin() + " ");  // 1 5 10 20
        }
    }
}
```

---

## 8. Priority Queues

- Abstract data type where each element has a **priority**.
- Elements with higher priority are served before lower priority ones.
- Heaps are efficient data structures to implement priority queues.
- Widely used in algorithms like Dijkstra’s shortest path, Huffman coding, and scheduling.

---

## Summary

- **Heap** is a complete binary tree satisfying heap property (min or max).
- Supports efficient insertion and extraction of min/max.
- **PriorityQueue** in Java uses a heap internally.
- Can be implemented from scratch using arrays or lists.
- Useful for many algorithmic problems involving priority.

---