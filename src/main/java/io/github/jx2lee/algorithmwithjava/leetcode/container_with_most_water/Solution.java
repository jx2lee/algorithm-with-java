package io.github.jx2lee.algorithmwithjava.leetcode.container_with_most_water;

public class Solution {
    public static void main(String[] args) {
        // sample input
        int[] inputExample = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        // int[] inputExample = {1, 1};

        ContainerWithWater containerWithWater = new ContainerWithWater(inputExample);

        /**
         * expected value
         * 49 / 1
         **/
        System.out.println("containerWithWater.getMostWater() = " + containerWithWater.getMostWater());
    }
}
