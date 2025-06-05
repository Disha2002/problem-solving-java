# Stream Basics

## What is a Stream?

A **Stream** in Java is a sequence of elements supporting **functional-style operations** to process data declaratively. Streams do not store data; they operate on data sources like collections, arrays, or I/O channels.

## Key Characteristics

- **No storage:** A stream does not store elements; it conveys elements from a source.
- **Functional:** Operations are performed via functions (lambdas).
- **Lazy:** Intermediate operations are lazy; they execute only when a terminal operation is invoked.
- **Possibly infinite:** Streams can represent infinite sequences.
- **Can be parallel:** Easily parallelized for performance.

## Creating Streams

### From Collections

```java
List<String> list = Arrays.asList("a", "b", "c");
Stream<String> stream = list.stream();
```

### From Arrays

```java
Stream<Integer> stream = Arrays.stream(new Integer[] {1, 2, 3});
```

### From Values

```java
Stream<String> stream = Stream.of("x", "y", "z");
```

### Infinite Streams

```java
Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 1);
```

## Stream Pipeline

A stream pipeline consists of:

- **Source:** Collection, array, generator, etc.
- **Intermediate operations:** Transform data and return a new stream (lazy).
- **Terminal operation:** Produces a result or side-effect, triggers pipeline execution.

Example:

```java
List<String> filtered = list.stream()
                            .filter(s -> s.startsWith("a"))  // intermediate
                            .map(String::toUpperCase)         // intermediate
                            .collect(Collectors.toList());    // terminal
```

## Common Intermediate Operations

- `filter(Predicate)` – Select elements based on a condition.
- `map(Function)` – Transform elements.
- `flatMap(Function)` – Flatten nested streams.
- `distinct()` – Remove duplicates.
- `sorted()` – Sort elements.
- `limit(long)` – Limit number of elements.
- `skip(long)` – Skip first elements.

## Common Terminal Operations

- `forEach(Consumer)` – Perform action for each element.
- `collect(Collector)` – Gather elements into collections or other forms.
- `reduce(BinaryOperator)` – Combine elements to a single value.
- `count()` – Count elements.
- `anyMatch(Predicate)` – Check if any element matches.
- `allMatch(Predicate)` – Check if all match.
- `findFirst()` / `findAny()` – Get element if present.

## Example: Sum of Even Numbers

```java
int sum = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
```

## Parallel Streams

Parallel streams use multiple threads for processing.

```java
list.parallelStream()
    .filter(...)
    .forEach(...);
```

Use with care: not all operations are thread-safe or produce expected results in parallel.

## Summary

Streams simplify bulk data processing by combining multiple steps into readable pipelines with concise, declarative code.
