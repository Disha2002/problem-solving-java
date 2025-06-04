# 📘 Reference Types in Java 

Java has four reference types:
- StrongReference
- SoftReference
- WeakReference
- PhantomReference

They differ in how they interact with garbage collection (GC).

---

## ✅ 1. Strong Reference (Default)

```java
Person p = new Person("Alice");
```

- Most common reference.
- Prevents GC as long as a variable points to the object.

---

## ♻️ 2. Soft Reference

```java
import java.lang.ref.SoftReference;

Data data = new Data();
SoftReference<Data> softRef = new SoftReference<>(data);
data = null; // Now only softly reachable

Data retrieved = softRef.get(); // null if GC'ed under memory pressure
```

- GC only if JVM is low on memory.
- Used for memory-sensitive caches.

---

## 🧹 3. Weak Reference

```java
import java.lang.ref.WeakReference;

Data data = new Data();
WeakReference<Data> weakRef = new WeakReference<>(data);
data = null;

Data retrieved = weakRef.get(); // Likely null after GC
```

- GC as soon as no strong refs exist.
- Common in weak maps (`WeakHashMap`) to avoid memory leaks.

---

## 👻 4. Phantom Reference

```java
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

ReferenceQueue<Data> queue = new ReferenceQueue<>();
PhantomReference<Data> phantomRef = new PhantomReference<>(new Data(), queue);
```

- `get()` always returns null.
- Used for **post-mortem cleanup**.
- Notified via `ReferenceQueue` **after** object is finalized but before memory is reclaimed.

---

## 🔍 Comparison Table

| Reference Type   | Cleared By GC | When?                         | Use Case                  |
|------------------|---------------|-------------------------------|---------------------------|
| Strong           | No            | Never (unless set to null)    | Default usage             |
| Soft             | Yes           | On memory pressure             | Memory-sensitive caching  |
| Weak             | Yes           | When no strong refs exist      | Listeners, `WeakHashMap` |
| Phantom          | Yes           | After finalization             | Cleanup, memory tracking  |

---

## ⚠️ Tips

- Always check `ref.get() != null` before using soft/weak refs.
- Phantom references require a `ReferenceQueue`.
- Avoid overusing weak/soft refs unless there's a real memory rationale.
- Use `Reference.reachabilityFence(obj)` (Java 9+) to prevent premature finalization in critical regions.

```java
Reference.reachabilityFence(criticalObject);
```
