package Sorting;

public class SelectionSort {
    
    public static void selectionSort(int[] nums) { // TC O(N ^ 2) ___ SC O(1)
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            int j = i + 1;

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

    public static void selectionSortDesc(int[] nums) { // TC O(N ^ 2) ___ SC O(1)
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int max = i;
            int j = i + 1;

            while (j < n) {
                if (nums[j] > nums[max]) {
                    max = j;
                }
                j++;
            }

            if (i != max) {
                int temp = nums[i];
                nums[i] = nums[max];
                nums[max] = temp;
            }
        }
    }
}
