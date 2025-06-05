# Thread Basics

## What is a Thread?

A thread is the smallest unit of execution within a process. Multiple threads can exist within a single process and share the same memory space.

## Creating Threads

There are two main ways to create a thread in Java:

### 1. Extending the `Thread` Class

You can create a new thread by extending the `Thread` class and overriding its `run()` method.

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start(); // Starts the new thread
    }
}
```

### 2. Implementing the `Runnable` Interface

Another common approach is to implement the `Runnable` interface and pass it to a `Thread` object.

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable running");
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start(); // Starts the new thread
    }
}
```

## Thread Lifecycle

A thread goes through several states in its lifecycle:

- **New** – A thread instance is created but not yet started.
- **Runnable** – After calling `start()`, the thread is ready to run.
- **Running** – The thread is executing.
- **Blocked/Waiting** – The thread is paused, waiting for a monitor lock or signal.
- **Terminated** – The thread has completed its execution or was stopped.

## Common Thread Methods

- `start()` – Starts the thread.
- `run()` – The code that the thread executes.
- `sleep(long millis)` – Puts the thread to sleep for a specified time.
- `join()` – Waits for the thread to die.
- `interrupt()` – Interrupts the thread.

## Thread Priorities

Java threads have a priority that helps the thread scheduler determine the order of thread execution. It ranges from:

- `Thread.MIN_PRIORITY` (1)
- `Thread.NORM_PRIORITY` (5) — default
- `Thread.MAX_PRIORITY` (10)

## Best Practices

- Minimize shared mutable state.
- Use synchronization or concurrent utilities to handle shared resources.
- Avoid creating too many threads manually; prefer using thread pools.
- Keep thread tasks short and focused.
