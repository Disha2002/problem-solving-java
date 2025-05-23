# 📘 Java Inner Classes

Java supports the concept of **inner classes**, which are classes defined within another class. These classes help logically group classes that are only used in one place, improve encapsulation, and can access members of the outer class.

---

🔹 What are Inner Classes?
Inner classes are classes defined within another class. They are associated with the outer class and can access its members, even if they are private.

🔹 Why use Inner Classes?

- Logical grouping of classes used only in one place.
- Better encapsulation.
- Code readability and maintenance.
- Can access private members of the outer class.

🔹 When to use Inner Classes?

- When the class is useful only to its enclosing class.
- When you want to tightly couple helper classes with their outer class.
- To implement callbacks or event listeners.

🔹 Where are Inner Classes declared?
Inner classes are declared inside another class. They can be:

- Inside methods
- Inside code blocks
- At class level

🔹 How to use Inner Classes?
You define them within an outer class using normal class syntax and access them using the outer class instance (unless `static`).

---

## 🧩 Types of Inner Classes

1. **Non-static Nested Class (Regular Inner Class)**
A class defined inside another class without the `static` modifier.

```java
class Outer {
    private String msg = "Hello from Outer";

    class Inner {
        void display() {
            System.out.println(msg);
        }
    }
}
```

**Usage:**

```java
Outer outer = new Outer();
Outer.Inner inner = outer.new Inner();
inner.display();
```

---

2. **Static Nested Class**
A class defined with the `static` keyword inside another class. Cannot access non-static members of the outer class.

```java
class Outer {
    static int data = 30;

    static class Inner {
        void display() {
            System.out.println("Data is " + data);
        }
    }
}
```

**Usage:**

```java
Outer.Inner inner = new Outer.Inner();
inner.display();
```

---

3. **Local Inner Class**
Defined inside a method and can access local variables (only if `final` or effectively final).

```java
class Outer {
    void outerMethod() {
        int num = 100;

        class LocalInner {
            void print() {
                System.out.println("Number is: " + num);
            }
        }

        LocalInner inner = new LocalInner();
        inner.print();
    }
}
```

---

4. **Anonymous Inner Class**
A class defined and instantiated at the same time for quick implementation, usually for interface or abstract class.

```java
abstract class Animal {
    abstract void sound();
}

class Test {
    public static void main(String[] args) {
        Animal dog = new Animal() {
            void sound() {
                System.out.println("Bark");
            }
        };
        dog.sound();
    }
}
```

---

## 📝 Summary Table

| Type                | Can Access Outer Non-Static? | Can Be Static? | Use Case                        |
|---------------------|------------------------------|----------------|---------------------------------|
| Regular Inner Class | ✅ Yes                        | ❌ No          | Helper class tightly coupled    |
| Static Nested Class | ❌ No                         | ✅ Yes         | Utility or constants class      |
| Local Inner Class   | ✅ (final/effectively final) | ❌ No          | Inside methods                  |
| Anonymous Class     | ✅ Yes                        | ❌ No          | One-time, quick implementation  |

---

## 🔚 Conclusion

Inner classes in Java help write clean, readable, and maintainable code by logically grouping classes. They’re an important feature for implementing event handling, callbacks, and building well-encapsulated components.
