# Futures in Java

## What is a Future?

A **Future** represents the result of an asynchronous computation. It acts as a placeholder for a value that will be available later, allowing you to retrieve the result once it’s ready.

## Key Interface: `java.util.concurrent.Future<V>`

### Main Methods:

- `boolean cancel(boolean mayInterruptIfRunning)`  
  Attempts to cancel execution of the task.
  
- `boolean isCancelled()`  
  Returns `true` if the task was cancelled before completion.
  
- `boolean isDone()`  
  Returns `true` if the task completed (normally, via exception, or cancelled).
  
- `V get()`  
  Waits if necessary for the computation to complete, then retrieves the result.
  
- `V get(long timeout, TimeUnit unit)`  
  Waits up to the specified time for the computation to complete.

## How to Obtain a Future?

### Using `ExecutorService`

Submit a task (Callable or Runnable) to an ExecutorService:

```java
ExecutorService executor = Executors.newFixedThreadPool(2);

Callable<Integer> task = () -> {
    // Some long-running computation
    Thread.sleep(1000);
    return 42;
};

Future<Integer> future = executor.submit(task);
```

### Using `CompletableFuture` (Java 8+)

`CompletableFuture` extends `Future` and provides more features like chaining and callbacks.

```java
CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> {
    // Asynchronous task
    return 42;
});
```

## Getting Results

```java
try {
    Integer result = future.get(); // blocks until done
    System.out.println("Result: " + result);
} catch (InterruptedException | ExecutionException e) {
    e.printStackTrace();
}
```

You can also use `get` with timeout:

```java
try {
    Integer result = future.get(500, TimeUnit.MILLISECONDS);
} catch (TimeoutException e) {
    System.out.println("Task timed out.");
}
```

## Canceling a Future

```java
boolean cancelled = future.cancel(true); // attempts to interrupt if running
```

Check if cancelled or done:

```java
if (future.isCancelled()) {
    System.out.println("Task was cancelled");
} else if (future.isDone()) {
    System.out.println("Task completed");
}
```

## Example: Simple Future Usage

```java
ExecutorService executor = Executors.newSingleThreadExecutor();

Future<String> future = executor.submit(() -> {
    Thread.sleep(2000);
    return "Hello, Future!";
});

System.out.println("Doing other work...");

try {
    String result = future.get();
    System.out.println("Result: " + result);
} catch (InterruptedException | ExecutionException e) {
    e.printStackTrace();
}

executor.shutdown();
```

## Advantages of Futures

- Decouple task submission from result retrieval.
- Enable asynchronous and parallel processing.
- Allow cancellation and timeout control.

## CompletableFuture Highlights

- Supports chaining: `.thenApply()`, `.thenAccept()`
- Supports combining multiple futures: `.allOf()`, `.anyOf()`
- Can handle exceptions gracefully.

---

## Summary

Futures are powerful tools for handling asynchronous computations in Java, making concurrent programming easier and more flexible.
