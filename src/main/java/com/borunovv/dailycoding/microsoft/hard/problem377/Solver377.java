package com.borunovv.dailycoding.microsoft.hard.problem377;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * This problem was asked by Microsoft.
 * <p>
 * Given an array of numbers arr and a window of size k, print out the median of each window of size k starting from the left and moving right by one position each time.
 * For example, given the following array and k = 3:
 * <p>
 * [-1, 5, 13, 8, 2, 3, 3, 1]
 * <p>
 * Your function should print out the following:
 * <p>
 * 5 <- median of [-1, 5, 13]
 * 8 <- median of [5, 13, 8]
 * 8 <- median of [13, 8, 2]
 * 3 <- median of [8, 2, 3]
 * 3 <- median of [2, 3, 3]
 * 3 <- median of [3, 3, 1]
 * <p>
 * Recall that the median of an even-sized list is the average of the two middle numbers.
 */
public class Solver377 {

    public static void main(String[] args) {
        int[] arr = {-1, 5, 13, 8, 2, 3, 3, 1};
        process(arr, 4);
    }

    // Using 2 heaps to split window
    private static void process(int[] arr, int k) {
        // [maxHeap <= top1] <= [top2 <= minHeap]
        // if k even: median = (top1 + top2) / 2
        // if k odd : median = top1 if maxHeap.size > minHeap.size, else top2
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); // ascending, top=max
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // descending, top = min

        // O(N * (log(N) + k))
        for (int i = 0; i < arr.length; ++i) { // O(N)
            if (i >= k) {
                // Remove tail element
                int tail = arr[i - k];
                remove(tail, minHeap, maxHeap); // O(log N)
            }
            int head = arr[i];
            minHeap.offer(head);
            rebalance(k, minHeap, maxHeap); // O(log N)
            if (i >= k - 1) {
                double median = getMedian(minHeap, maxHeap); // O(1)
                printMedian(arr, k, i, median); // O(k)
            }
        }
    }

    private static void rebalance(int k, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        int maxDiff = k % 2;
        while (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.offer(maxHeap.poll());
        }

        while (minHeap.size() - maxHeap.size() > maxDiff) {
            maxHeap.offer(minHeap.poll());
        }
        while (maxHeap.size() - minHeap.size() > maxDiff) {
            minHeap.offer(maxHeap.poll());
        }
    }

    private static double getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) * 0.5;
        }
        return minHeap.size() >= maxHeap.size() ?
                minHeap.peek() :
                maxHeap.peek();
    }

    private static void remove(int value, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (!minHeap.remove(value)) {
            maxHeap.remove(value);
        }
    }

    private static void printMedian(int[] arr, int k, int i, double median) {
        if (Math.ceil(median) != median) {
            System.out.printf("%.1f", median);
        } else {
            System.out.printf("%d", (long) median);
        }

        System.out.print(" <- median of [");
        for (int j = i - k + 1; j <= i; ++j) {
            if (j > i - k + 1) {
                System.out.print(", ");
            }
            System.out.printf("%d", arr[j]);
        }
        System.out.println("]");
    }
}
