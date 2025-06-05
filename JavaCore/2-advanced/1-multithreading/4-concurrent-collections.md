# Concurrent Collections

## Introduction

Concurrent collections are thread-safe alternatives to standard Java collection classes. They allow safe and efficient access and modification by multiple threads without requiring manual synchronization.

## Why Use Concurrent Collections?

- Avoids the need for external synchronization.
- Provides better scalability under high concurrency.
- Designed for high-performance in multithreaded environments.

## Key Classes in `java.util.concurrent`

### 1. `ConcurrentHashMap`

A thread-safe and highly efficient map implementation that allows concurrent read and write operations.

```java
ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
map.put("apple", 1);
map.put("banana", 2);

Integer value = map.get("apple");
```

**Features:**
- Segment-based locking (in Java 7) / finer-grained locks (in Java 8+).
- Allows full concurrency for read operations and configurable concurrency for updates.

### 2. `CopyOnWriteArrayList`
A thread-safe variant of `ArrayList` in which all mutative operations (add, set, remove) are implemented by making a fresh copy of the underlying array.

```java
CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
list.add("A");
list.add("B");

for (String item : list) {
    System.out.println(item);
}
```

**Use Case:** Suitable for use cases with frequent reads and infrequent writes.

### 3. `ConcurrentLinkedQueue`

A thread-safe, non-blocking FIFO queue.

```java
ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
queue.add("task1");
queue.add("task2");

String task = queue.poll(); // Retrieves and removes the head of the queue
```

**Use Case:** For producer-consumer scenarios with low-latency requirements.

### 4. `BlockingQueue` and Implementations

An interface representing a thread-safe queue that supports blocking operations.

**Common Implementations:**

- `ArrayBlockingQueue` – Bounded, backed by an array.
- `LinkedBlockingQueue` – Optionally bounded, backed by linked nodes.
- `PriorityBlockingQueue` – Elements are ordered according to their priority.
- `DelayQueue` – Elements become available after a delay.

```java
BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();

blockingQueue.put("element"); // waits if necessary
String value = blockingQueue.take(); // waits if empty
```

### 5. `ConcurrentSkipListMap` and `ConcurrentSkipListSet`

Thread-safe sorted map and set implementations using skip lists.

```java
ConcurrentSkipListMap<Integer, String> sortedMap = new ConcurrentSkipListMap<>();
sortedMap.put(1, "one");
sortedMap.put(3, "three");
sortedMap.put(2, "two");

for (Map.Entry<Integer, String> entry : sortedMap.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

## Best Practices

- Prefer concurrent collections over synchronizing standard collections manually.
- Choose the collection based on access patterns and concurrency requirements.
- Use `BlockingQueue` for producer-consumer designs.
- Avoid `CopyOnWriteArrayList` for frequent updates due to its high overhead on writes.
