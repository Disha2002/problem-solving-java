# Primitive Data Types in Java

Java provides 8 primitive data types. These types are **not objects**, and they represent **low-level, raw values** used for performance and memory efficiency.

---

## 🔹 What Are Primitive Types?

Primitive types are **predefined by the Java language**. They are stored directly in memory (typically on the stack or as part of an object in the heap), and **do not have methods or properties** like objects.

---

## 🔸 List of Primitive Types

### 1. `byte`

- **Size:** 8 bits
- **Range:** -128 to 127
- **Use Case:** Memory-efficient storage for small numbers (e.g., file IO buffers).

```java
byte level = 120;
```

### 2. `short`

- **Size:** 16 bits
- **Range:** -32,768 to 32,767
- **Use Case:** Less commonly used; can reduce memory when large arrays of numbers are used.

```java
short age = 32000;
```

### 3. `int`

- **Size:** 32 bits
- **Range:** -2,147,483,648 to 2,147,483,647
- **Use Case:** Most commonly used integer type.

```java
int salary = 50000;
```

### 4. `long`

- **Size:** 64 bits
- **Range:** Very large (±9 quintillion)
- **Use Case:** When `int` is not enough; useful for timestamps, large IDs.

```java
long distance = 9876543210L;
```

### 5. `float`

- **Size:** 32 bits
- **Precision:** ~6-7 decimal digits
- **Use Case:** For fractional numbers with less precision.

```java
float pi = 3.14f;
```

### 6. `double`

- **Size:** 64 bits
- **Precision:** ~15 decimal digits
- **Use Case:** Default for decimal values; high precision calculations.

```java
double gravity = 9.80665;
```

### 7. `char`

- **Size:** 16 bits (Unicode)
- **Range:** '\u0000' to '\uffff'
- **Use Case:** For individual characters; supports global languages via Unicode.

```java
char symbol = '©';
```

### 8. `boolean`

- **Size:** JVM-dependent (commonly treated as 1 bit conceptually, but uses 1 byte)
- **Values:** `true`, `false`
- **Use Case:** For logical conditions and control flow.

```java
boolean isRunning = true;
```

---

## 🔹 Default Values

When declared as class fields (not local variables), primitives have default values:

| Type    | Default |
|---------|---------|
| byte    | 0       |
| short   | 0       |
| int     | 0       |
| long    | 0L      |
| float   | 0.0f    |
| double  | 0.0d    |
| char    | '\u0000'|
| boolean | false   |

---

## 🔸 Memory & Performance Insights

- **Stack vs Heap:** Local primitive variables are stored on the stack. Fields in objects reside in the heap as part of the object.
- **Avoiding Overhead:** Since primitives are not objects, there is **no method call overhead**, which is critical in performance-sensitive applications.
- **No Nulls:** Primitives can't be `null`, unlike object references. This prevents `NullPointerException` for primitives.

---

## 🔹 Autoboxing & Wrapper Classes

Java provides wrapper classes in `java.lang` to treat primitives as objects when needed (e.g., in collections).

| Primitive | Wrapper   |
|-----------|-----------|
| byte      | Byte      |
| short     | Short     |
| int       | Integer   |
| long      | Long      |
| float     | Float     |
| double    | Double    |
| char      | Character |
| boolean   | Boolean   |

Example:

```java
Integer boxedInt = 5; // Autoboxing
int unboxedInt = boxedInt; // Unboxing
```

> ⚠️ Autoboxing can lead to **unexpected performance issues** in tight loops or large data structures.

---

## 🔸 Advanced: Bit Manipulation with Primitives

Primitives, especially `int` and `long`, are commonly used for **bitwise operations**:

```java
int flags = 0b1010;
flags = flags | 0b0100; // Set a bit
boolean isSet = (flags & 0b0100) != 0;
```

---

## 🧠 JVM Considerations

- **Alignment & Padding:** On the JVM, fields may be padded for alignment, affecting memory layout.
- **Escape Analysis:** The JVM may optimize primitive allocations (e.g., eliminating boxing under certain conditions).

---

## ✅ Summary

Primitive types are:

- **Lightweight** and **fast**
- Used for **efficient memory and CPU usage**
- Cannot be `null` or carry behavior
- Often paired with **wrapper types** when object features are needed

Mastering primitives helps build a solid foundation in performance-oriented Java programming.
