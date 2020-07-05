package com.borunovv.dailycoding.facebook.hard.problem373;

import java.util.HashSet;
import java.util.Set;

/**
 * This problem was asked by Facebook.
 * Given a list of integers L, find the maximum length of a sequence of consecutive numbers that can be formed using elements from L.
 * 
 * For example, given L = [5, 2, 99, 3, 4, 1, 100], return 5 as we can build a sequence [1, 2, 3, 4, 5] which has length 5.
 */
public class Solver373 {
    public static void main(String[] args) {
        int[] arr = {5, 2, 99, 3, 4, 1, 100};
        System.out.println("Len: " + process(arr));
    }

    private static int process(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            set.add(x);
        }

        int maxLen = 0;

        // O(n)
        while (set.size() > maxLen) {
            int x = set.iterator().next();
            int curLen = 1;
            set.remove(x);
            if (x < Integer.MAX_VALUE) {
                for (int a = x + 1; ;++a) {
                    if (set.contains(a)) {
                        curLen++;
                        set.remove(a);
                    } else {
                        break;
                    }
                    if (a == Integer.MAX_VALUE) break;
                }
            }
            if (x > Integer.MIN_VALUE) {
                for (int a = x - 1; ;--a) {
                    if (set.contains(a)) {
                        curLen++;
                        set.remove(a);
                    } else {
                        break;
                    }
                    if (a == Integer.MIN_VALUE) break;
                }
            }
            maxLen = maxLen > curLen ? maxLen : curLen;
        }
        return maxLen;
    }
}
