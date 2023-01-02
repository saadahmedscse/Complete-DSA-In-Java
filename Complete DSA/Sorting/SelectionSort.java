package Sorting;

public class SelectionSort {
    
    public static void selectionSort(int[] nums) { // TC O(N ^ 2) ___ SC O(1)
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int min = i;
            int j = i;

            while (j < n) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
                j++;
            }

            if (i != min) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
    }
}
