# Linked Lists

Linked Lists are a linear data structure where elements are stored in nodes. Each node contains data and a reference (or pointer) to the next node in the sequence.

---

## Types of Linked Lists

### 1. Singly Linked List

- Each node points to the next node.
- Traversal is only forward.
- The last node points to `null`.

### Node Structure (Java)

```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```

### Basic Operations

- **Insertion at head**
- **Insertion at tail**
- **Deletion**
- **Traversal**

---

### 2. Doubly Linked List

- Each node contains two pointers: `next` and `prev`.
- Can be traversed both forward and backward.
- More memory than singly linked lists due to extra pointer.

### Node Structure (Java)

```java
class DoublyNode {
    int data;
    DoublyNode next;
    DoublyNode prev;

    DoublyNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
```

---

### 3. Circular Linked List

- Last node points back to the head instead of `null`.
- Can be singly or doubly linked.
- Useful for applications needing circular iteration.

### Node Structure (Singly Circular) (Java)

```java
class CircularNode {
    int data;
    CircularNode next;

    CircularNode(int data) {
        this.data = data;
        this.next = null;
    }
}
```

---

## Singly Linked List Example: Insertion at Head

```java
class SinglyLinkedList {
    Node head;

    void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
```

---

## Doubly Linked List Example: Insertion at Tail

```java
class DoublyLinkedList {
    DoublyNode head;

    void insertAtTail(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        DoublyNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    void printForward() {
        DoublyNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    void printBackward() {
        if (head == null) return;
        DoublyNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }
}
```

---

## Circular Linked List Example: Traversal

```java
class CircularLinkedList {
    CircularNode head;

    void printList() {
        if (head == null) return;
        CircularNode temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(head)");
    }
}
```

---

## Advantages of Linked Lists

- Dynamic size.
- Efficient insertions/deletions (no shifting).
- Useful for applications where array resizing is costly.

---

## Disadvantages

- No random access (O(n) access time).
- Extra memory for pointers.
- More complex than arrays.

---