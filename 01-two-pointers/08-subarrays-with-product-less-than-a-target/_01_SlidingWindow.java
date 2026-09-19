/*
 * Problem: Subarrays with Product Less than a Target
 * LeetCode: #713
 *
 * Approach: Sliding Window
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class _01_SlidingWindow {

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1) {
            return 0;
        }

        int left = 0;
        int count = 0;
        int product = 1;

        for (int right = 0; right < nums.length; right++) {
            product = product * nums[right];

            while (product >= k) {
                product = product / nums[left];
                left++;
            }

            count = count + right - left + 1;
        }

        return count;
    }
}