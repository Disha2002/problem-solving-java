# Synchronization

## What is Synchronization?

Synchronization is the mechanism to control access to shared resources in a multithreaded environment. It prevents thread interference and memory consistency errors by ensuring that only one thread accesses critical sections of code at a time.

## Why Synchronization is Needed

When multiple threads access a shared resource simultaneously, and at least one thread modifies it, data inconsistency and race conditions may occur. Synchronization ensures:

- Atomicity of operations
- Visibility of changes to shared variables
- Thread-safe access to critical sections

## Synchronized Methods

You can declare a method as `synchronized` so that only one thread can execute it on a given object at a time.

```java
public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}
```

## Synchronized Blocks

You can also synchronize only a portion of code using a synchronized block, which can improve performance by reducing the scope of synchronization.

```java
public class Counter {
    private int count = 0;
    private final Object lock = new Object();

    public void increment() {
        synchronized (lock) {
            count++;
        }
    }

    public int getCount() {
        synchronized (lock) {
            return count;
        }
    }
}
```

## Static Synchronization

Static methods can also be synchronized. In that case, the lock is on the `Class` object instead of an instance.

```java
public class SyncExample {
    private static int counter = 0;

    public static synchronized void increment() {
        counter++;
    }
}
```

## Intrinsic Locks and Monitors

Every Java object has an intrinsic lock (or monitor). When a thread enters a synchronized method/block, it acquires the lock. When it exits, it releases the lock. If another thread tries to enter a synchronized method/block on the same object, it is blocked until the lock is released.

## Deadlocks

A deadlock occurs when two or more threads are waiting for each other to release resources, and none of them proceeds. Avoid nested locks and always acquire multiple locks in a consistent order to prevent deadlocks.

## Best Practices

- Synchronize only what is necessary.
- Use synchronized blocks instead of methods when possible.
- Use `java.util.concurrent` classes for higher-level concurrency needs.
- Avoid unnecessary locking to maintain performance.
