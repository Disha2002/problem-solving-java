# Understanding the `static` Keyword in Java: Why, Where, When, and How

---

## What is `static`?

`static` is a keyword in Java used to indicate that a variable, method, or nested class belongs to the **class itself** rather than any particular instance of the class.

---

## Why use `static`?

- **Why does `static` exist?**

  To share common data or behavior across all instances of a class without duplicating it for each object.

- **Why not make everything static?**

  Because instance-specific data and behavior are essential for object-oriented design — different objects should hold different states. Overusing static would make your code less flexible and harder to maintain.

---

## Where can you use `static`?

- On **variables**: for values shared by all objects (class variables).
- On **methods**: for operations that don’t depend on object state.
- On **nested classes**: to define classes logically grouped but independent of an instance of the outer class.
- On **blocks**: static initialization blocks run once when the class loads.

---

## When should you use `static`?

- When you want a single copy of a variable or method shared across all instances.
- When a method performs utility or helper functions and does not rely on instance data.
- When a nested class doesn’t need to access instance members of the outer class.
- When you want to initialize static data once (using static blocks).

---

## How does `static` work?

- A static member belongs to the class and is loaded into memory once when the class is first loaded by the JVM.
- You access static members using the class name (`ClassName.member`) rather than an instance.
- Static methods **cannot** access non-static (instance) members directly because instance members require an object.
- Static nested classes don’t have a reference to an outer class instance, so they cannot access non-static members directly.

---

## Examples & Explanation

### Static Variable Example

```java
class Counter {
    static int count = 0;  // Shared by all objects

    void increment() {
        count++;
    }
}

public class Test {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        c1.increment();
        c2.increment();
        System.out.println(Counter.count);  // Outputs 2
    }
}
