# Set in Java

## Introduction

A `Set` is a collection that **does not allow duplicate elements**. It models the mathematical set abstraction and is part of the `java.util` package.

The `Set` interface extends `Collection` and is implemented by several classes, including:

- `HashSet`
- `LinkedHashSet`
- `TreeSet`

## Common Implementations

### 1. HashSet

A `HashSet` stores elements using a hash table. It does not guarantee any specific order of elements.

```java
Set<String> hashSet = new HashSet<>();
hashSet.add("Apple");
hashSet.add("Banana");
hashSet.add("Apple"); // Duplicate, will be ignored

System.out.println(hashSet); // Order is not guaranteed
```

### 2. LinkedHashSet

A `LinkedHashSet` maintains insertion order using a linked list internally.

```java
Set<String> linkedHashSet = new LinkedHashSet<>();
linkedHashSet.add("Dog");
linkedHashSet.add("Cat");
linkedHashSet.add("Bird");

System.out.println(linkedHashSet); // Maintains insertion order
```

### 3. TreeSet

A `TreeSet` stores elements in **sorted order** using a Red-Black tree. It does not allow null elements.

```java
Set<Integer> treeSet = new TreeSet<>();
treeSet.add(10);
treeSet.add(5);
treeSet.add(20);

System.out.println(treeSet); // Output: [5, 10, 20]
```

## Common Operations

```java
Set<String> set = new HashSet<>();
set.add("A");
set.add("B");
set.remove("A");
set.contains("B"); // true
set.size();        // Number of elements
set.clear();       // Removes all elements
```

## Iterating Over a Set

### Using for-each loop:

```java
for (String item : set) {
    System.out.println(item);
}
```

### Using iterator:

```java
Iterator<String> iterator = set.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

### Using forEach (Java 8+):

```java
set.forEach(System.out::println);
```

## Set Operations (Using `retainAll`, `addAll`, `removeAll`)

```java
Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
Set<Integer> set2 = new HashSet<>(Arrays.asList(2, 3, 4));

set1.retainAll(set2); // Intersection: [2, 3]
set1.addAll(set2);    // Union
set1.removeAll(set2); // Difference
```

## Best Practices

- Use `HashSet` for general-purpose sets with no ordering needs.
- Use `LinkedHashSet` when insertion order must be preserved.
- Use `TreeSet` when natural ordering or custom sorting is required.
- Avoid using mutable objects as set elements if their hashCode or compareTo can change.
