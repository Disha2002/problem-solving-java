# 🧬 Inheritance in Java

**Inheritance** allows one class to acquire properties and behaviors of another, promoting code reuse and logical hierarchy. In Java, it is implemented using the `extends` keyword.

---

## 🔹 Basics of Inheritance

A **subclass** (child) inherits fields and methods from a **superclass** (parent).

```java
// Superclass
public class Animal {
    public void eat() {
        System.out.println("Animal eats");
    }
}

// Subclass
public class Dog extends Animal {
    public void bark() {
        System.out.println("Dog barks");
    }
}

// Usage
Dog d = new Dog();
d.eat();  // Inherited
d.bark(); // Own method
```

---

## 🛠 The `super` Keyword

Used to refer to the **parent class**:

### Call Superclass Constructor

```java
public class Animal {
    Animal(String type) {
        System.out.println("Animal: " + type);
    }
}

public class Dog extends Animal {
    Dog() {
        super("Mammal"); // Must be first line
        System.out.println("Dog created");
    }
}
```

### Access Superclass Method

```java
public class Dog extends Animal {
    @Override
    public void eat() {
        super.eat(); // Call parent's eat
        System.out.println("Dog also eats");
    }
}
```

---

## 🧱 Inheritance Types in Java

| Type        | Description                          |
|-------------|--------------------------------------|
| Single      | One subclass extends one superclass  |
| Multilevel  | Class extends a subclass             |
| Hierarchical| Multiple classes extend one class    |

> ❌ **Java does not support multiple inheritance** with classes (but supports it via interfaces).

---

## ⚠️ Why No Multiple Inheritance?

To avoid the **Diamond Problem**:

```java
class A { void show() {} }
class B extends A {}
class C extends A {}
// class D extends B, C {} // Not allowed in Java
```

Use **interfaces** to achieve multiple inheritance of type.

---

## 🪜 Multilevel Inheritance

```java
class Animal {
    void eat() {}
}

class Mammal extends Animal {
    void walk() {}
}

class Dog extends Mammal {
    void bark() {}
}

// Dog → Mammal → Animal
```

---

## 👨‍👩‍👧 Hierarchical Inheritance

```java
class Animal {
    void breathe() {}
}

class Dog extends Animal {}
class Cat extends Animal {}
```

---

## 🚨 Method Overriding

A subclass provides its own version of an inherited method.

```java
class Animal {
    void makeSound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}
```

- Must have the **same method signature**.
- Cannot override `final` or `static` methods.
- Use `@Override` for compile-time safety.

---

## 🔐 Access Control in Inheritance

| Modifier   | Accessible in Subclass? |
|------------|--------------------------|
| `public`   | ✅ Yes                   |
| `protected`| ✅ Yes (even outside pkg)|
| `default`  | ✅ Yes (same package only)|
| `private`  | ❌ No                    |

---

## 🧠 Object Class – The Root

Every class in Java inherits from `java.lang.Object`.

```java
public class MyClass {
    // Inherits methods like toString(), equals(), hashCode(), etc.
}
```

---

## ✅ Best Practices

- Use inheritance for **"is-a"** relationships (e.g., Dog is-an Animal).
- Prefer **composition** over inheritance if relationship is **"has-a"**.
- Avoid deep inheritance chains (more than 2–3 levels).
- Keep superclasses abstract/general; subclasses specific.

---

## 📌 Summary Table

| Concept           | Description                                      |
|-------------------|--------------------------------------------------|
| `extends`         | Used to inherit a class                          |
| `super`           | Refers to parent class constructor/method        |
| Method overriding | Redefining a parent method in child              |
| Access control    | Determines what members are inherited/visible    |
| Object class      | Base class of all Java classes                   |

---

## 🧪 Example: Inheritance in Action

```java
class Shape {
    void draw() {
        System.out.println("Drawing shape");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing circle");
    }
}

class Square extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing square");
    }
}

public class Main {
    public static void main(String[] args) {
        Shape s1 = new Circle();
        Shape s2 = new Square();
        s1.draw(); // Drawing circle
        s2.draw(); // Drawing square
    }
}
```

> 🎯 Shows polymorphism via inheritance.

