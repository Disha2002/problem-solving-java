# Intermediate Operations

## What Are Intermediate Operations?

Intermediate operations transform a stream into another stream. They are **lazy**, meaning they don’t process data until a terminal operation is invoked.

## Common Intermediate Operations

### 1. `filter(Predicate<? super T> predicate)`

Filters elements based on a condition.

```java
stream.filter(s -> s.length() > 3);
```

### 2. `map(Function<? super T, ? extends R> mapper)`

Transforms each element into another form.

```java
stream.map(String::toUpperCase);
```

### 3. `flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)`

Flattens nested streams into a single stream.

```java
stream.flatMap(s -> Arrays.stream(s.split(" ")));
```

### 4. `distinct()`

Removes duplicate elements (based on `equals`).

```java
stream.distinct();
```

### 5. `sorted()`

Sorts elements in natural order.

```java
stream.sorted();
```

Or with a comparator:

```java
stream.sorted(Comparator.reverseOrder());
```

### 6. `peek(Consumer<? super T> action)`

Performs an action on each element as it passes through the pipeline, mainly for debugging.

```java
stream.peek(System.out::println);
```

### 7. `limit(long maxSize)`

Truncates the stream to contain at most `maxSize` elements.

```java
stream.limit(5);
```

### 8. `skip(long n)`

Skips the first `n` elements.

```java
stream.skip(2);
```

## Chaining Intermediate Operations

Intermediate operations can be chained to form a processing pipeline:

```java
stream.filter(s -> s.startsWith("A"))
      .map(String::toLowerCase)
      .distinct()
      .sorted();
```

## Notes

- Intermediate operations are **lazy** and do not trigger processing by themselves.
- They return a new stream, enabling fluent chaining.
- Order of intermediate operations can affect performance and results.

## Example

```java
List<String> names = Arrays.asList("Anna", "Bob", "Alice", "Adam", "Brian");

List<String> filteredNames = names.stream()
    .filter(name -> name.startsWith("A"))
    .map(String::toUpperCase)
    .sorted()
    .collect(Collectors.toList());

System.out.println(filteredNames); // [ADAM, ALICE, ANNA]
```
