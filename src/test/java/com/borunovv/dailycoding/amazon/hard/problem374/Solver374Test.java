package com.borunovv.dailycoding.amazon.hard.problem374;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * This problem was asked by Amazon.
 * Given a sorted array arr of distinct integers, return the lowest index i for which arr[i] == i.
 * Return null if there is no such index.
 * <p>
 * For example, given the array [-5, -3, 2, 3], return 2 since arr[2] == 2.
 * Even though arr[3] == 3, we return 2 since it's the lowest index.
 */
public class Solver374Test {

    @Test
    public void solve() {
        assertEquals(2, (int) Solver374.solve(new int[]{-5, -3, 2, 3}));
        assertEquals(0, (int) Solver374.solve(new int[]{0}));
        assertEquals(0, (int) Solver374.solve(new int[]{0, 2, 3, 4, 5, 6}));
        assertEquals(3, (int) Solver374.solve(new int[]{-1, 0, 1, 3}));
        assertEquals(3, (int) Solver374.solve(new int[]{-10, -5, -2, 3}));

        assertNull(Solver374.solve(new int[]{-10, -5, -2, -1}));
        assertNull(Solver374.solve(new int[]{-1}));
        assertNull(Solver374.solve(new int[]{-1, 2, 3, 5, 10}));
        assertNull(Solver374.solve(new int[]{-10, -5, -3}));
        assertNull(Solver374.solve(new int[]{-10, -5, -3, 4, 10}));
        assertNull(Solver374.solve(new int[]{10, 11, 12, 13, 100}));
    }
}