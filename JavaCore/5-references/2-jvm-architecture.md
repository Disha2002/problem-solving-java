# JVM Architecture

## Overview

The Java Virtual Machine (JVM) is an abstract computing machine that enables a computer to run Java programs and programs written in other languages compiled to Java bytecode.

---

## Components of JVM

### 1. **Class Loader Subsystem**

- Loads `.class` files (bytecode) into the JVM.
- Performs:
  - **Loading:** Reads the bytecode.
  - **Linking:** Verifies, prepares, and optionally resolves symbolic references.
  - **Initialization:** Executes static initializers.

---

### 2. **Runtime Data Areas**

- **Method Area:**  
  Stores class-level data like class structures, constants, static variables, and method bytecode.

- **Heap:**  
  Runtime area for all objects and arrays. Shared among all threads.

- **Java Stacks:**  
  Each thread has its own stack containing frames. Each frame holds local variables, operand stack, and partial results for method invocations.

- **Program Counter (PC) Register:**  
  Contains the address of the JVM instruction currently being executed for each thread.

- **Native Method Stack:**  
  Supports native methods written in languages like C/C++.

---

### 3. **Execution Engine**

- **Interpreter:**  
  Reads and executes bytecode instructions one by one.

- **Just-In-Time (JIT) Compiler:**  
  Compiles frequently executed bytecode into native machine code to improve performance.

- **Garbage Collector (GC):**  
  Automatically manages memory by reclaiming unused objects.

---

### 4. **Native Interface (JNI)**

- Allows Java code running in JVM to interoperate with applications and libraries written in other languages like C, C++.

---

### 5. **Native Method Libraries**

- Collection of platform-specific libraries required for native method execution.

---

## JVM Memory Model Summary

| Area               | Purpose                                    | Shared/Thread-private |
|--------------------|--------------------------------------------|----------------------|
| Method Area        | Class info, static variables, constants    | Shared               |
| Heap               | Objects and arrays                          | Shared               |
| Java Stack         | Local variables, operand stack per method  | Thread-private       |
| PC Register        | Current instruction address                 | Thread-private       |
| Native Method Stack | Native method execution                      | Thread-private       |

---

## JVM Execution Process

1. **Loading**: Class loader loads `.class` files.
2. **Linking**: Verifies and prepares classes.
3. **Initialization**: Runs static initializers.
4. **Execution**: Execution engine interprets or JIT compiles bytecode.
5. **Garbage Collection**: Reclaims unused memory automatically.

---

## Garbage Collection (GC) Basics

- **Young Generation:**  
  Objects created recently. Minor GC happens here frequently.

- **Old Generation (Tenured):**  
  Objects that survive multiple GC cycles move here. Major GC less frequent but more expensive.

- **Permanent Generation (Metaspace in newer JVMs):**  
  Stores metadata required by JVM.

---

## Summary

The JVM architecture abstracts hardware and OS details, providing a platform-independent runtime environment with key components like class loading, runtime memory management, bytecode execution, and garbage collection to efficiently run Java applications.
