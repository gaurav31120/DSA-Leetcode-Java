/*
 * Problem: 4Sum
 * LeetCode: #18
 *
 * Approach: Sorting + Two Pointers
 *
 * Time Complexity: O(n^3)
 * Space Complexity: O(1) excluding output
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_TwoPointers {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        int n = nums.length;

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = n - 1;

                while (left < right) {

                    long sum = (long) nums[i]
                            + nums[j]
                            + nums[left]
                            + nums[right];

                    if (sum == target) {

                        List<Integer> list = new ArrayList<>();

                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);

                        result.add(list);

                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }

                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }

                    } else if (sum < target) {
                        left++;

                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}