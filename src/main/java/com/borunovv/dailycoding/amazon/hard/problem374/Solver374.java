package com.borunovv.dailycoding.amazon.hard.problem374;

/**
 * This problem was asked by Amazon.
 * Given a sorted array arr of distinct integers, return the lowest index i for which arr[i] == i.
 * Return null if there is no such index.
 *
 * For example, given the array [-5, -3, 2, 3], return 2 since arr[2] == 2.
 * Even though arr[3] == 3, we return 2 since it's the lowest index.
 */
public class Solver374 {

    public static void main(String[] args) {
        // Note: sorted array arr of distinct integers.
        int[] arr = {-5, -3, 2, 3};
        System.out.println("Answer: " + solve(arr));
    }

    // O(log N)
    public static Integer solve(int[] arr) {
        return solve(arr, 0, arr.length - 1);
    }

    private static Integer solve(int[] arr, int from, int to) {
        if (from > to) return null;
        if (arr[from] > from) return null;
        if (arr[to] < to) return null;

        if (arr[from] == from) return from;
        int middle = (from + to) / 2;

        Integer left = solve(arr, from + 1, middle); // recursion
        if (left != null) return left;

        Integer right = solve(arr, middle + 1, to); // recursion
        return right;
    }
}
