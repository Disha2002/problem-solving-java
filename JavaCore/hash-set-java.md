# 🧠 Java `HashSet` - Complete Guide

## 📌 What is a HashSet?

A `HashSet` is a part of Java’s `java.util` package that implements the **Set interface** and is backed by a **HashMap**. It **stores unique elements only**, does **not maintain insertion order**, and allows **null** values.

---

## 🧪 Why Use a HashSet?

- Ensures **no duplicates** are stored.
- Offers **constant-time (O(1)) performance** for add, remove, and contains operations.
- Useful when you need **fast lookup** of unique items (e.g., checking if an element exists).

---

## 🔍 How Does It Work Internally?

- `HashSet` uses a **`HashMap`** internally.
- When you add an element to a `HashSet`, it actually adds it as a key in a HashMap with a constant dummy value (`PRESENT`).
- Elements are stored in **buckets** based on their **hash code**.
- **Hash collisions** are handled using **linked lists** or **balanced trees** (in newer JDK versions).

```java
public class HashSet<E> extends AbstractSet<E>
    implements Set<E>, Cloneable, java.io.Serializable {

    private transient HashMap<E,Object> map;
    private static final Object PRESENT = new Object();
}
```

---

## 🛠️ Basic Operations

### ✅ Creating a HashSet

```java
import java.util.HashSet;

HashSet<String> set = new HashSet<>();
```

### ➕ Adding Elements

```java
set.add("apple");
set.add("banana");
set.add("apple"); // Duplicate, will be ignored
```

### ❌ Removing Elements

```java
set.remove("banana");
```

### 🔍 Searching Elements

```java
boolean exists = set.contains("apple"); // true
```

### 🔁 Traversing Elements

```java
for (String fruit : set) {
    System.out.println(fruit);
}
```

Or using Iterator:

```java
Iterator<String> it = set.iterator();
while (it.hasNext()) {
    System.out.println(it.next());
}
```

---

## 🚦 Time Complexity

| Operation | Time Complexity |
|-----------|------------------|
| Add       | O(1) avg         |
| Remove    | O(1) avg         |
| Contains  | O(1) avg         |
| Traverse  | O(n)             |

---

## 🧠 Characteristics

| Property       | Value                     |
|----------------|---------------------------|
| Duplicates     | Not allowed               |
| Null elements  | Allowed (only one)        |
| Order          | Not guaranteed            |
| Thread-safe    | No                        |
| Backed by      | HashMap                   |

---

## 📌 When to Use HashSet

- When you need to store unique elements.
- When order doesn't matter.
- When you need quick lookups (`contains`).
- When you're filtering duplicates.

---

## ⚠️ Important Notes

- Use `LinkedHashSet` if you want insertion order preserved.
- Use `TreeSet` if you want sorted elements.
- `HashSet` is **not synchronized**. Use `Collections.synchronizedSet()` or `ConcurrentSkipListSet` for thread-safe operations.

---

## 📦 Example

```java
import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(10); // duplicate, ignored

        System.out.println(numbers.contains(20)); // true

        for (int num : numbers) {
            System.out.println(num);
        }
    }
}
```

---

## 🧩 Real-World Use Cases

- Checking for duplicate usernames during registration.
- Keeping track of visited nodes in a graph.
- Fast membership testing.

---

## 🏁 Conclusion

`HashSet` is one of the most useful and performant data structures in Java for storing unique elements. It is simple, powerful, and highly efficient for many real-world applications.
