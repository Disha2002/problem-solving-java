# Advanced Guide to Loops in Java

Loops are fundamental to iteration, but in high-performance and concurrent applications, understanding the trade-offs between loop constructs and iteration models becomes critical. This guide covers internal vs. external iteration, parallel constructs, loop optimizations, and pitfalls.

---

## 1. Classic `for`, `while`, and `do-while`

### `for` Loop

```java
for (int i = 0; i < n; i++) {
    // deterministic iteration
}
```

- Ideal when the number of iterations is known.
- JVM JIT can apply **loop unrolling** and **bounds check elimination** for primitive arrays.

### `while` Loop

```java
while (!done()) {
    // sentinel-controlled
}
```

- Prefer when termination condition is non-numeric or externally influenced.

### `do-while` Loop

```java
do {
    // at least one execution
} while (check());
```

- Useful for polling or retry logic where a first attempt is mandatory.

---

## 2. Enhanced `for-each` Loop (External Iteration)

```java
for (Element e : collection) {
    process(e);
}
```

- Internally translated to an `Iterator` loop.
- Not suitable for:
  - Removing elements mid-iteration.
  - Concurrent modifications (unless using `CopyOnWriteArrayList` or `ConcurrentLinkedQueue`).

---

## 3. Stream-Based Looping (Internal Iteration)

```java
list.stream().filter(x -> x > 0).forEach(System.out::println);
```

- Abstracts away loop control.
- Enables **lazy evaluation**, **pipelining**, and **parallel execution**.
- May incur overhead for small data sets; best suited for large or complex pipelines.

### Parallel Streams

```java
list.parallelStream()
    .map(this::compute)
    .forEachOrdered(System.out::println);
```

- Leverages **ForkJoinPool.commonPool**.
- Non-deterministic ordering unless `forEachOrdered` is used.
- Avoid if:
  - Tasks are lightweight (parallelism overhead dominates).
  - You use shared mutable state.

---

## 4. Loop Performance Patterns

### Loop Invariant Code Motion

Avoid computing the same value repeatedly:

```java
int len = list.size(); // avoid list.size() in loop condition
for (int i = 0; i < len; i++) { ... }
```

### Loop Unrolling (Manual)

```java
for (int i = 0; i < arr.length; i += 2) {
    process(arr[i]);
    if (i + 1 < arr.length) process(arr[i + 1]);
}
```

> ❗️Use only if profiling confirms benefit — modern JIT compilers already apply this where effective.

---

## 5. Concurrent Looping Patterns

### `ConcurrentLinkedQueue` with Manual Loop

```java
Queue<Task> tasks = new ConcurrentLinkedQueue<>();
while (Task t = tasks.poll()) != null {
    process(t);
}
```

- Non-blocking.
- Safe under concurrent modifications.

### `ForkJoinPool` with Divide-and-Conquer Looping

```java
RecursiveTask<Long> sumTask = new RecursiveSum(arr, start, end);
long result = ForkJoinPool.commonPool().invoke(sumTask);
```

- Efficient for CPU-bound recursive tasks.
- Use work-stealing to balance load.

---

## 6. Avoiding Loop Pitfalls

| Pitfall | Explanation |
|--------|-------------|
| Infinite loop | Caused by non-updating loop variable or incorrect condition |
| ConcurrentModificationException | Happens when modifying a collection during enhanced for-each |
| Shared state in parallel streams | Leads to race conditions and data corruption |
| Inefficient `contains()` in loop | O(n²) behavior — use a `Set` for lookups |

```java
// BAD: O(n²)
for (Item i : list1) {
    if (list2.contains(i)) { ... }
}

// BETTER
Set<Item> lookup = new HashSet<>(list2);
for (Item i : list1) {
    if (lookup.contains(i)) { ... }
}
```

---

## 7. Using `Spliterator` for Custom Traversal

```java
Spliterator<String> spliterator = list.spliterator();
spliterator.tryAdvance(System.out::println);
```

- Supports **parallel decomposition**.
- Use when building **custom stream pipelines** or when controlling traversal.

---

## 8. Loop Fusion and Combining Passes

Multiple loops over the same dataset can often be fused for better cache performance:

```java
// BAD
for (...) sum += arr[i];
for (...) count += arr[i] > 0 ? 1 : 0;

// BETTER
for (...) {
    sum += arr[i];
    count += arr[i] > 0 ? 1 : 0;
}
```

> 🧠 JVM may not always optimize this automatically. Manual fusion may help in hot paths.

---

## 9. Benchmarking Loops (JMH)

Use **JMH** for micro-benchmarking loop performance:

```java
@Benchmark
public void testForLoop() {
    for (int i = 0; i < data.length; i++) {
        consume(data[i]);
    }
}
```

> JMH prevents dead-code elimination, warms up the JIT, and gives statistically meaningful results.

---

## 10. Summary Table

| Loop Type | Use Case | Notes |
|-----------|----------|-------|
| `for` / `while` | Precise control, numeric | Fastest, most predictable |
| Enhanced for-each | Read-only iteration | No removal or mutation |
| Stream / parallelStream | Declarative pipelines | May introduce overhead |
| `Spliterator` | Custom parallel traversal | Fine-grained control |
| `ForkJoin` | Recursive tasks | Ideal for divide-and-conquer |

---

## Final Tips

✅ Profile before parallelizing loops.  
✅ Precompute loop-invariant expressions.  
✅ Avoid modifying collections during iteration unless safe.  
✅ Consider memory locality and cache behavior in large-scale loops.  
✅ Be explicit about shared state in concurrent iterations.

---
