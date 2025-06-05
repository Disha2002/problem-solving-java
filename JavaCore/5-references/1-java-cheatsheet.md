# Java Cheatsheet

## Basics

- **Data Types:**
  - Primitive: `int`, `long`, `double`, `float`, `char`, `byte`, `short`, `boolean`
  - Reference: Objects, arrays, interfaces

- **Control Structures:**

  ```java
  if (condition) { ... } else { ... }
  switch (variable) {
    case value: ...
    default: ...
  }
  for (int i = 0; i < n; i++) { ... }
  while (condition) { ... }
  do { ... } while (condition);
  ```

- **Methods:**

  ```java
  public returnType methodName(params) { ... }
  ```

---

## Object-Oriented Concepts

- **Class:**

  ```java
  public class MyClass {
      private int field;
      public void method() { ... }
  }
  ```

- **Inheritance:**

  ```java
  public class SubClass extends SuperClass { ... }
  ```

- **Interfaces:**

  ```java
  public interface MyInterface {
      void method();
  }
  ```

- **Abstract Class:**

  ```java
  public abstract class AbstractClass {
      abstract void method();
  }
  ```

---

## Common Keywords

- `final` — constants, non-overridable methods, non-subclassable classes
- `static` — belongs to the class rather than instance
- `this` — refers to current object
- `super` — refers to superclass members
- `new` — instantiate objects
- `try-catch-finally` — exception handling
- `synchronized` — thread synchronization
- `volatile` — variable visibility in threads

---

## Exception Handling

```java
try {
    // code
} catch (ExceptionType e) {
    // handle exception
} finally {
    // cleanup
}
```

---

## Collections Framework

- **List:** Ordered collection, allows duplicates  
  `ArrayList`, `LinkedList`

- **Set:** Unique elements, no duplicates  
  `HashSet`, `TreeSet`

- **Map:** Key-value pairs  
  `HashMap`, `TreeMap`, `ConcurrentHashMap`

- Use `Collections.unmodifiableList()` to create immutable collections.

---

## Generics

```java
List<String> list = new ArrayList<>();
public <T> void method(T param) { ... }
```

---

## Streams (Java 8+)

```java
List<String> filtered = list.stream()
    .filter(s -> s.startsWith("A"))
    .sorted()
    .collect(Collectors.toList());
```

---

## Lambda Expressions

```java
(parameters) -> expression
() -> System.out.println("Hello");
(x, y) -> x + y;
```

---

## Common APIs

- **String:** `length()`, `substring()`, `equals()`, `trim()`, `split()`
- **Math:** `Math.abs()`, `Math.max()`, `Math.min()`, `Math.random()`
- **System:** `System.out.println()`, `System.currentTimeMillis()`
- **Files (Java NIO):**

  ```java
  Files.readAllLines(Path.of("file.txt"));
  Files.write(Path.of("file.txt"), data);
  ```

---

## Multithreading

- Creating thread:

```java
Thread thread = new Thread(() -> {
    // task code
});
thread.start();
```

- Synchronization:

```java
synchronized(this) {
    // critical section
}
```

- Executors:

```java
ExecutorService executor = Executors.newFixedThreadPool(5);
executor.submit(() -> { /* task */ });
executor.shutdown();
```

---

## Useful Tips

- Use `try-with-resources` for automatic resource management:

```java
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    // use br
}
```

- Override `toString()`, `equals()`, and `hashCode()` in custom classes.
- Use annotations: `@Override`, `@Deprecated`, `@SuppressWarnings`.

---

## Java Versions Features Summary

- **Java 8:** Lambdas, Streams, Optional, Date/Time API
- **Java 9+:** Modules, JShell
- **Java 11:** String methods, HTTP Client API
- **Java 17:** Sealed classes, pattern matching (preview)

---

## Summary

This cheatsheet covers core Java syntax, OOP principles, common APIs, concurrency basics, and modern language features to quickly reference essentials during development.
