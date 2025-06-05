# Sliding Window Algorithm

Sliding Window is a technique used to solve problems involving arrays or strings where you need to find a contiguous subarray or substring that satisfies certain conditions. Instead of checking all possible subarrays (which can be very inefficient), the sliding window approach maintains a window defined by two pointers that move through the array or string, expanding or shrinking the window as needed.

---

## Key Concept:

- Use two pointers (usually called `left` and `right`) to represent the current window boundaries.
- Move `right` to expand the window and include new elements.
- Move `left` to shrink the window when the current window no longer satisfies the problem constraints.
- Keep track of the best solution (e.g., max length, min length) while adjusting the window.

---

## When to use Sliding Window?

- When you need to find a contiguous subarray or substring with certain properties.
- When you want to optimize from a naive O(n²) solution to O(n).
- When the problem involves sums, counts, or frequencies in a contiguous range.

---

## Example Template in Python:

```python
def sliding_window(arr):
    left = 0
    result = 0
    window_data = {}  # Data structure to store info about elements in the window

    for right in range(len(arr)):
        # Add arr[right] to the window
        window_data[arr[right]] = window_data.get(arr[right], 0) + 1

        # Shrink window if it violates constraints
        while not is_valid(window_data):
            window_data[arr[left]] -= 1
            if window_data[arr[left]] == 0:
                del window_data[arr[left]]
            left += 1

        # Update result if current window is better
        result = max(result, right - left + 1)

    return result

def is_valid(window_data):
    # Define condition for window validity
    # For example, check if window_data meets problem-specific criteria
    pass
```

---

