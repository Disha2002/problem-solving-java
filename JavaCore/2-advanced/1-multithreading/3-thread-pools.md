# Thread Pools

## What is a Thread Pool?

A thread pool is a collection of pre-instantiated reusable threads. It manages a pool of worker threads to execute submitted tasks efficiently without the overhead of creating a new thread for every task.

## Why Use Thread Pools?

- Reduces the overhead of thread creation.
- Reuses existing threads to improve performance.
- Provides control over the number of concurrent threads.
- Prevents resource exhaustion (e.g., too many threads).

## Creating Thread Pools in Java

Java provides the `ExecutorService` interface and the `Executors` utility class to create thread pools.

### Fixed Thread Pool

A pool with a fixed number of threads.

```java
ExecutorService executor = Executors.newFixedThreadPool(5);

for (int i = 0; i < 10; i++) {
    executor.execute(() -> {
        System.out.println("Running in thread: " + Thread.currentThread().getName());
    });
}

executor.shutdown();
```

### Cached Thread Pool

Creates new threads as needed but reuses previously constructed threads when available.

```java
ExecutorService executor = Executors.newCachedThreadPool();
```

### Single Thread Executor

A pool with only one thread. Tasks are executed sequentially.

```java
ExecutorService executor = Executors.newSingleThreadExecutor();
```

### Scheduled Thread Pool

Used to schedule tasks with a delay or periodically.

```java
ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

scheduler.schedule(() -> {
    System.out.println("Delayed task");
}, 5, TimeUnit.SECONDS);
```

## Submitting Tasks

- `execute(Runnable task)` – does not return a result.
- `submit(Callable<T> task)` – returns a `Future<T>` for result tracking.

```java
Future<Integer> future = executor.submit(() -> {
    return 42;
});

Integer result = future.get(); // waits for the result
```

## Shutting Down the Pool

- `shutdown()` – Initiates an orderly shutdown.
- `shutdownNow()` – Attempts to stop all active tasks immediately.
- `awaitTermination()` – Waits for termination for a specified time.

```java
executor.shutdown();
executor.awaitTermination(1, TimeUnit.MINUTES);
```

## Best Practices

- Always shut down the executor to free resources.
- Avoid using `Executors` factory methods in large-scale applications; prefer `ThreadPoolExecutor` for fine-grained control.
- Choose the right pool type based on workload characteristics.
