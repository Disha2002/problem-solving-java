# Java `double`

## 📘 Overview

`double` is a **primitive data type** in Java used to represent **64-bit double-precision floating-point numbers**. It follows the IEEE 754 standard and is suitable for numerical calculations where **approximate precision** is acceptable.

---

## 📦 Declaration

```java
double x = 3.14;
```

---

## 🎯 Key Features

- 64-bit IEEE 754 floating-point.
- Approximate precision up to 15–17 decimal digits.
- Suitable for general scientific and engineering calculations.
- Fast computation due to hardware-level support.

---

## 🧠 When to Use

- Performance-critical numeric calculations.
- When absolute precision is not required (e.g., graphics, simulations).
- For simple averages, scientific formulas.

---

## 🆚 Compared to Other Types

| Type         | Precision       | Use Case                  |
|--------------|-----------------|---------------------------|
| `float`      | ~7 digits       | Lower precision, saves memory |
| `double`     | ~15–17 digits   | Default for decimals      |
| `BigDecimal` | Arbitrary       | High-precision finance     |

---

## 🔢 Operations

`double` supports standard arithmetic:

```java
double a = 10.0;
double b = 3.0;

double sum = a + b;
double diff = a - b;
double prod = a * b;
double quot = a / b;
double rem = a % b;
```

---

## ⚠️ Precision Issues

```java
System.out.println(0.1 + 0.2); // Outputs: 0.30000000000000004
```

This occurs due to binary representation limitations. For accurate financial or scientific computations, use `BigDecimal`.

---

## 🔍 Comparison Best Practice

Avoid `==` for comparing floating-point values. Use a tolerance (`epsilon`):

```java
double a = 0.1 + 0.2;
double b = 0.3;
double epsilon = 1e-9;

if (Math.abs(a - b) < epsilon) {
    System.out.println("Equal");
}
```

---

## 📚 Wrapper Class: `Double`

Java provides the `Double` class for object representation of `double`.

```java
Double obj = Double.valueOf(3.14);
double val = obj.doubleValue();
```

### Common Methods:

- `isNaN()`
- `isInfinite()`
- `compare(double d1, double d2)`
- `parseDouble(String s)`
- `toString()`

---

## 📈 Type Conversion

```java
int i = 5;
double d = i;        // Implicit
int j = (int) d;     // Explicit (cast)
```

---

## 🧪 Common Interview Questions

1. What is the difference between `float` and `double`?
2. Why can’t we use `==` to compare doubles reliably?
3. What are floating-point precision errors?
4. When should you use `BigDecimal` over `double`?
5. How is a `double` stored internally in Java?

---

## 💡 Tips

- Default type for decimal values in Java is `double`.
- Use `BigDecimal` when accuracy is more important than performance.
- Always use `Math.abs(a - b) < epsilon` for comparisons.

---

## 📚 Reference

- [Java SE Double API](https://docs.oracle.com/javase/8/docs/api/java/lang/Double.html)
