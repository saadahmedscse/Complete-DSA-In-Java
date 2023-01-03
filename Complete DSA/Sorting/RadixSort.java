package Sorting;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {

    // Radix Sort / Bucket Sort
    // TC O(N + K) in Best Case
    // TC O(N) in Average Case
    // TC O(N ^ 2) Worst Case
    // SC O(N + k)
    
    public static void radixSort(int[] nums) {
        int max = 0;
        for (int i : nums) max = Math.max(max, i);

        int maxIntLength = 0;
        while (max != 0) {
            maxIntLength++;
            max /= 10;
        }

        for (int pass = 1; pass <= maxIntLength; pass++) {

            List<List<Integer>> bucket = new ArrayList<>();
            for (int j = 0; j < 10; j++) bucket.add(new ArrayList<>());

            for (int num : nums) {
                int temp = num;
                int rem = 0;
                int k = 0;

                while (k++ < pass) {
                    rem = temp % 10;
                    temp /= 10;
                }

                bucket.get(rem).add(num);
            }

            int k = 0;
            for (List<Integer> b : bucket) {
                for (int item : b) {
                    if (item != 0) nums[k++] = item;
                }
            }
        }
    }
}
