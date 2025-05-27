# Java `Double` Class - Complete Study Guide

The `Double` class in Java is a wrapper class for the primitive type `double`. It belongs to the `java.lang` package and provides methods to handle double values as objects, useful in collections and utility operations.

---

## 1. Definition and Declaration

```java
public final class Double extends Number implements Comparable<Double>
```

- **Final class**: Cannot be subclassed.
- **Wrapper for `double`**: Allows using `double` values as objects.

---

## 2. Memory Representation

### Primitive `double`

- **Size**: 64 bits (8 bytes)
- **Standard**: IEEE 754 floating-point
- **Stored as**:
  - 1 bit for sign
  - 11 bits for exponent
  - 52 bits for mantissa (fraction)

### `Double` Object:

- Contains a single field of type `double`.
- In memory:
  - Object metadata (type info, hashcode, etc.)
  - 64-bit double field

**Note**: Object allocation adds overhead compared to the primitive.

---

## 3. Immutability

- `Double` objects are **immutable**.
- Once created, the internal value cannot be changed.

```java
Double a = 10.5;
// Cannot do: a.setValue(20.5); -- No such method
```

---

## 4. Constructors

```java
Double(double value)
Double(String s) throws NumberFormatException
```

---

## 5. Constants

```java
Double.POSITIVE_INFINITY
Double.NEGATIVE_INFINITY
Double.NaN
Double.MAX_VALUE        // ≈ 1.7976931348623157E308
Double.MIN_VALUE        // ≈ 4.9E-324
Double.SIZE             // 64
Double.BYTES            // 8
Double.TYPE             // double.class
```

---

## 6. Key Methods

### Value Retrieval

```java
doubleValue(), byteValue(), shortValue(), intValue(), longValue(), floatValue()
```

### Parsing & Conversion

```java
parseDouble(String s)
valueOf(String s)
valueOf(double d)
toString(), toHexString(double d)
```

### Comparison

```java
compareTo(Double o), compare(double d1, double d2)
equals(Object o), hashCode()
```

### Special Checks

```java
isNaN(double v)
isInfinite(double v)
```

---

## 7. Autoboxing & Unboxing

```java
Double obj = 10.5;     // Autoboxing
double val = obj;      // Unboxing
```

---

## 8. Floating-Point Precision

### Precision Loss

Due to binary representation:

```java
System.out.println(0.1 + 0.2); // 0.30000000000000004
```

### Safe Comparison

Use an epsilon (tolerance):

```java
Math.abs(a - b) < 1e-9
```

---

## 9. Best Practices

- Use `Double.compare(a, b)` instead of `==`.
- Prefer `BigDecimal` when high precision is required.
- Always check for `NaN` and `Infinity` when dealing with unknown values.

---

## 10. Example

```java
public class DoubleDemo {
    public static void main(String[] args) {
        Double d1 = Double.valueOf("15.75");
        double d2 = Double.parseDouble("20.25");

        System.out.println("Sum: " + (d1 + d2));

        if (Double.isNaN(d1)) {
            System.out.println("Not a number");
        }

        System.out.println("Comparison: " + Double.compare(d1, d2));
    }
}
```

---

## 11. Summary

| Feature | Description |
|--------|-------------|
| Wrapper for | `double` |
| Immutability | Yes |
| Memory size | 64 bits (primitive), object overhead for wrapper |
| Standard | IEEE 754 |
| Precision | ~15 decimal digits |
| Use cases | Collections, Utilities, Type conversions |

---
