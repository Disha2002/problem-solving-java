# Arrays in Java

## Overview

An **array** in Java is a container object that holds a fixed number of values of a single type. Each item in an array is called an **element**, and each element is accessed by its numerical index.

---

## Characteristics

- **Fixed Size**: You must specify the size when creating an array.
- **Zero-Based Indexing**: The first element is at index 0.
- **Homogeneous Data**: All elements must be of the same type.
- **Contiguous Memory**: Internally, elements are stored in contiguous memory.

---

## Array Declaration and Initialization

### Declaration

```java
int[] numbers;         // preferred
String names[];        // also valid
```

### Allocation

```java
numbers = new int[5];  // creates an array of size 5
```

### Initialization

```java
int[] numbers = {1, 2, 3, 4, 5};
String[] fruits = new String[] {"Apple", "Banana", "Mango"};
```

---

## Accessing Elements

```java
System.out.println(numbers[0]);  // prints first element
numbers[2] = 10;                 // updates third element
```

---

## Common Operations

| Operation           | Time Complexity |
|---------------------|------------------|
| Access (by index)   | O(1)             |
| Search              | O(n)             |
| Insertion (middle)  | O(n)             |
| Deletion            | O(n)             |

---

## Iterating Over Arrays

### Using for loop

```java
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

### Using enhanced for loop

```java
for (int num : numbers) {
    System.out.println(num);
}
```

---

## Example: Reverse an Array

```java
int[] arr = {1, 2, 3, 4, 5};
int n = arr.length;

for (int i = 0; i < n / 2; i++) {
    int temp = arr[i];
    arr[i] = arr[n - i - 1];
    arr[n - i - 1] = temp;
}
System.out.println(Arrays.toString(arr));  // [5, 4, 3, 2, 1]
```

---

## Example: Find Maximum Element

```java
int max = arr[0];
for (int i = 1; i < arr.length; i++) {
    if (arr[i] > max) {
        max = arr[i];
    }
}
System.out.println("Max: " + max);
```

---

## Applications

- Stacks, Queues, and other linear data structures.
- Storing and manipulating lists of data.
- Base for matrix operations and table-like data.

---

## Pros and Cons

**Advantages:**

- Simple syntax and fast access (O(1)).
- Easy to iterate and sort.

**Disadvantages:**

- Fixed size.
- Inserting/deleting elements can be inefficient.

---
