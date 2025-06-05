# List in Java

## Introduction

A `List` is an ordered collection in Java that allows duplicate elements. It maintains the insertion order and provides positional access and manipulation of elements.

`List` is part of the `java.util` package and is an interface. The most commonly used implementations are:

- `ArrayList`
- `LinkedList`
- `Vector`
- `Stack`

## Common Implementations

### 1. ArrayList

A resizable-array implementation of the `List` interface. It is fast for random access but slower for insertions and deletions in the middle.

```java
List<String> arrayList = new ArrayList<>();
arrayList.add("Apple");
arrayList.add("Banana");
arrayList.add("Cherry");
System.out.println(arrayList.get(1)); // Banana
```

### 2. LinkedList

A doubly-linked list implementation. It is efficient for insertions and deletions but slower for random access.

```java
List<String> linkedList = new LinkedList<>();
linkedList.add("Dog");
linkedList.add("Cat");
linkedList.add("Bird");
linkedList.remove("Cat");
```

### 3. Vector

Synchronized version of `ArrayList`. Rarely used today due to performance issues in a single-threaded context.

```java
List<Integer> vector = new Vector<>();
vector.add(10);
vector.add(20);
```

### 4. Stack

A subclass of `Vector` that implements a LIFO (last-in-first-out) stack.

```java
Stack<String> stack = new Stack<>();
stack.push("First");
stack.push("Second");
System.out.println(stack.pop()); // Second
```

## Common Operations

```java
List<String> list = new ArrayList<>();
list.add("A");
list.add("B");
list.add(1, "C");           // Insert at index 1
list.set(0, "Z");           // Update index 0
list.remove("C");           // Remove element
list.contains("B");         // Check existence
list.size();                // Get number of elements
list.clear();               // Remove all elements
```

## Iterating Over a List

### Using for-each loop:

```java
for (String item : list) {
    System.out.println(item);
}
```

### Using iterator:

```java
Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

### Using forEach (Java 8+):

```java
list.forEach(System.out::println);
```

## Best Practices

- Use `ArrayList` for frequent access and iteration.
- Use `LinkedList` for frequent insertions/removals.
- Avoid `Vector` and `Stack` in new code; prefer `ArrayDeque` for stack behavior.
- Prefer interface (`List`) type for declarations to allow flexibility.
