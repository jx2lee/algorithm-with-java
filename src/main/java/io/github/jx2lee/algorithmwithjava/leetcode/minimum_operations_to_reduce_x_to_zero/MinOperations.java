package io.github.jx2lee.algorithmwithjava.leetcode.minimum_operations_to_reduce_x_to_zero;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/discuss/935974/C-Sliding-window-O(n)-Time-O(1)-Space
public class MinOperations {
    private int prefixSum;
    private final int[] nums;
    private final int target;

    public MinOperations(int[] nums, int x) {
        this.nums = nums;
        this.target = Arrays.stream(nums).sum() - x;
        this.prefixSum = 0;
    }

    public int getMinOperation() {
        if (targetUnderZero()) {
            return -1;
        }
        if (targetEqualZero()) {
            return getNumsLength();
        }

        int ans = returnToMinus();
        int cur = 0;
        for (int i = 0; i < getNumsLength(); i++) {
            prefixSum += nums[i];

            while (prefixSum > target) {
                prefixSum -= nums[cur];
                cur++;
            }

            if (prefixSum == target) {
                ans = Math.max(ans, i - cur + 1);
            }
        }
        return ans == -1 ? -1 : getNumsLength() - ans;
    }

    private int getNumsLength() {
        return nums.length;
    }

    private int returnToMinus() {
        return -1;
    }

    private boolean targetUnderZero() {
        if (target < 0) {
            return true;
        }
        return false;
    }

    private boolean targetEqualZero() {
        if (target == 0) {
            return true;
        }
        return false;
    }
}
