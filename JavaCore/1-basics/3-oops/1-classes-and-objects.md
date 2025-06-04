# 📦 Classes and Objects in Java

In Java, **classes** are blueprints for objects, and **objects** are instances of classes. They form the foundation of object-oriented programming (OOP).

---

## 🔹 What is a Class?

A **class** defines properties (fields) and behaviors (methods) common to all objects of that type.

```java
public class Car {
    // Fields (State)
    String brand;
    int speed;

    // Constructor
    public Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    // Method (Behavior)
    public void accelerate() {
        speed += 10;
    }

    public void display() {
        System.out.println(brand + " is going " + speed + " km/h");
    }
}
```

---

## 🔸 What is an Object?

An **object** is a real-world instance of a class, created using the `new` keyword.

```java
Car myCar = new Car("Toyota", 50);
myCar.accelerate();
myCar.display(); // Toyota is going 60 km/h
```

---

## 🛠 Components of a Class

| Component    | Description                              |
|-------------|------------------------------------------|
| Fields       | Variables that store the state           |
| Methods      | Functions that define behaviors          |
| Constructor  | Special method to initialize objects     |
| `this`       | Refers to the current object             |

```java
public class Dog {
    String name;

    // Constructor
    public Dog(String name) {
        this.name = name; // "this" refers to the field
    }

    public void bark() {
        System.out.println(name + " says Woof!");
    }
}
```

---

## 🚧 Constructor Overloading

You can define multiple constructors with different parameters.

```java
public class Book {
    String title;
    String author;

    // No-arg constructor
    public Book() {
        this("Untitled", "Unknown");
    }

    // Parameterized constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
```

---

## 📦 Object Creation and Usage

```java
Book b1 = new Book("1984", "George Orwell");
Book b2 = new Book(); // Uses default values
```

---

## 🔄 Method Overloading

Multiple methods with the same name but different parameters.

```java
public void print() { ... }
public void print(String msg) { ... }
public void print(int times) { ... }
```

---

## 📚 Access Modifiers

| Modifier   | Scope                                  |
|------------|-----------------------------------------|
| `public`   | Accessible from anywhere                |
| `private`  | Accessible only within the class        |
| `protected`| Accessible within package or subclass   |
| (default)  | Accessible within the same package      |

```java
public class Account {
    private double balance;

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}
```

---

## 🧠 Static Members

Belong to the **class**, not the object.

```java
public class MathUtils {
    public static int square(int x) {
        return x * x;
    }
}

// Usage
int result = MathUtils.square(5); // No object needed
```

---

## 📌 Summary

| Term         | Meaning                                      |
|--------------|----------------------------------------------|
| Class        | Blueprint or template for objects            |
| Object       | Instance of a class                          |
| Field        | Variable that holds data/state               |
| Method       | Function that defines behavior               |
| Constructor  | Initializes objects                          |
| `this`       | Refers to current object                     |
| `static`     | Shared by all instances of the class         |

---

## ✅ Best Practices

- Use meaningful class and method names.
- Keep fields private; expose behavior through methods.
- Use constructors for valid initialization.
- Leverage method and constructor overloading for flexibility.
- Prefer composition over inheritance unless required.

