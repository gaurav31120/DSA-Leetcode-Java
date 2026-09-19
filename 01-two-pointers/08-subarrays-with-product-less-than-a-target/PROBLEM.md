# #713 — Subarrays with Product Less Than a Target

## 📌 Problem

Given an array of positive integers `nums` and an integer `k`, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than `k`.

---

## 🧪 Examples

### Example 1

```text
Input:
nums = [10, 5, 2, 6]
k = 100

Output:
8
```

The valid subarrays are:

```text
[10]
[5]
[2]
[6]
[10, 5]
[5, 2]
[2, 6]
[5, 2, 6]
```

---

### Example 2

```text
Input:
nums = [1, 2, 3]
k = 0

Output:
0
```

---

## 💡 Pattern

**Sliding Window**

The window contains a contiguous portion of the array.

We maintain:

```text
left  → start of window
right → end of window
product → product of elements inside the window
```

---

## 🧠 Approach

1. If `k <= 1`, return `0`.
2. Start with:

   * `left = 0`
   * `product = 1`
   * `count = 0`
3. Expand the window by moving `right`.
4. Multiply `nums[right]` into `product`.
5. If `product >= k`, move `left` forward and divide the removed element from `product`.
6. Continue shrinking until:

```text
product < k
```

7. For every valid window, the number of valid subarrays ending at `right` is:

```text
right - left + 1
```

8. Add this value to `count`.
9. Return `count`.

---

## 🔍 Why `right - left + 1`?

Suppose the current valid window is:

```text
[2, 6, 5]
 ↑     ↑
left  right
```

There are `3` valid subarrays ending at `right`:

```text
[2, 6, 5]
[6, 5]
[5]
```

Therefore:

```text
right - left + 1
= 2 - 0 + 1
= 3
```

---

## ⚠️ Important Point

We use `while`, not `if`:

```java
while (product >= k) {
    product = product / nums[left];
    left++;
}
```

Removing one element may not be enough to make the product smaller than `k`.

The window must continue shrinking until:

```text
product < k
```

---

## 🚫 Why `k <= 1` Returns 0?

All elements in `nums` are positive integers.

Therefore, every subarray has a product of at least `1`.

Since the condition is:

```text
product < k
```

there cannot be a valid subarray when:

```text
k <= 1
```

So:

```java
if (k <= 1) {
    return 0;
}
```

---

## ⏱️ Complexity

### Time Complexity

```text
O(n)
```

Although there is a `while` loop inside the `for` loop, each element is added to the window once and removed from the window at most once.

Therefore, the total number of operations is linear.

### Space Complexity

```text
O(1)
```

Only a few variables are used regardless of the input size.

---

## 🔑 Key Takeaway

When dealing with **contiguous subarrays** and a condition that can be maintained by expanding and shrinking a window, consider the **Sliding Window** pattern.

For this problem:

```text
Expand → Product becomes too large
             ↓
        Shrink from left
             ↓
       Product < k
             ↓
Count all valid subarrays ending at right
```

### Pattern to remember

> **Sliding Window + Product + Two Pointers**
