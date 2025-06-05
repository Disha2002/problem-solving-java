# Atomic Variables in Java

## What Are Atomic Variables?

Atomic variables provide **lock-free**, **thread-safe** operations on single variables. They are part of the `java.util.concurrent.atomic` package.

These classes use low-level CPU instructions (like compare-and-swap) to ensure atomicity without using explicit synchronization.

## Common Atomic Classes

- `AtomicInteger` — Atomic operations on an `int`.
- `AtomicLong` — Atomic operations on a `long`.
- `AtomicBoolean` — Atomic operations on a `boolean`.
- `AtomicReference<V>` — Atomic operations on an object reference.

## Why Use Atomic Variables?

- To avoid explicit synchronization (`synchronized` blocks or locks).
- To achieve better performance in highly concurrent environments.
- To safely update counters, flags, or references without locks.

## Basic Operations

### Creating an Atomic Variable

```java
AtomicInteger atomicInt = new AtomicInteger(0);
```

### Getting the Value

```java
int value = atomicInt.get();
```

### Setting the Value

```java
atomicInt.set(5);
```

### Atomic Update Operations

- `incrementAndGet()` — Atomically increments by 1 and returns updated value.
- `getAndIncrement()` — Returns current value, then increments.
- `decrementAndGet()`
- `getAndDecrement()`
- `addAndGet(int delta)` — Atomically adds `delta`.
- `getAndAdd(int delta)`

Example:

```java
int newValue = atomicInt.incrementAndGet();
```

### Compare-And-Set (CAS)

Atomically sets the value if it matches the expected value.

```java
boolean updated = atomicInt.compareAndSet(expectedValue, newValue);
```

Returns `true` if successful, `false` otherwise.

## Example: Thread-safe Counter

```java
AtomicInteger counter = new AtomicInteger(0);

Runnable task = () -> {
    for (int i = 0; i < 1000; i++) {
        counter.incrementAndGet();
    }
};

Thread t1 = new Thread(task);
Thread t2 = new Thread(task);

t1.start();
t2.start();

t1.join();
t2.join();

System.out.println("Counter: " + counter.get()); // Should be 2000
```

## AtomicReference Example

```java
AtomicReference<String> atomicRef = new AtomicReference<>("initial");
atomicRef.compareAndSet("initial", "updated");
System.out.println(atomicRef.get()); // "updated"
```

## Best Practices

- Use atomic variables for single variable state updates in concurrent scenarios.
- For complex operations involving multiple variables, consider locks or other synchronization.
- Avoid excessive spinning on failed CAS operations.
