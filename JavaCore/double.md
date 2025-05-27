# Java `double` and `Double`

## 📘 Overview

- **`double`** is a **primitive data type** representing 64-bit double-precision floating-point numbers (IEEE 754 standard).  
- **`Double`** is the **wrapper class** for the primitive `double` type, providing useful methods and allowing `double` values to be used as objects.

---

## 📦 Declaration

### Primitive `double`

```java
double x = 3.14;
```

### Wrapper `Double`

```java
Double obj = Double.valueOf(3.14);
Double anotherObj = 2.5; // Autoboxing from double primitive
```

---

## 🎯 Key Features

### `double`

- 64-bit IEEE 754 floating-point.
- Approximate precision of 15–17 decimal digits.
- Used for numeric calculations with acceptable precision loss.
- Fast computation, primitive type.

### `Double`

- Object wrapper around `double`.
- Provides methods to manipulate and convert doubles.
- Can be used in collections and generics (which require objects).
- Supports special values like `NaN` and `Infinity` with helper methods.

---

## 🧠 When to Use

- Use **`double`** for numerical computations where performance is critical and approximate precision is okay.
- Use **`Double`** when you need to treat numeric values as objects, for example:
  - Storing in collections (`List<Double>`)
  - Using utility methods (`Double.parseDouble()`, `Double.isNaN()`, etc.)
  - Handling nullable double values (`Double` can be `null`).

---

## 🔢 Operations

### With primitive `double`:

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

This happens because floating-point numbers are approximated in binary. For exact calculations (e.g., financial apps), use `BigDecimal`.

---

## 🔍 Comparing Doubles

Avoid using `==` for floating-point comparison. Use epsilon-based comparison:

```java
double a = 0.1 + 0.2;
double b = 0.3;
double epsilon = 1e-9;

if (Math.abs(a - b) < epsilon) {
    System.out.println("Equal");
}
```

---

## 📚 The `Double` Wrapper Class

### Creating `Double` Objects

```java
Double d1 = Double.valueOf(3.14);
Double d2 = 2.5; // Autoboxing
```

### Common Useful Methods

| Method                     | Description                                    | Example                        |
|----------------------------|------------------------------------------------|------------------------------|
| `doubleValue()`            | Returns the primitive `double` value.          | `d1.doubleValue()`            |
| `isNaN()`                 | Checks if the value is NaN.                      | `Double.isNaN(d1)`            |
| `isInfinite()`            | Checks if the value is infinite.                 | `Double.isInfinite(d1)`       |
| `compare(double d1, d2)`  | Compares two doubles.                             | `Double.compare(1.5, 2.0)`    |
| `parseDouble(String s)`   | Parses a string into a `double`.                  | `Double.parseDouble("3.14")`  |
| `toString()`              | Converts the `Double` to a string.                | `d1.toString()`               |
| `MAX_VALUE`               | Constant for largest positive `double`.          | `Double.MAX_VALUE`            |
| `MIN_VALUE`               | Constant for smallest positive `double`.         | `Double.MIN_VALUE`            |
| `NaN`                    | Constant for “Not a Number” value.                 | `Double.NaN`                  |
| `POSITIVE_INFINITY`      | Constant for positive infinity.                    | `Double.POSITIVE_INFINITY`    |
| `NEGATIVE_INFINITY`      | Constant for negative infinity.                    | `Double.NEGATIVE_INFINITY`    |

---

## 📈 Type Conversion

```java
int i = 5;
double d = i;        // Implicit widening conversion (int -> double)
int j = (int) d;     // Explicit cast (double -> int)
```

---

## 🧪 Common Interview Questions

1. What is the difference between `double` and `Double` in Java?  
2. Why should you avoid using `==` for comparing doubles?  
3. What are common issues with floating-point arithmetic?  
4. When is it better to use `BigDecimal` instead of `double`?  
5. How does autoboxing and unboxing work for `Double`?  
6. How are special double values like NaN and Infinity handled?  

---

## 💡 Tips

- Use `double` for calculations needing speed and approximate precision.  
- Use `Double` when you need an object representation.  
- Use epsilon-based comparison to compare doubles.  
- Use `Double` utility methods for parsing and validation.  
- Avoid using `double` for financial or precise calculations; prefer `BigDecimal`.  

---

## 📚 Reference

- [Java SE Double API](https://docs.oracle.com/javase/8/docs/api/java/lang/Double.html)  
- [Java Primitive Data Types](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)  

