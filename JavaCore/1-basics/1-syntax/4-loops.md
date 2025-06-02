# 🔁 Advanced Guide to Loops in Java

Loops are fundamental to iteration, but in high-performance and concurrent applications, understanding the trade-offs between loop constructs and iteration models becomes critical. This guide covers internal vs. external iteration, parallel constructs, loop optimizations, and pitfalls.

---

## 1. 🎯 Classic `for`, `while`, and `do-while`

### `for` Loop

```java
for (int i = 0; i < n; i++) {
    // deterministic iteration
}
```

- Ideal for known iteration counts.
- JVM can apply **loop unrolling** and **bounds check elimination**.

### `while` Loop

```java
while (!done()) {
    // sentinel-controlled
}
```

- Use when condition is dynamic or externally driven.

### `do-while` Loop

```java
do {
    // at least one execution
} while (check());
```

- Great for polling or retry mechanisms.

---

## 2. 🔄 Enhanced `for-each` Loop (External Iteration)

```java
for (Element e : collection) {
    process(e);
}
```

- Syntactic sugar for `Iterator`.
- **Limitations**:
  - Cannot remove elements.
  - Not safe with concurrent modification.

---

## 3. 🌊 Stream-Based Looping (Internal Iteration)

```java
list.stream().filter(x -> x > 0).forEach(System.out::println);
```

- Hides loop control.
- Enables **lazy evaluation**, **pipelining**, and **parallelism**.
- Overhead for small collections.

### Parallel Streams

```java
list.parallelStream()
    .map(this::compute)
    .forEachOrdered(System.out::println);
```

- Uses **ForkJoinPool.commonPool**.
- Use `forEachOrdered()` to preserve ordering.
- Avoid with shared mutable state or trivial operations.

---

## 4. ⚡ Loop Performance Patterns

### Loop Invariant Code Motion

```java
int len = list.size();
for (int i = 0; i < len; i++) {
    // faster than repeated list.size()
}
```

### Manual Loop Unrolling

```java
for (int i = 0; i < arr.length; i += 2) {
    process(arr[i]);
    if (i + 1 < arr.length) process(arr[i + 1]);
}
```

> Use only when profiling shows benefit — JVM may auto-optimize.

---

## 5. 🧵 Concurrent Looping Patterns

### Using `ConcurrentLinkedQueue`

```java
Queue<Task> tasks = new ConcurrentLinkedQueue<>();
Task t;
while ((t = tasks.poll()) != null) {
    process(t);
}
```

- Lock-free, thread-safe, efficient under contention.

### ForkJoin with Divide-and-Conquer

```java
RecursiveTask<Long> task = new RecursiveSum(arr, start, end);
long result = ForkJoinPool.commonPool().invoke(task);
```

- Good for CPU-bound workloads.
- Scales using work-stealing threads.

---

## 6. ⚠️ Avoiding Loop Pitfalls

| Pitfall                      | Explanation                                           |
|-----------------------------|-------------------------------------------------------|
| Infinite loop               | Missing updates or wrong conditions                   |
| `ConcurrentModificationException` | Unsafe collection changes during iteration        |
| Shared state in parallel    | Race conditions, corruption                           |
| Inefficient `.contains()`   | Leads to O(n²) if not optimized with a `Set`          |

### Fixing `.contains()` inefficiency:

```java
Set<Item> lookup = new HashSet<>(list2);
for (Item i : list1) {
    if (lookup.contains(i)) {
        // fast lookup
    }
}
```

---

## 7. 🧩 `Spliterator` for Custom Traversal

```java
Spliterator<String> spliterator = list.spliterator();
spliterator.tryAdvance(System.out::println);
```

- Enables **fine-grained traversal**.
- Supports **parallel splitting**.

---

## 8. 🧠 Loop Fusion and Data Locality

Combine multiple loops over the same data:

```java
// BAD
for (...) sum += arr[i];
for (...) count += arr[i] > 0 ? 1 : 0;

// GOOD
for (...) {
    sum += arr[i];
    count += arr[i] > 0 ? 1 : 0;
}
```

- Improves **cache utilization**.
- Reduces memory latency in hot loops.

---

## 9. 🧪 Loop Benchmarking with JMH

```java
@Benchmark
public void testForLoop() {
    for (int i = 0; i < data.length; i++) {
        consume(data[i]);
    }
}
```

- JMH = Java Microbenchmark Harness.
- Prevents dead-code elimination.
- Warms up JVM for accurate results.

---

## 10. 🔍 Loop Summary Table

| Loop Type         | Use Case                        | Notes                                      |
|------------------|----------------------------------|--------------------------------------------|
| `for` / `while`   | Precise control                 | Fastest, best for numeric indexing         |
| Enhanced for-each | Read-only iteration             | Clean syntax, not for mutation             |
| Stream API        | Declarative transformation      | Best for large, composable pipelines       |
| Parallel Stream   | Fork-join parallelism           | Avoid with shared state                    |
| Spliterator       | Custom traversal/splitting      | Use for optimized parallel streams         |
| ForkJoin Task     | Divide-and-conquer parallelism  | Ideal for recursive, CPU-bound workloads   |

---

## ✅ Final Tips

- 🔍 **Profile before parallelizing**.
- 🧮 **Precompute invariants** outside loops.
- 🚫 **Avoid unsafe mutations** inside iteration.
- 🧠 **Consider memory locality** in hot paths.
- 🛑 **Be explicit about concurrency** — don't assume safety.

---
