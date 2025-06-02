# ⚙️ Guide to Operators in Java

Java operators provide powerful expression capabilities. For advanced developers, understanding **precedence, associativity, short-circuit evaluation, overflow behavior, and JVM-level implications** is critical for writing performant and predictable code.

---

## 1. 📚 Classification of Operators

| Category             | Operators |
|----------------------|----------|
| Arithmetic           | `+`, `-`, `*`, `/`, `%` |
| Unary                | `+`, `-`, `++`, `--`, `~`, `!` |
| Assignment           | `=`, `+=`, `-=`, etc. |
| Relational           | `==`, `!=`, `>`, `<`, `>=`, `<=` |
| Logical              | `&&`, `||`,`!` |
| Bitwise              | `&`, `|`,`^`,`~`,`<<`,`>>`,`>>>` |
| Ternary              | `? :` |
| `instanceof`         | `instanceof`, pattern matching |
| Lambda               | `->` |
| Method reference     | `::` |

---

## 2. 🧮 Precedence and Associativity

Java evaluates expressions based on **operator precedence** and **associativity**. Misunderstanding this can lead to subtle bugs.

```java
int result = 2 + 3 * 4; // result = 14, not 20
```

| Operator          | Associativity |
|-------------------|----------------|
| `=`               | Right to left  |
| `+`, `-`          | Left to right  |
| `*`, `/`, `%`     | Left to right  |

💡 Use parentheses for clarity in complex expressions.

---

## 3. ⚡ Short-Circuiting in Logical Operators

Logical AND (`&&`) and OR (`||`) use **short-circuit evaluation**:

```java
if (expensive() != null && expensive().isValid()) {
    ...
}
```

To force both expressions to evaluate, use bitwise `&` or `|`:

```java
if (a & b) { ... } // both are evaluated
```

---

## 4. 🧾 Bitwise and Shift Operators

Used in low-level tasks like encryption or performance tuning.

```java
int a = -8;
int signed = a >> 2;    // -2
int unsigned = a >>> 2; // large positive number
```

> Use `>>>` for unsigned right shift — only works on `int` and `long`.

---

## 5. ⚠️ Arithmetic Overflow and Underflow

Java’s integer arithmetic **wraps around** silently.

```java
int max = Integer.MAX_VALUE;
int result = max + 1; // -2147483648
```

Use `Math.addExact()` to catch overflow:

```java
int safe = Math.addExact(a, b); // throws ArithmeticException if overflow
```

---

## 6. ➕ Compound Assignment Nuances

Compound operators (`+=`, `*=`) may **implicitly cast**:

```java
byte b = 10;
b = b + 1;    // ❌ compile-time error
b += 1;       // ✅ implicit cast to byte
```

⚠️ Be explicit when needed to avoid hidden bugs.

---

## 7. ❓ Ternary Operator

Compact `if-else`:

```java
String label = (x > 0) ? "positive" : (x < 0) ? "negative" : "zero";
```

⚠️ Avoid deeply nested ternary expressions — use `switch` instead (Java 14+).

---

## 8. 🔍 `instanceof` and Pattern Matching

Improved type-checking in Java 16+:

```java
if (obj instanceof String s) {
    System.out.println(s.toLowerCase());
}
```

No need for extra casting — more readable and concise.

---

## 9. 🧩 Lambda and Method Reference

Though not operators in the traditional sense, they are syntax forms:

```java
Function<String, Integer> len = s -> s.length();
Function<String, Integer> len2 = String::length;
```

---

## 10. 🚀 Performance Considerations

- Prefer `++i` over `i++` when result is unused (loops, old Java).
- Use bitwise shift for power-of-two math:

```java
int doubled = x << 1; // x * 2
int halved  = x >> 1; // x / 2
```

⚠️ Watch for rounding issues with negatives.

---

## 11. 🚫 Operator Overload Emulation

Java doesn’t allow custom operator overloading, but method calls can emulate it:

```java
BigInteger a = new BigInteger("1000");
BigInteger b = new BigInteger("2000");
BigInteger sum = a.add(b); // instead of a + b
```

---

## 🧮 Summary Table

| Operator     | Context                  | Notes                            |
|--------------|---------------------------|----------------------------------|
| `==` / `!=`  | Object reference check     | Use `.equals()` for content      |
| `+=` / `-=`  | Compound assignment        | May cause implicit type casting  |
| `>>>`        | Unsigned shift             | Only for `int` and `long`        |
| `instanceof` | Type checking              | Pattern matching preferred (16+) |
| `++i` / `i++`| Loop increment             | `++i` preferred for performance  |
| `&`, `|`     | Bitwise ops                | Evaluate both sides              |

---

## 🔬 JVM and Bytecode Notes

- Java compiles operators to instructions like `iadd`, `isub`, `imul`, `ishl`.
- Compound ops can reduce stack usage and improve bytecode.
- Use `javap -c ClassName` to inspect bytecode.

---

## ✅ Best Practices

✔ Prefer readability over cleverness.  
✔ Avoid deep ternaries.  
✔ Use `Math.addExact`, etc., for overflow-sensitive logic.  
✔ Test performance assumptions with profiling.  
✔ Be explicit about types when necessary.

---
