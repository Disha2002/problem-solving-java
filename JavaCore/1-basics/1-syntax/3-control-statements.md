# Guide to Control Statements in Java

Control statements dictate the flow of execution in a Java program. While they seem basic, their usage deeply affects **code predictability, performance, and readability**. This guide explores their advanced behaviors and best practices.

---

## 1. `if`, `else if`, `else`

Standard conditional branching with optional block omission.

### Best Practices

- Always use braces `{}` — omitting them can lead to errors during refactoring.
- For deeply nested conditionals, consider `switch` or guard clauses.

```java
if (condition) {
    // action
} else if (anotherCondition) {
    // action
} else {
    // fallback
}
```

> 🧠 **Advanced**: The compiler converts `if-else if` chains into jump tables or conditional branches depending on pattern density.

---

## 2. `switch` and Enhanced Switch Expressions (Java 14+)

### Traditional `switch`

```java
switch (day) {
    case MONDAY:
        break;
    default:
        break;
}
```

- Only works with `byte`, `short`, `char`, `int`, `enum`, and `String`.

### Enhanced `switch` (Java 14+)

```java
String result = switch (day) {
    case MONDAY, TUESDAY -> "Early week";
    case WEDNESDAY -> "Midweek";
    default -> "Later";
};
```

- **Expression-based**: Returns a value.
- **Exhaustiveness check** when used with `sealed` types or enums.
- `yield` is used if the branch contains a block:

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

## 3. `while`, `do-while`, and `for`

### `while` loop

```java
while (condition) {
    // repeated action
}
```

### `do-while` loop

Executes body **at least once**, which is useful in UI loops, polling, etc.

```java
do {
    // repeated action
} while (condition);
```

### `for` loop

```java
for (int i = 0; i < n; i++) {
    // iteration
}
```

> ✅ Use `for` over `while` when loop control is tightly bound to the logic (counter-based).

---

## 4. Enhanced `for-each` Loop

```java
for (String name : names) {
    // read-only access
}
```

- Uses an `Iterator` under the hood.
- Cannot remove elements directly; use explicit iterator if needed.

```java
Iterator<String> it = names.iterator();
while (it.hasNext()) {
    if (shouldRemove(it.next())) {
        it.remove();
    }
}
```

---

## 5. `break` and `continue`

### Basic Usage

- `break` exits the loop/switch entirely.
- `continue` skips current iteration and proceeds to the next.

### Labelled Breaks

```java
outer:
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (i == j) break outer;
    }
}
```

> ☠️ **Caution**: Labelled breaks reduce readability—use sparingly and only with nested control flows that require it.

---

## 6. `return` Statements and Void Context

- Use `return` to exit methods early—prefer guard clauses for readability.

```java
if (!valid(input)) return;
```

- In methods returning `void`, `return;` is optional but can clarify intent to exit early.

---

## 7. Pitfalls and Edge Cases

### Dead Code Elimination

The Java compiler disallows code after unconditional `return` or `throw`.

```java
return;
System.out.println("Unreachable"); // compile-time error
```

### Loop Variable Capture in Lambdas

```java
for (int i = 0; i < 3; i++) {
    Runnable r = () -> System.out.println(i); // unsafe before Java 8
}
```

> Java 8+ allows effective final inference, but **mutating captured loop variables** requires caution.

---

## 8. Concurrency Considerations

Avoid using control statements inside synchronized blocks with long-lived locks or I/O operations:

```java
synchronized (lock) {
    if (needsIO()) {
        // BAD: causes deadlocks or thread starvation
        performIO();
    }
}
```

Instead, refactor to minimize critical section scope.

---

## 9. Performance Insights

- JVM may unroll loops (with JIT help) for performance gains.
- Complex `if-else` chains vs `switch`:
  - Dense `switch` on enums may be optimized to **jump tables**.
  - Sparse values fall back to **lookup tables**.

---

## 10. Best Practices Summary

| Pattern | Recommendation |
|--------|----------------|
| Deep nesting | Use guard clauses or `switch` |
| `if` vs `switch` | Prefer enhanced `switch` for enums/sealed types |
| Loops | Prefer `for-each` when mutation is not needed |
| Early exit | Improves readability and reduces nesting |
| Labels | Avoid unless absolutely necessary |
| Braces | Always use braces—even for single-line blocks |

---

## Example: Pattern-Based Flow with Sealed Classes

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

> 🔍 This switch is exhaustive due to sealed class usage. Great for enforcing completeness at compile time.

---
