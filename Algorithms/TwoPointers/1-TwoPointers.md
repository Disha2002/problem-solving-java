# Two Pointers Algorithm

Two pointers is a common algorithmic technique that uses two indices (pointers) to iterate through a data structure, often an array or string. The pointers can move independently or together, depending on the problem, to achieve efficient solutions without using extra space.

---

## Key Concept:

- Use two pointers, usually called `left` and `right`, to traverse or partition the data.
- The pointers can move towards each other, away from each other, or in the same direction.
- Often used to reduce time complexity from O(n²) to O(n) by avoiding nested loops.

---

## When to use Two Pointers?

- When dealing with sorted arrays or strings.
- When searching for pairs, triplets, or substrings with certain properties.
- When you need to process the input from both ends or maintain a moving window.

---

## Common Patterns:

1. **Opposite Directions:**  
   - `left` starts at the beginning, `right` at the end.  
   - Move pointers based on conditions (e.g., two sum in a sorted array).

2. **Same Direction (Sliding Window):**  
   - Both pointers move forward to maintain a window.  
   - Expand or shrink the window based on problem constraints.

---

## Example Template in Python:

```python
def two_pointers(arr, target):
    left, right = 0, len(arr) - 1

    while left < right:
        current_sum = arr[left] + arr[right]

        if current_sum == target:
            return (left, right)  # Pair found

        if current_sum < target:
            left += 1  # Increase sum by moving left pointer right
        else:
            right -= 1  # Decrease sum by moving right pointer left

    return None  # No pair found
```

---