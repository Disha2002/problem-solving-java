# Queues

## Overview

A **queue** is a linear data structure that follows the **First In, First Out (FIFO)** principle. The first element added to the queue is the first one to be removed.

---

## Characteristics

- Operations happen at two ends:
  - **enqueue** (insert at rear)
  - **dequeue** (remove from front)
- Supports operations:
  - **enqueue** — add element at the rear
  - **dequeue** — remove element from the front
  - **peek/front** — view the front element
  - **isEmpty** — check if the queue is empty

---

## Types of Queues

| Type             | Description                                        |
|------------------|--------------------------------------------------|
| Simple Queue     | Basic FIFO queue                                  |
| Circular Queue   | Rear connects back to front forming a circle     |
| Priority Queue   | Elements are dequeued based on priority value    |

---

## Simple Queue

### Implementation Concept

- Uses a fixed-size array or linked list.
- Front and rear pointers track the first and last elements.
- When rear reaches the end of array, no more insertions unless elements are dequeued.

### Java Example (Simple Queue)

```java
class SimpleQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    public SimpleQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        size = 0;
        rear = capacity - 1;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public int front() {
        if (isEmpty()) return -1;
        return queue[front];
    }
}
```

---

## Circular Queue

### Concept

- Improves space efficiency by connecting rear to front.
- Uses modulo arithmetic to wrap around the array.
- Avoids "false overflow" that happens in simple queues.

### Characteristics

- Front points to the first element.
- Rear points to the last element.
- Size keeps track of the number of elements.

---

## Priority Queue

### Concept

- Elements are dequeued based on their priority, not order of arrival.
- Usually implemented with a **heap** (min-heap or max-heap).
- Common in scheduling, simulation, and pathfinding algorithms.

### Java Example Using `PriorityQueue`

```java
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min-heap by default

        pq.offer(30);
        pq.offer(10);
        pq.offer(20);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());  // Outputs in ascending order: 10, 20, 30
        }
    }
}
```

---

## Time Complexities

| Operation        | Simple Queue | Circular Queue | Priority Queue (Heap) |
|------------------|--------------|----------------|----------------------|
| Enqueue          | O(1)         | O(1)           | O(log n)             |
| Dequeue          | O(1)         | O(1)           | O(log n)             |
| Peek/Front       | O(1)         | O(1)           | O(1)                 |
| isEmpty/isFull   | O(1)         | O(1)           | O(1)                 |

---

## Applications

- **Simple Queue**: Task scheduling, buffering.
- **Circular Queue**: Resource sharing, CPU scheduling.
- **Priority Queue**: Dijkstra’s shortest path, Huffman coding, job scheduling.

---