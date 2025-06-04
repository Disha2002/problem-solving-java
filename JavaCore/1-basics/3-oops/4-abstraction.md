# 🎭 Abstraction in Java

**Abstraction** is the process of hiding internal implementation details and showing only the necessary features. It’s one of the four core Object-Oriented Programming principles in Java.

---

## 🔹 Why Abstraction?

- Reduces complexity
- Enhances code reusability
- Isolates implementation changes
- Promotes separation of concerns

---

## 1. 🧱 Abstract Classes

An abstract class:

- Cannot be instantiated
- Can have abstract and concrete methods
- Can define constructors and member variables

```java
abstract class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    abstract void makeSound();

    void sleep() {
        System.out.println(name + " is sleeping");
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("Woof!");
    }
}
```

### ✅ Usage

```java
Animal a = new Dog("Max");
a.makeSound(); // Woof!
a.sleep();     // Max is sleeping
```

---

## 2. 🧩 Interfaces — Pure Abstraction

An interface:
- Only contains method signatures (until Java 8+)
- Provides full abstraction (before Java 8)
- Supports multiple inheritance

```java
interface Flyable {
    void fly();
}

class Bird implements Flyable {
    public void fly() {
        System.out.println("Bird is flying");
    }
}
```

### 🔄 Interface vs Abstract Class

| Feature            | Interface              | Abstract Class        |
|--------------------|------------------------|------------------------|
| Methods            | Abstract (default/static from Java 8) | Abstract + Concrete |
| Fields             | `public static final` only | Any access modifier     |
| Constructors       | ❌ Not allowed         | ✅ Allowed             |
| Inheritance        | Multiple               | Single                 |
| When to use        | Contract for capabilities | Shared base + partial impl |

---

## 3. 🧪 Java 8+ Interface Enhancements

### ✅ Default Methods

```java
interface Logger {
    default void log(String msg) {
        System.out.println("Log: " + msg);
    }
}
```

### ✅ Static Methods

```java
interface MathUtil {
    static int square(int x) {
        return x * x;
    }
}
```

> ⚠ Default methods should be used judiciously to avoid multiple inheritance ambiguities.

---

## 4. 🔐 Abstracting Behavior

Use abstraction to generalize behavior and decouple logic.

```java
interface PaymentProcessor {
    void pay(double amount);
}

class Paypal implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid via PayPal: $" + amount);
    }
}

class Checkout {
    private PaymentProcessor processor;

    Checkout(PaymentProcessor processor) {
        this.processor = processor;
    }

    void completeOrder(double total) {
        processor.pay(total);
    }
}
```

- Swap `Paypal` with `Stripe` or `ApplePay` — no changes to `Checkout`.

---

## 5. 🔄 Real-World Analogy

A TV remote is an abstraction:

- You press "volume up" without knowing the underlying circuit.
- You interact with **behavior**, not **implementation**.

---

## 6. ☕ Abstract Classes in Java API

- `AbstractList`, `AbstractMap` — partial implementations of `List`, `Map`
- `HttpServlet` — abstract class in web applications
- `InputStream`, `OutputStream` — base I/O classes

---

## 7. ✅ Best Practices

- Use **interfaces** for behavior definition.
- Use **abstract classes** when partial implementation is needed.
- Favor **composition** over deep inheritance.
- Keep abstractions **minimal and focused**.

---

## 8. 🧠 Advanced: Sealed Interfaces (Java 15+)

```java
sealed interface Shape permits Circle, Square {}

final class Circle implements Shape {}
final class Square implements Shape {}
```

- Restricts which classes can implement an interface.
- Improves exhaustiveness in `switch` expressions.

---

## 🔚 Summary

| Concept         | Purpose                        |
|-----------------|---------------------------------|
| Abstraction     | Hides internal details          |
| Abstract Class  | Base class with optional logic |
| Interface       | Contract for behavior           |
| Default Method  | Interface with shared logic     |
| Sealed Types    | Controlled extensibility        |

---

Abstraction is key to **modular, maintainable, and scalable** Java applications. It lets you write code that is easier to reason about, extend, and refactor.
