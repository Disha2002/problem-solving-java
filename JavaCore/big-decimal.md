
# Java BigDecimal

## 📘 Overview

`BigDecimal` is a class in `java.math` package used for **high-precision arithmetic**, typically required in financial, scientific, and banking applications. It handles floating-point numbers with **arbitrary precision**, avoiding rounding issues common with `float` or `double`.

---

## 📦 Package

```java
import java.math.BigDecimal;
```

---

## 🎯 Key Features

- Arbitrary-precision signed decimal numbers.
- Immutable object (thread-safe).
- Supports all basic arithmetic operations.
- Provides control over rounding modes and scale.
- Avoids floating-point precision issues.

---

## 🧠 When to Use

- Financial calculations (e.g. currency).
- Scientific calculations with exact decimal representation.
- Avoiding floating-point rounding errors.

---

## ✅ Constructors

```java
BigDecimal(String val)
BigDecimal(double val)
BigDecimal(int val)
BigDecimal(long val)
BigDecimal(BigInteger val)
BigDecimal(char[] in)
```

**Best Practice:** Use `String` constructor to avoid floating-point issues:

```java
BigDecimal bd = new BigDecimal("0.1"); // Preferred
BigDecimal bdWrong = new BigDecimal(0.1); // May lead to precision errors
```

---

## 🔢 Basic Methods

| Method | Description |
|--------|-------------|
| `add(BigDecimal val)` | Returns sum |
| `subtract(BigDecimal val)` | Returns difference |
| `multiply(BigDecimal val)` | Returns product |
| `divide(BigDecimal val)` | Returns quotient |
| `divide(val, scale, roundingMode)` | Divide with rounding |
| `remainder(BigDecimal val)` | Returns remainder |
| `pow(int n)` | Returns value to the power `n` |
| `negate()` | Returns negative value |
| `abs()` | Returns absolute value |
| `compareTo(BigDecimal val)` | -1, 0, 1 based on comparison |
| `equals(Object obj)` | Compares values and scale |
| `stripTrailingZeros()` | Removes trailing zeros |

---

## 🧮 Rounding Modes

Use with `divide` or `setScale`:

```java
enum RoundingMode {
  CEILING, FLOOR, HALF_UP, HALF_DOWN, HALF_EVEN,
  DOWN, UP, UNNECESSARY
}
```

Example:

```java
bd.setScale(2, RoundingMode.HALF_UP);
```

---

## 🔍 Comparison

```java
bd1.compareTo(bd2) // returns -1, 0, or 1
bd1.equals(bd2) // compares value AND scale
```

**Note:** `compareTo()` is preferred for value comparison.

---

## 💡 Best Practices

- Always use `String` constructor for precision.
- Prefer `compareTo()` over `equals()` for numerical comparison.
- Use `scale()` and `setScale()` to manage decimal places.
- Avoid unnecessary conversions to `double`.

---

## 💼 Example Use Case

```java
import java.math.BigDecimal;
import java.math.RoundingMode;

public class FinanceCalc {
    public static void main(String[] args) {
        BigDecimal price = new BigDecimal("10.25");
        BigDecimal taxRate = new BigDecimal("0.0825");
        BigDecimal tax = price.multiply(taxRate).setScale(2, RoundingMode.HALF_UP);
        BigDecimal total = price.add(tax);

        System.out.println("Price: " + price);
        System.out.println("Tax: " + tax);
        System.out.println("Total: " + total);
    }
}
```

---

## 🧪 Common Interview Questions

1. Why prefer BigDecimal over double?
2. How to perform rounding with BigDecimal?
3. Difference between `equals()` and `compareTo()`?
4. How does BigDecimal handle scale and precision?
5. What are the performance trade-offs of using BigDecimal?

---

## 📚 Reference

- [Oracle BigDecimal Docs](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)
