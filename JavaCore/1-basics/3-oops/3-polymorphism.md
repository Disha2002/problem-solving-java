# 🔀 Polymorphism in Java

**Polymorphism** means “many forms”. In Java, it allows objects to behave differently based on their actual types, even if accessed through a common interface or superclass.

---

## 🔹 Types of Polymorphism

| Type               | Description                              |
|--------------------|------------------------------------------|
| Compile-time (Static) | Method overloading                     |
| Runtime (Dynamic)      | Method overriding and dynamic dispatch |

---

## 1. 🧪 Compile-Time Polymorphism — Method Overloading

Multiple methods with the same name but different parameter types or counts.

```java
class MathUtil {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

- The method is resolved at **compile time**.
- Return type does **not** affect overloading.

---

## 2. 🕹 Runtime Polymorphism — Method Overriding

A subclass provides a specific implementation of a method defined in its superclass.

```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Main {
    public static void main(String[] args) {
        Animal a = new Dog();  // upcasting
        a.sound();  // Dog barks (resolved at runtime)
    }
}
```

- This is called **dynamic method dispatch**.
- Decision is made at **runtime**, based on actual object type.

---

## 🔁 Upcasting and Downcasting

### Upcasting (Safe)

```java
Animal a = new Dog(); // Dog IS-A Animal
```

### Downcasting (Needs Check)

```java
Animal a = new Dog();
Dog d = (Dog) a; // OK

Animal x = new Animal();
// Dog d2 = (Dog) x; // Runtime ClassCastException
```

Use `instanceof` for safe downcasting.

```java
if (x instanceof Dog) {
    Dog d2 = (Dog) x;
}
```

---

## 🧩 Polymorphism with Interfaces

```java
interface Drawable {
    void draw();
}

class Circle implements Drawable {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Square implements Drawable {
    public void draw() {
        System.out.println("Drawing Square");
    }
}

public class Main {
    public static void render(Drawable d) {
        d.draw();
    }
}
```

- Method `draw()` behaves differently depending on the implementing class.
- Enables **loose coupling** and **plug-and-play behavior**.

---

## 🔐 Rules of Overriding

- Method name and parameters must match.
- Can’t override `final`, `private`, or `static` methods.
- Overriding method must not be more restrictive.

```java
public class Base {
    protected void show() {}
}

public class Sub extends Base {
    public void show() {} // OK - more accessible
}
```

---

## 🚨 Overloading vs Overriding

| Feature       | Overloading           | Overriding             |
|---------------|------------------------|-------------------------|
| Time          | Compile-time           | Runtime                 |
| Parameters    | Must differ            | Must be same            |
| Inheritance   | Not required           | Requires inheritance    |
| Return type   | Can differ             | Must be same or covariant |
| Access        | Any                    | Cannot reduce visibility |

---

## 🧠 Real-World Use

```java
public void printInvoice(Invoice i) {
    System.out.println(i.toString());
}
```

Whether `i` is a `SalesInvoice` or `RefundInvoice`, the correct `toString()` method runs — without the caller needing to know the type.

---

## 🧪 Example: Polymorphism in Action

```java
abstract class Employee {
    abstract double getSalary();
}

class Manager extends Employee {
    @Override
    double getSalary() {
        return 80000;
    }
}

class Developer extends Employee {
    @Override
    double getSalary() {
        return 60000;
    }
}

class Payroll {
    public static void printPay(Employee e) {
        System.out.println("Salary: " + e.getSalary());
    }

    public static void main(String[] args) {
        printPay(new Manager());
        printPay(new Developer());
    }
}
```

> 🔍 Prints different salaries based on the actual object — that's runtime polymorphism!

---

## ✅ Best Practices

- Favor polymorphism over `instanceof` + branching.
- Use interfaces to decouple behavior from implementation.
- Abstract classes are ideal for **default shared behavior**.
- Avoid excessive overloading that hurts readability.

---

## 🔚 Summary

| Concept           | Description                              |
|-------------------|------------------------------------------|
| Overloading       | Same method name, different signatures   |
| Overriding        | Redefine superclass method in subclass   |
| Runtime dispatch  | Determines method at runtime             |
| Interfaces        | Enable polymorphism across unrelated types |
| Abstract classes  | Allow partial implementation             |

---

Polymorphism is central to **OOP design** — enabling flexibility, extensibility, and maintainability in Java programs.
