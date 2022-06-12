package io.github.jx2lee.algorithmwithjava.leetcode.minimum_operations_to_reduce_x_to_zero;

public class Solution {
    public static void main(String[] args) {

        // case1
        // int[] nums = {1, 1, 4, 2, 3};
        // int x = 5;

        // case2
        // int[] nums = {5, 6, 7, 8, 9};
        // int x = 4;

        // case3
        // int[] nums = {3,2,20,1,1,3};
        // int x = 10;

        // case3
        int[] nums = {1, 1};
        int x = 3;

        MinOperations minOperations = new MinOperations(nums, x);
        System.out.println("result = " + minOperations.getMinOperation());
    }
}
