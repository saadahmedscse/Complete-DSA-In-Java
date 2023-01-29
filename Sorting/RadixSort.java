package Sorting;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {

    /**
     * Radix Sort Function
     * Author: Saad Ahmed
     * Date: 29 Jan, 2023
     */

     /**
     * Complexity [sort()] function:
     * Time Complexity:     O(D * (N + K))
     * Space Complexity:    O(N)
     */

    public static void sort(int[] array) {
        int max = array[0];

        for (int i : array) if (i > max) max = i;
        int step = 0;

        while (max != 0) {
            step++;
            max /= 10;
        }

        for (int i = 0; i < step; i++) {

            List<Integer>[] buckets = new ArrayList[10];

            for (int val : array) {
                int idx = -1;
                int k = 0;
                int tempValue = val;

                while (k++ <= i) {
                    idx = tempValue % 10;
                    tempValue /= 10;
                }

                if (buckets[idx] == null) buckets[idx] = new ArrayList<>();
                buckets[idx].add(val);
            }

            int k = 0;
            for (List<Integer> bucket : buckets) {
                if (bucket != null) {
                    for (int j : bucket) {
                        array[k++] = j;
                    }
                }
            }
        }
    }
}