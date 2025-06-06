# Stacks

## Overview

A **stack** is a linear data structure that follows the **Last In, First Out (LIFO)** principle. The last element added to the stack is the first one to be removed.

---

## Characteristics

- **LIFO** order.
- Operations happen at one end called the **top**.
- Supports two main operations:
  - **push** (insert element)
  - **pop** (remove element)
- Additional operation:
  - **peek** or **top** (view the top element without removing it)

---

## Stack Operations

| Operation | Description               | Time Complexity |
|-----------|---------------------------|-----------------|
| push      | Add element to top        | O(1)            |
| pop       | Remove element from top   | O(1)            |
| peek/top  | View top element          | O(1)            |
| isEmpty   | Check if stack is empty   | O(1)            |

---

## Stack Implementation (Java)

```java
class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;  // stack is initially empty
    }

    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stackArray[++top] = value;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1; // or throw exception
        }
        return stackArray[top--];
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}
```

---

## Applications of Stacks

1. **Expression Evaluation and Conversion**
   - Infix to Postfix/Prefix conversion.
   - Evaluating postfix expressions.

2. **Backtracking Algorithms**
   - Maze solving.
   - Puzzle games.

3. **Function Call Management**
   - Runtime stack for function calls and recursion.

4. **Undo Mechanism in Editors**
   - Storing previous states for undo operations.

5. **Parsing**
   - Syntax parsing in compilers.

---

## Example: Balanced Parentheses

Check if parentheses in an expression are balanced using a stack.

```java
public boolean isBalanced(String expr) {
    Stack<Character> stack = new Stack<>();
    for (char ch : expr.toCharArray()) {
        if (ch == '(') {
            stack.push(ch);
        } else if (ch == ')') {
            if (stack.isEmpty()) return false;
            stack.pop();
        }
    }
    return stack.isEmpty();
}
```

---

## Pros and Cons

**Advantages:**

- Simple and efficient.
- Easy to implement using arrays or linked lists.
- Constant time operations.

**Disadvantages:**

- Limited access to elements (only top).
- Fixed size if implemented with arrays (unless dynamic arrays used).

---