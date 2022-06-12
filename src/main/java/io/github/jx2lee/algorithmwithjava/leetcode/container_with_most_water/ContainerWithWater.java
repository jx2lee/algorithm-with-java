package io.github.jx2lee.algorithmwithjava.leetcode.container_with_most_water;

import static java.lang.Math.*;
import static java.lang.Math.max;

public class ContainerWithWater {
    private int[] height;
    private int rightIndex;
    private int leftIndex = 0;
    private int maxWaterAmount = 0;

    public ContainerWithWater(int[] height) {
        this.height = height;
        this.rightIndex = height.length - 1;
    }

    public int getMostWater() {
        while (leftIndex < rightIndex) {
            maxWaterAmount = calculateMaxWater(maxWaterAmount, leftIndex, rightIndex);
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            }
            else {
                rightIndex--;
            }
        }

        return maxWaterAmount;
    }

    private int calculateMaxWater(int maxWaterAmount, int leftIndex, int rightIndex) {
        return max(maxWaterAmount, (rightIndex - leftIndex) * min(height[leftIndex], height[rightIndex]));
    }
}
