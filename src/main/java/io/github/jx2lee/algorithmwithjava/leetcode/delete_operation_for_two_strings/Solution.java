package io.github.jx2lee.algorithmwithjava.leetcode.delete_operation_for_two_strings;

import java.util.Arrays;

// https://www.daledev.com/problems/delete-operation-for-two-strings
public class Solution {
    public static void main(String[] args) {

        // case 1
        String word1 = "sea";
        String word2 = "eat";

        // case 2
        // String word1 = "leetcode";
        // String word2 = "etco";

        MinDistance minDistance = new MinDistance(word1, word2);
        minDistance.rearrangeWord();
        System.out.println("result = " + minDistance.getMinDistance());

        int i = 1 & 2;
        System.out.println("i = " + i);
    }
}
