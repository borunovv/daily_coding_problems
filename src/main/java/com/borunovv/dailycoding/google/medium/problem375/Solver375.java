package com.borunovv.dailycoding.google.medium.problem375;

import java.util.Arrays;

/**
 * This problem was asked by Google.
 *
 * The h-index is a metric used to measure the impact and productivity of a scientist or researcher.
 * A scientist has index h if h of their N papers have at least h citations each,
 * and the other N - h papers have no more than h citations each.
 * If there are multiple possible values for h, the maximum value is used.
 * Given an array of natural numbers, with each value representing the number of citations of a researcher's paper, return the h-index of that researcher.
 *
 * For example, if the array was:
 * [4, 0, 0, 2, 3]
 * 
 * This means the researcher has 5 papers with 4, 1, 0, 2, and 3 citations respectively.
 * The h-index for this researcher is 2, since they have 2 papers with at least 2 citations
 * and the remaining 3 papers have no more than 2 citations.
 */
public class Solver375 {
    public static void main(String[] args) {
        int[][] arrs = {
                {4, 0, 0, 2, 3},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0},
                {0, 10},
                {},
                {4, 4, 4, 4, 4},
                {4, 4, 4, 4, 5},
                {4, 4, 4, 5, 5},
                {4, 4, 5, 5, 5},
                {4, 5, 5, 5, 5},
                {5, 5, 5, 5, 5},
                {0, 5, 5, 5, 5},
                {7, 5, 4, 4, 2, 1, 0, 0, 0},
                {0, 0, 0, 4, 2, 4, 5, 1, 7}
        };

        for (int[] arr : arrs) {
            System.out.println(Arrays.toString(arr) + ", h = " + process(arr));
        }
    }

    // O(N*log(N))
    private static int process(int[] arr) {
        int hFactor = 0;
        Arrays.sort(arr); // O(N*log(N)), asc order

        for (int i = 0; i < arr.length; ++i) {
            int index = arr.length - i - 1; // We need desc order
            int citations = arr[index];
            int maxSquareSideFromStart = Math.min(i + 1, citations);
            hFactor = Math.max(hFactor, maxSquareSideFromStart);
        }
        return hFactor;
    }
}
