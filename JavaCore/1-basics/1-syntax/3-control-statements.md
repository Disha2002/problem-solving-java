# 🧭 Guide to Control Statements in Java

Control statements dictate the flow of execution in a Java program. While they seem basic, their usage deeply affects **code predictability, performance, and readability**. This guide explores their advanced behaviors and best practices.

---

## 1. ✅ `if`, `else if`, `else`

Standard conditional branching with optional block omission.

```java
if (condition) {
    // action
} else if (anotherCondition) {
    // action
} else {
    // fallback
}
```

### Best Practices

- Always use braces `{}` — omitting them can lead to refactoring errors.
- For deeply nested conditionals, prefer `switch` or guard clauses.

💡 **Advanced**: The compiler may optimize `if-else if` chains into jump tables or branches depending on structure.

---

## 2. 🔀 `switch` and Enhanced Switch Expressions (Java 14+)

### Traditional `switch`

```java
switch (day) {
    case MONDAY:
        // logic
        break;
    default:
        break;
}
```

- Supports `byte`, `short`, `char`, `int`, `enum`, `String`.

### Enhanced `switch` (Java 14+)

```java
String result = switch (day) {
    case MONDAY, TUESDAY -> "Early week";
    case WEDNESDAY -> "Midweek";
    default -> "Later";
};
```

- **Expression-based**: can return values.
- Supports **exhaustiveness checks** with enums/sealed types.

```java
int score = switch (grade) {
    case "A" -> 100;
    case "B" -> 80;
    default -> {
        log("Unknown grade");
        yield 0;
    }
};
```

---

## 3. 🔁 `while`, `do-while`, and `for`

### `while`

```java
while (condition) {
    // repeated action
}
```

### `do-while`

Executes body **at least once**.

```java
do {
    // run once first
} while (condition);
```

### `for`

```java
for (int i = 0; i < n; i++) {
    // iteration
}
```

💡 Prefer `for` when loop control is integral to logic.

---

## 4. 🔄 Enhanced `for-each` Loop

```java
for (String name : names) {
    // read-only
}
```

- Uses an `Iterator` under the hood.
- Can’t remove elements directly.

```java
Iterator<String> it = names.iterator();
while (it.hasNext()) {
    if (shouldRemove(it.next())) {
        it.remove();
    }
}
```

---

## 5. ⛔ `break` and `continue`

### Basic Usage

- `break`: exits loop or switch.
- `continue`: skips to next iteration.

### Labeled Usage

```java
outer:
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (i == j) break outer;
    }
}
```

⚠️ Labeled breaks are powerful but reduce clarity—use only when necessary.

---

## 6. 🔙 `return` and Void Context

```java
if (!valid(input)) return;
```

- Useful for **guard clauses**.
- In `void` methods, `return;` clarifies early exit but is optional.

---

## 7. 🚨 Pitfalls and Edge Cases

### Dead Code Elimination

```java
return;
System.out.println("Unreachable"); // compile-time error
```

### Lambda Variable Capture

```java
for (int i = 0; i < 3; i++) {
    Runnable r = () -> System.out.println(i); // pre-Java 8: risky
}
```

Java 8+ allows **effectively final** inference but be cautious with mutation.

---

## 8. 🧵 Concurrency Considerations

Avoid control logic inside synchronized blocks with blocking ops:

```java
synchronized (lock) {
    if (needsIO()) {
        performIO(); // BAD
    }
}
```

💡 Move long-running operations **outside** of critical sections.

---

## 9. ⚙️ Performance Insights

- JVM may **unroll** loops at runtime for speed.
- `if-else` vs `switch`:
  - Dense `switch`: jump table.
  - Sparse: lookup or cascaded ifs.

---

## 10. ✅ Best Practices Summary

| Pattern           | Recommendation                              |
|------------------|----------------------------------------------|
| Deep nesting      | Use guard clauses or enhanced `switch`       |
| `if` vs `switch`  | Prefer `switch` for enums/sealed types       |
| Loops             | Use `for-each` unless mutation is needed     |
| Early exit        | Reduces nesting, improves readability        |
| Labels            | Avoid unless absolutely necessary            |
| Braces            | Always use braces—even for 1-liners          |

---

## 11. 🧠 Pattern-Based Flow with Sealed Classes

```java
sealed interface Shape permits Circle, Square {}

record Circle(double r) implements Shape {}
record Square(double side) implements Shape {}

double area(Shape s) {
    return switch (s) {
        case Circle c -> Math.PI * c.r() * c.r();
        case Square sq -> sq.side() * sq.side();
    };
}
```

✅ Switch is exhaustive due to `sealed` type — safer and compiler-enforced.

---
