package Sorting;

public class InsertionSort {
    
    public static void insertionSort(int[] nums) { // TC O(N ^ 2) ___ SC O(1)
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            int j = i - 1;
            int temp = nums[i];

            while (j >= 0 && nums[j] > temp) {
                nums[j + 1] = nums[j--];
            }

            nums[j + 1] = temp;
        }
    }

    public static void insertionSortDesc(int[] nums) { // TC O(N ^ 2) ___ SC O(1)
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            int j = i - 1;
            int temp = nums[i];

            while (j >= 0 && nums[j] < temp) {
                nums[j + 1] = nums[j--];
            }

            nums[j + 1] = temp;
        }
    }
}
