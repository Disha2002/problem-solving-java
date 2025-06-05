# Locks in Java

## Introduction

Locks provide a mechanism for **controlling access** to shared resources in concurrent programming. They help prevent race conditions by allowing only one thread to access a critical section at a time.

Java offers built-in synchronization and advanced lock implementations in the `java.util.concurrent.locks` package.

---

## Built-in Synchronization (`synchronized`)

- Used to lock methods or blocks.
- Implicitly acquires and releases the lock.
- Example:

```java
public synchronized void increment() {
    count++;
}
```

Or synchronized block:

```java
synchronized(this) {
    // critical section
}
```

---

## `Lock` Interface (java.util.concurrent.locks)

Provides more flexible and powerful locking than `synchronized`.

### Common Implementations

- `ReentrantLock` — A reentrant mutual exclusion lock with the same basic behavior as `synchronized` but more features.
- `ReadWriteLock` — Separates read and write locks for better concurrency.
- `ReentrantReadWriteLock` — Implementation of `ReadWriteLock`.

---

## ReentrantLock Example

```java
Lock lock = new ReentrantLock();

lock.lock();   // Acquire the lock
try {
    // critical section
} finally {
    lock.unlock(); // Release the lock
}
```

### Features:

- Can try to acquire lock without blocking: `tryLock()`.
- Supports interruptible lock acquisition: `lockInterruptibly()`.
- Fairness policy option to grant lock access in order.

---

## ReadWriteLock

Allows multiple readers to access the resource concurrently but only one writer at a time.

```java
ReadWriteLock rwLock = new ReentrantReadWriteLock();

Lock readLock = rwLock.readLock();
Lock writeLock = rwLock.writeLock();

// Reading
readLock.lock();
try {
    // read data
} finally {
    readLock.unlock();
}

// Writing
writeLock.lock();
try {
    // write data
} finally {
    writeLock.unlock();
}
```

---

## Advantages of Lock over synchronized

| Feature                 | `synchronized`          | `Lock` interface         |
|-------------------------|-------------------------|--------------------------|
| Interruptible waiting   | No                      | Yes                      |
| Try to acquire lock     | No                      | Yes (`tryLock()`)        |
| Multiple condition vars | No                      | Yes (`Condition` object) |
| Fairness control        | No                      | Yes                      |
| Non-block-structured    | No                      | Yes                      |

---

## Conditions

`Lock` provides `Condition` objects for thread communication (like `wait()`/`notify()`).

```java
Condition condition = lock.newCondition();

lock.lock();
try {
    while (!conditionMet) {
        condition.await();
    }
    // do work
} finally {
    lock.unlock();
}
```

---

## Best Practices

- Use `synchronized` for simple locking needs.
- Use `ReentrantLock` when you need advanced features (tryLock, fairness, interruptible).
- Use `ReadWriteLock` when many threads read but few write.
- Always release locks in `finally` blocks to avoid deadlocks.
