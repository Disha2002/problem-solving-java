# 🧯 Exception Handling in Java

Java provides a **robust exception handling mechanism** that separates error-handling code from regular logic. This guide walks you through from fundamentals to best practices for building resilient Java applications.

---

## 1. 🧠 What is an Exception?

An **exception** is an event that disrupts normal flow during execution.

- **Checked Exception**: Must be declared or handled.
- **Unchecked Exception**: Occurs at runtime, not required to be caught.
- **Error**: Serious problems like `OutOfMemoryError`, not meant to be caught.

---

## 2. 📦 Exception Class Hierarchy

```
java.lang.Object
  └── java.lang.Throwable
       ├── java.lang.Exception      ← checked
       │    └── java.io.IOException
       │    └── java.sql.SQLException
       └── java.lang.RuntimeException ← unchecked
            └── java.lang.NullPointerException
            └── java.lang.IllegalArgumentException
```

---

## 3. 🚨 try-catch Block

```java
try {
    // risky code
    int x = 1 / 0;
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero!");
}
```

- Catches the specific exception.
- Use the most specific type possible.

---

## 4. 🧼 finally Block

```java
try {
    openResource();
} catch (IOException e) {
    log(e);
} finally {
    closeResource(); // always runs
}
```

- Executes regardless of exception.
- Used for cleanup (files, DB connections).

---

## 5. 📤 throw Statement

You can **manually throw** an exception:

```java
public void setAge(int age) {
    if (age < 0) throw new IllegalArgumentException("Age must be non-negative");
}
```

- Only objects of type `Throwable` (or subclass) can be thrown.

---

## 6. 📜 throws Keyword

Declare that a method **may throw** a checked exception:

```java
public void readFile(String path) throws IOException {
    Files.readAllLines(Path.of(path));
}
```

- Caller must catch or declare.

---

## 7. ✅ Multi-Catch (Java 7+)

```java
try {
    riskyIO();
} catch (IOException | SQLException e) {
    log(e);
}
```

- Single block handles multiple types.

---

## 8. 🔁 Re-throwing Exceptions

```java
try {
    doWork();
} catch (Exception e) {
    throw new RuntimeException("Failed to do work", e);
}
```

- Wrap original for context.

---

## 9. 🪄 Custom Exceptions

```java
public class InvalidUserException extends Exception {
    public InvalidUserException(String message) {
        super(message);
    }
}
```

Use when standard exceptions don't capture domain meaning.

---

## 10. 📦 try-with-resources (Java 7+)

```java
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    System.out.println(br.readLine());
}
```

- Auto-closes resources implementing `AutoCloseable`.

---

## 11. ⚠️ Common Pitfalls

| Issue | Description |
|-------|-------------|
| Catching `Exception` | Too generic; hides bugs |
| Empty catch blocks | Swallows errors silently |
| Ignoring checked exceptions | Leads to incomplete error handling |
| Overuse of checked exceptions | Clutters method signatures |

---

## 12. 🌟 Best Practices

| Practice | Why? |
|---------|------|
| Use specific exception types | Better clarity and handling |
| Use unchecked for programmer errors | Don't force catch on `NullPointerException`, etc. |
| Log exceptions | Capture stack trace |
| Fail fast on unrecoverable issues | Don't hide fatal errors |
| Wrap exceptions for context | Preserve root cause and add info |

---

## 13. ✅ Checked vs Unchecked

| Type | Example | Handling |
|------|---------|----------|
| Checked | `IOException`, `SQLException` | Must catch or declare |
| Unchecked | `NullPointerException`, `IndexOutOfBoundsException` | Optional to catch |

---

## 14. 📐 Design Considerations

- Use **checked exceptions** when:
  - The caller can recover (e.g., file not found).
- Use **unchecked exceptions** when:
  - Caused by programming bugs (e.g., null pointer).
- Avoid creating exception-heavy code paths.

---

## 15. 🧪 Example: Validating Input

```java
public void register(String email) throws InvalidEmailException {
    if (!email.contains("@")) {
        throw new InvalidEmailException("Email must contain '@'");
    }
}
```

---

## 16. 🔁 Exception Chaining

```java
try {
    parse();
} catch (ParseException e) {
    throw new IllegalStateException("Parsing failed", e);
}
```

- Pass root cause to constructor.

---

## 17. 🧬 Exception Handling in Streams (Advanced)

```java
list.forEach(name -> {
    try {
        process(name);
    } catch (IOException e) {
        throw new UncheckedIOException(e);
    }
});
```

> Wrap checked exceptions in `UncheckedIOException` for lambdas.

---

## 18. Summary Table

| Concept | Keyword | Purpose |
|--------|---------|---------|
| Throw exception | `throw` | Raise an exception manually |
| Declare exception | `throws` | Warn callers of a possible exception |
| Catch exception | `try-catch` | Handle specific failures |
| Cleanup code | `finally` | Always run cleanup logic |
| Automatic cleanup | try-with-resources | Auto-close resources |
| Wrap cause | Exception chaining | Preserve context |

---

## Final Tips

✅ Favor meaningful, custom exceptions for domain errors.  
✅ Catch exceptions at appropriate level — not too high or low.  
✅ Avoid excessive checked exceptions in API design.  
✅ Always log the full stack trace for diagnostics.

