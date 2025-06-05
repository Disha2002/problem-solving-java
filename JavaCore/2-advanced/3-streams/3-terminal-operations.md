# Terminal Operations

## What Are Terminal Operations?

Terminal operations produce a **result** or a **side-effect** from a stream pipeline and **trigger the execution** of all intermediate operations. After a terminal operation is invoked, the stream is considered consumed and cannot be reused.

## Common Terminal Operations

### 1. `forEach(Consumer<? super T> action)`

Performs an action on each element of the stream.

```java
stream.forEach(System.out::println);
```

### 2. `collect(Collector<? super T, A, R> collector)`

Transforms the elements into a collection or other container.

```java
List<String> list = stream.collect(Collectors.toList());
Set<String> set = stream.collect(Collectors.toSet());
Map<Integer, String> map = stream.collect(Collectors.toMap(String::length, Function.identity()));
```

### 3. `reduce(BinaryOperator<T> accumulator)`

Combines elements into a single value by repeatedly applying the accumulator.

```java
Optional<Integer> sum = stream.reduce((a, b) -> a + b);
```

With identity:

```java
Integer sum = stream.reduce(0, Integer::sum);
```

### 4. `count()`

Returns the number of elements in the stream.

```java
long count = stream.count();
```

### 5. `anyMatch(Predicate<? super T> predicate)`

Returns `true` if **any** elements match the given predicate.

```java
boolean hasNegative = stream.anyMatch(n -> n < 0);
```

### 6. `allMatch(Predicate<? super T> predicate)`

Returns `true` if **all** elements match the predicate.

```java
boolean allPositive = stream.allMatch(n -> n > 0);
```

### 7. `noneMatch(Predicate<? super T> predicate)`

Returns `true` if **no** elements match the predicate.

```java
boolean noNulls = stream.noneMatch(Objects::isNull);
```

### 8. `findFirst()`

Returns an `Optional` describing the **first** element of the stream.

```java
Optional<String> first = stream.findFirst();
```

### 9. `findAny()`

Returns an `Optional` describing **any** element of the stream, useful for parallel streams.

```java
Optional<String> any = stream.findAny();
```

## Notes

- Terminal operations mark the **end** of a stream pipeline.
- They **consume** the stream, which means the stream cannot be reused after.
- Some terminal operations (e.g., `forEach`) produce side effects.
- Others produce results (e.g., `collect`, `reduce`, `count`).

## Example

```java
List<String> names = Arrays.asList("Anna", "Bob", "Alice", "Adam", "Brian");

long countA = names.stream()
                   .filter(name -> name.startsWith("A"))
                   .count();

System.out.println("Count of names starting with A: " + countA);
```
