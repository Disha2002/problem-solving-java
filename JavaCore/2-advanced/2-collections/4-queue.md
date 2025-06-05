# Queue in Java

## Introduction

A `Queue` is a collection designed for holding elements prior to processing. It typically follows **FIFO** (First-In-First-Out) ordering, but other orderings are possible (e.g., priority queues).

The `Queue` interface is part of `java.util` and extends `Collection`.

## Common Implementations

### 1. LinkedList (as a Queue)

Implements the `Queue` interface and allows elements to be added at the end and removed from the front.

```java
Queue<String> queue = new LinkedList<>();
queue.add("A");
queue.add("B");
queue.add("C");

System.out.println(queue.poll()); // Removes and returns "A"
```

### 2. PriorityQueue

Orders elements according to their natural ordering or a custom comparator. Does not guarantee FIFO.

```java
Queue<Integer> pq = new PriorityQueue<>();
pq.add(30);
pq.add(10);
pq.add(20);

System.out.println(pq.poll()); // 10 (smallest first)
```

### 3. ArrayDeque

A resizable array-based implementation of the `Deque` interface, faster than `LinkedList`.

```java
Queue<String> deque = new ArrayDeque<>();
deque.add("X");
deque.add("Y");

System.out.println(deque.poll()); // X
```

### 4. BlockingQueue (in `java.util.concurrent`)

Used in concurrent applications. Supports thread-safe operations and blocking retrieval.

Common implementations:

- `ArrayBlockingQueue` (bounded)
- `LinkedBlockingQueue` (optionally bounded)
- `PriorityBlockingQueue` (priority-based)

```java
BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
blockingQueue.put("Task1");        // blocks if full
String task = blockingQueue.take(); // blocks if empty
```

## Common Operations

| Method       | Description                              |
|--------------|------------------------------------------|
| `add(e)`     | Adds element; throws if full             |
| `offer(e)`   | Adds element; returns false if full      |
| `remove()`   | Removes head; throws if empty            |
| `poll()`     | Removes head; returns null if empty      |
| `element()`  | Retrieves head; throws if empty          |
| `peek()`     | Retrieves head; returns null if empty    |

```java
Queue<Integer> q = new LinkedList<>();
q.offer(1);
q.offer(2);
System.out.println(q.peek());  // 1
System.out.println(q.poll());  // 1
System.out.println(q.size());  // 1
```

## Deque: Double-Ended Queue

`Deque` (Double-Ended Queue) allows insertion and removal at both ends.

```java
Deque<String> deque = new ArrayDeque<>();
deque.addFirst("First");
deque.addLast("Last");
System.out.println(deque.removeFirst()); // First
```

## Best Practices

- Use `LinkedList` or `ArrayDeque` for general FIFO queues.
- Use `PriorityQueue` when element order matters more than insertion order.
- Use `BlockingQueue` for producer-consumer scenarios.
- Prefer `offer`/`poll`/`peek` over `add`/`remove`/`element` to avoid exceptions in boundary cases.
