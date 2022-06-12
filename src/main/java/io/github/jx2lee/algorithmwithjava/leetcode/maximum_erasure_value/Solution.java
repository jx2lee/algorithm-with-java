package io.github.jx2lee.algorithmwithjava.leetcode.maximum_erasure_value;

// https://leetcode.com/problems/maximum-erasure-value/
public class Solution {
    public static void main(String[] args) {

        // case 1
        // int[] nums = {4, 2, 4, 5, 6};

        // case 2
        int[] nums = {5, 2, 1, 2, 5, 2, 1, 2, 5};

        MaximumErasureValue maximumErasureValue = new MaximumErasureValue(nums);
        System.out.println("maximumErasureValue = " + maximumErasureValue.getMaxSummationSubArray());
    }
}
