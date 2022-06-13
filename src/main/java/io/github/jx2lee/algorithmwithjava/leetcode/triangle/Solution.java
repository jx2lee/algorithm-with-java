package io.github.jx2lee.algorithmwithjava.leetcode.triangle;

import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/triangle
public class Solution {
    public static void main(String[] args) {

        // case 1
        List<List<Integer>> inputSampleOne = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3,4),
                Arrays.asList(6,5,7),
                Arrays.asList(4,1,8,3)
        );

        CalculateMinimumTotal minimumTotal = new CalculateMinimumTotal(inputSampleOne);
        System.out.println("result = " + minimumTotal.getMinimumTotal());
    }
}
