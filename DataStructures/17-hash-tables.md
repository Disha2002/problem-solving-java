# Hash Tables and Hashing

A **hash table** (or hash map) is a data structure that implements an associative array abstract data type, a structure that can map keys to values efficiently.

---

## 1. What is Hashing?

- **Hashing** is the process of converting a given key into an integer index using a hash function.
- The hash function maps keys to indices in an array, allowing **fast data retrieval**.
- Ideal hash function properties:
  - **Deterministic:** Same input yields same output.
  - **Uniform:** Distributes keys evenly across the table.
  - **Fast:** Quick to compute.

---

## 2. Hash Table Basics

- Uses an **array** to store data.
- The index is computed by applying the hash function on the key.
- Supports operations like:
  - **Insert(key, value)**
  - **Search(key)**
  - **Delete(key)**

---

## 3. Collision Handling

Collisions occur when two keys hash to the same index.

### Common techniques:

- **Chaining:**  
  Store multiple elements in a linked list (or another data structure) at the same index.
  
- **Open Addressing:**  
  Find another open slot using probing techniques (linear, quadratic, or double hashing).

---

## 4. Hash Functions

- For strings: polynomial rolling hash, DJB2, etc.
- For integers: simple modulo operation (e.g., `key % table_size`).

---

## 5. Java Example: Simple Hash Table Using Chaining

```java
import java.util.*;

class HashTable<K, V> {
    private class Entry {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private LinkedList<Entry>[] table;

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        this.capacity = capacity;
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];

        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update existing key
                return;
            }
        }

        bucket.add(new Entry(key, value)); // Add new key-value pair
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];

        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null; // Key not found
    }

    public boolean remove(K key) {
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];

        Iterator<Entry> it = bucket.iterator();
        while (it.hasNext()) {
            Entry entry = it.next();
            if (entry.key.equals(key)) {
                it.remove();
                return true;
            }
        }

        return false; // Key not found
    }
}

public class HashTableDemo {
    public static void main(String[] args) {
        HashTable<String, Integer> map = new HashTable<>(10);

        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 30);

        System.out.println("apple: " + map.get("apple"));   // 10
        System.out.println("banana: " + map.get("banana")); // 20

        map.put("banana", 25);  // Update value
        System.out.println("banana (updated): " + map.get("banana")); // 25

        map.remove("orange");
        System.out.println("orange: " + map.get("orange")); // null
    }
}
```

---

## 6. Java’s Built-in Hash Table Classes

- `HashMap<K,V>`: Non-synchronized, allows `null` keys and values.
- `Hashtable<K,V>`: Synchronized (thread-safe), does **not** allow `null` keys or values.
- `LinkedHashMap<K,V>`: Maintains insertion order.
- `ConcurrentHashMap<K,V>`: Thread-safe with better concurrency.

---

## 7. Time Complexity

| Operation | Average Case | Worst Case     |
|-----------|--------------|----------------|
| Search    | O(1)         | O(n) (collision)|
| Insert    | O(1)         | O(n)           |
| Delete    | O(1)         | O(n)           |

---

## Summary

- Hash tables provide **fast average-time** lookups, insertions, and deletions.
- Collision handling is crucial for performance.
- Choosing a good hash function and appropriate capacity helps minimize collisions.
- Widely used in caching, indexing, and many algorithms.

---