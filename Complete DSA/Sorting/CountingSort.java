package Sorting;

public class CountingSort {
    
    public static void countingSort(int[] nums) { // TC O(N) ___ SC O(K
        int min = nums[0];
        int max = nums[0];

        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        int[] count = new int[max + 1];

        for (int i : nums) {
            count[i]++;
        }

        int j = 0;

        for (int i = 0; i < count.length; i++) {
            int k = count[i];
            int x = 0;

            while (x++ < k) {
                nums[j++] = i;
            }
        }
    }
}
