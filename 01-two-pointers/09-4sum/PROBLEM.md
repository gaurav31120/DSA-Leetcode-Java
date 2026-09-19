# #18 — 4Sum

## 📌 Problem

Given an array `nums` of `n` integers, return an array of all the **unique quadruplets**:

```text
nums[a] + nums[b] + nums[c] + nums[d] == target
```

where:

```text
a, b, c, d
```

are four distinct indices.

The answer must not contain duplicate quadruplets.

The order of the quadruplets does not matter.

---

## 🧪 Examples

### Example 1

```text
Input:
nums = [1, 0, -1, 0, -2, 2]
target = 0

Output:
[
    [-2, -1, 1, 2],
    [-2, 0, 0, 2],
    [-1, 0, 0, 1]
]
```

### Example 2

```text
Input:
nums = [2, 2, 2, 2, 2]
target = 8

Output:
[
    [2, 2, 2, 2]
]
```

---

## 💡 Pattern

**Two Pointers**

The main technique is:

```text
Sorting + Two Pointers
```

We fix the first two elements and use two pointers to find the remaining two elements.

---

## 🧠 Approach

1. Sort the array.
2. Use the first loop to select the first number.
3. Use the second loop to select the second number.
4. Initialize:

   * `left` after the second selected element
   * `right` at the end of the array
5. Calculate the sum of the four elements.
6. If the sum equals `target`:

   * Add the quadruplet to the answer.
   * Move both `left` and `right`.
   * Skip duplicate values.
7. If the sum is smaller than `target`:

   * Move `left` forward.
8. If the sum is greater than `target`:

   * Move `right` backward.
9. Skip duplicates for the first and second selected elements as well.

---

## 🔍 Example

For:

```text
nums = [1, 0, -1, 0, -2, 2]
target = 0
```

After sorting:

```text
[-2, -1, 0, 0, 1, 2]
```

We fix the first two numbers:

```text
-2, -1
```

Then use two pointers:

```text
left  → 0
right → 2
```

We adjust the pointers based on the current sum until we find valid quadruplets.

---

## ⚠️ Important — Duplicate Handling

Duplicate handling is one of the most important parts of this problem.

After sorting, skip duplicate values for the first pointer:

```java
if (i > 0 && nums[i] == nums[i - 1]) {
    continue;
}
```

Similarly, skip duplicates for the second pointer:

```java
if (j > i + 1 && nums[j] == nums[j - 1]) {
    continue;
}
```

After finding a valid quadruplet, skip duplicate values for both `left` and `right`.

This ensures that the result contains only **unique quadruplets**.

---

## ⏱️ Complexity

### Time Complexity

```text
O(n³)
```

Sorting takes `O(n log n)`, followed by two nested loops and a two-pointer scan, resulting in `O(n³)` overall.

### Space Complexity

```text
O(1)
```

excluding the space required for the output.

---

## 🔑 Key Takeaway

The important pattern is:

```text
Sort
  ↓
Fix first element
  ↓
Fix second element
  ↓
Two Pointers for remaining two elements
  ↓
Skip duplicates
```

### Pattern to remember

> **4Sum = Sorting + Two Fixed Pointers + Two-Pointer Search + Duplicate Handling**
