package io.github.jx2lee.algorithmwithjava.leetcode.triangle;

import java.util.List;

// https://leetcode.com/problems/triangle/discuss/38724/7-lines-neat-Java-Solution
public class CalculateMinimumTotal {
    private List<List<Integer>> triangle;
    private int triangleSize;
    private int[] results;

    public CalculateMinimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        this.triangleSize = triangle.size();
        this.results = new int[triangleSize + 1];
    }
    
    public int getMinimumTotal() {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        for (int i = triangleSize - 1; i >= 0; i--) {
            List<Integer> tmp = triangle.get(i);
            for (int j = 0; j < tmp.size(); j++) {
                results[j] = Math.min(results[j], results[j + 1]) + tmp.get(j);
            }
        }

        return results[0];
    }
}
