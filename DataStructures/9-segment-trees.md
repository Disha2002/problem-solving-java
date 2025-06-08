# Segment Trees

Segment Trees are advanced data structures used for performing efficient range queries and updates on arrays. They are widely used when frequent queries and updates are required over intervals.

## Use Cases

- Range sum queries
- Range minimum/maximum queries
- Greatest common divisor (GCD) queries
- Range updates (with advanced lazy propagation)

## Time Complexity

- **Build:** O(n)
- **Query:** O(log n)
- **Update:** O(log n)

## Java Implementation

```java
// SegmentTree.java

public class SegmentTree {
    int[] tree;
    int n;

    public SegmentTree(int[] arr) {
        this.n = arr.length;
        tree = new int[4 * n];
        build(arr, 0, 0, n - 1);
    }

    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(arr, 2 * node + 1, start, mid);
            build(arr, 2 * node + 2, mid + 1, end);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public int query(int l, int r) {
        return queryUtil(0, 0, n - 1, l, r);
    }

    private int queryUtil(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 0;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int leftSum = queryUtil(2 * node + 1, start, mid, l, r);
        int rightSum = queryUtil(2 * node + 2, mid + 1, end, l, r);
        return leftSum + rightSum;
    }

    public void update(int index, int value) {
        updateUtil(0, 0, n - 1, index, value);
    }

    private void updateUtil(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
        } else {
            int mid = (start + end) / 2;
            if (idx <= mid) {
                updateUtil(2 * node + 1, start, mid, idx, val);
            } else {
                updateUtil(2 * node + 2, mid + 1, end, idx, val);
            }
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree st = new SegmentTree(arr);

        System.out.println("Sum of values in range [1, 3]: " + st.query(1, 3)); // 15
        st.update(1, 10);
        System.out.println("Updated sum of values in range [1, 3]: " + st.query(1, 3)); // 22
    }
}
```

## Summary

Segment Trees offer an efficient solution to range query problems with fast update times. They are essential for performance-critical applications and frequently used in coding interviews and competitive programming.
