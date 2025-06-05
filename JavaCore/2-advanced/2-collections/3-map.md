# Map in Java

## Introduction

A `Map` is an object that maps keys to values. It cannot contain duplicate keys, and each key can map to at most one value.

`Map` is part of the `java.util` package and is **not** a true `Collection`, but a separate interface.

## Common Implementations

### 1. HashMap

Stores key-value pairs using a hash table. Allows one null key and multiple null values. Order is not guaranteed.

```java
Map<String, Integer> map = new HashMap<>();
map.put("Apple", 1);
map.put("Banana", 2);
map.put("Apple", 3); // Overwrites the previous value

System.out.println(map.get("Apple")); // 3
```

### 2. LinkedHashMap

Maintains insertion order using a doubly-linked list.

```java
Map<String, String> linkedMap = new LinkedHashMap<>();
linkedMap.put("One", "1");
linkedMap.put("Two", "2");

System.out.println(linkedMap); // Maintains insertion order
```

### 3. TreeMap

Implements a sorted map using a Red-Black tree. Keys are sorted in natural order or by a custom comparator.

```java
Map<Integer, String> treeMap = new TreeMap<>();
treeMap.put(3, "Three");
treeMap.put(1, "One");
treeMap.put(2, "Two");

System.out.println(treeMap); // Sorted by keys: {1=One, 2=Two, 3=Three}
```

### 4. Hashtable (Legacy)

Synchronized version of `HashMap`. Slower and generally replaced by `ConcurrentHashMap`.

```java
Map<String, String> hashtable = new Hashtable<>();
hashtable.put("A", "Apple");
hashtable.put("B", "Banana");
```

## Common Operations

```java
Map<String, Integer> map = new HashMap<>();
map.put("Key1", 100);
map.put("Key2", 200);
map.get("Key1");          // Returns 100
map.containsKey("Key2");  // true
map.containsValue(300);   // false
map.remove("Key1");       // Removes entry
map.size();               // Number of entries
map.clear();              // Clears the map
```

## Iterating Over a Map

### 1. Using entrySet:

```java
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " => " + entry.getValue());
}
```

### 2. Using keySet:

```java
for (String key : map.keySet()) {
    System.out.println(key + " => " + map.get(key));
}
```

### 3. Using forEach (Java 8+):

```java
map.forEach((k, v) -> System.out.println(k + ": " + v));
```

## Null Handling

- `HashMap` allows one null key and many null values.
- `TreeMap` does **not** allow null keys (throws `NullPointerException`).
- `Hashtable` does **not** allow null keys or null values.

## Best Practices

- Use `HashMap` for general-purpose mapping.
- Use `LinkedHashMap` if order of insertion matters.
- Use `TreeMap` if sorted keys are required.
- Avoid using mutable objects as keys.
- For thread safety, use `ConcurrentHashMap` instead of synchronizing a `HashMap`.
