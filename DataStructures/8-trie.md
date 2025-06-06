# Trie Data Structure

## Overview

A **Trie** (pronounced "try"), also known as a **prefix tree**, is a tree-like data structure used to efficiently store and retrieve keys in a dataset of strings. It is commonly used for:

- **Autocomplete**
- **Spell checking**
- **Prefix matching**
- **IP routing (Longest prefix match)**

---

## Characteristics

- Each node represents a **single character** of a string.
- The root node is empty and does not contain a character.
- Paths from the root to leaf nodes represent stored words.
- Nodes can have multiple children (one for each possible character).
- Nodes often contain a boolean flag indicating if the path so far forms a valid word.

---

## Basic Structure

### Node Structure (Java)

```java
class TrieNode {
    TrieNode[] children = new TrieNode[26];  // For lowercase English letters
    boolean isEndOfWord;

    public TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}
```

---

## Operations

### 1. Insert

Add a word into the trie.

```java
void insert(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
        int index = word.charAt(i) - 'a';
        if (node.children[index] == null) {
            node.children[index] = new TrieNode();
        }
        node = node.children[index];
    }
    node.isEndOfWord = true;
}
```

### 2. Search

Check if a word exists in the trie.

```java
boolean search(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
        int index = word.charAt(i) - 'a';
        if (node.children[index] == null) return false;
        node = node.children[index];
    }
    return node.isEndOfWord;
}
```

### 3. StartsWith (Prefix Search)

Check if there is any word in the trie that starts with the given prefix.

```java
boolean startsWith(String prefix) {
    TrieNode node = root;
    for (int i = 0; i < prefix.length(); i++) {
        int index = prefix.charAt(i) - 'a';
        if (node.children[index] == null) return false;
        node = node.children[index];
    }
    return true;
}
```

---

## Complexity

| Operation    | Time Complexity         |
|--------------|------------------------|
| Insert       | O(m) where m = length of word |
| Search       | O(m)                   |
| StartsWith   | O(m)                   |

Space complexity depends on number of words and their lengths.

---

## Applications

- Autocomplete systems.
- Spell checkers.
- IP routing (longest prefix matching).
- Storing dictionaries efficiently.
- Implementing word games and puzzles.

---