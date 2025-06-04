# 🔐 Encapsulation in Java

**Encapsulation** is the OOP principle of bundling data (fields) and methods that operate on that data into a single unit (class), while restricting external access to internal state.

---

## 1. 🎯 What is Encapsulation?

- **Data Hiding**: Prevents direct access to internal object details.
- **Control Access**: Through getters/setters or validation logic.
- **Improves Modularity**: Implementation can change without affecting callers.

```java
public class BankAccount {
    private double balance;

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
```

> External code can’t modify `balance` directly—only through controlled methods.

---

## 2. 🧱 Access Modifiers

| Modifier   | Access Level                            |
|------------|------------------------------------------|
| `private`  | Same class only                          |
| `default`  | Same package                             |
| `protected`| Package + subclasses                     |
| `public`   | Any class                                |

> ✅ Use `private` for fields, and expose behavior via `public` methods.

---

## 3. 🚫 Anti-pattern: Public Fields

```java
public class User {
    public String name; // ❌ breaks encapsulation
}
```

- No validation or control.
- Open to unintended mutation.
- Breaks future flexibility.

---

## 4. ✅ Best Practice: Private Fields + Getters/Setters

```java
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank())
            this.name = name;
    }
}
```

- Can validate input.
- Change internal logic without affecting API.

---

## 5. 🧠 Immutable Objects (Advanced Encapsulation)

- No setters.
- Fields are `final`.
- Ensures thread-safety and consistency.

```java
public final class Book {
    private final String title;
    private final String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
}
```

> Immutable objects are fully encapsulated and safe for sharing.

---

## 6. 🔄 Encapsulation in Practice

### ☑ Benefits

- Validates state changes
- Supports internal refactoring
- Prevents unintended interference

### 🔄 Use Cases

- Banking (no direct balance change)
- Configuration classes (immutability)
- APIs (hide implementation details)

---

## 7. 🧪 JavaBeans and POJOs

- **POJO** = Plain Old Java Object (just fields + accessors).
- **JavaBean** = POJO with:
  - No-arg constructor
  - Private fields
  - Public getters/setters
  - Serializable

```java
public class Customer {
    private String id;
    private String name;

    public Customer() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
```

---

## 8. ☕ Java API Examples

- `java.util.ArrayList` hides internal array
- `String` is immutable and fully encapsulated
- `System.out` is a public static final PrintStream but hides its implementation

---

## 9. 🔐 Final Tips

| Practice | Benefit |
|---------|---------|
| Private fields | Prevents direct access |
| Public methods | Control via API surface |
| Validation in setters | Safe state |
| Immutability | Thread-safety, predictability |
| No `public` fields | Maintainability |

---

## 🧩 Encapsulation vs Abstraction

| Feature          | Encapsulation             | Abstraction                |
|------------------|---------------------------|----------------------------|
| Focus            | Data access control       | Hiding implementation      |
| Visibility       | Private/internal           | Interface or abstract class|
| Purpose          | Protect object state      | Simplify usage             |

---

Encapsulation is the foundation of **robust, maintainable**, and **secure Java code**. Mastering it enables better design, prevents bugs, and supports future-proof APIs.
