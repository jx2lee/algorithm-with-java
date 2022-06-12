package io.github.jx2lee.algorithmwithjava.leetcode.maximum_erasure_value;

import java.util.HashMap;

// https://leetcode.com/problems/maximum-erasure-value/discuss/2140577/An-Interesting-Optimisation-or-JAVA-Explanation
public class MaximumErasureValue {
    private int[] prefixSum;
    private int maxScore;
    private final int[] nums;
    private HashMap<Integer, Integer> lastIndex;

    public MaximumErasureValue(int[] nums) {
        this.nums = nums;
        this.prefixSum = new int [nums.length + 1];
        this.lastIndex = new HashMap<>();
    }

    public int getMaxSummationSubArray() {

        for (int left = 0, right = 0; right < getNumsLength(); right++) {
            calculatePrefixSum(right);
            if (hasLastIndexKey(nums[right])) {
                left = updateLeftIndex(left, right);
            }
            maxScore = updateMaxScore(left, right);
        }

        return maxScore;
    }

    private int updateMaxScore(int left, int right) {
        lastIndex.put(nums[right], right);
        return Math.max(maxScore, prefixSum[right + 1] - prefixSum[left]);
    }

    private int updateLeftIndex(int left, int right) {
        return Math.max(left, lastIndex.get(nums[right]) + 1);
    }

    private boolean hasLastIndexKey(int key) {
        return lastIndex.containsKey(key);
    }

    private void calculatePrefixSum(int i) {
        prefixSum[i + 1] = prefixSum[i] + nums[i];
    }

    private int getNumsLength() {
        return nums.length;
    }
}
