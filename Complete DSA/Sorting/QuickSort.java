package Sorting;

public class QuickSort {
    
    public static void quickSort(int[] nums) { // TC O(NLogN) ___ SC O(1)
        quickSortHelper(nums, 0, nums.length - 1);
    }

    public static void quickSortHelper(int[] nums, int low, int high) {
        if (low < high) {
            int pivot = partition(nums, low, high);

            quickSortHelper(nums, low, pivot - 1);
            quickSortHelper(nums, pivot + 1, high);
        }
    }

    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int x = low;
        int y = high;

        while (x < y) {
            while (x < high && nums[x] <= pivot) x++;
            while (y >= 0 && nums[y] > pivot) y--;

            if (x < y) {
                int temp = nums[x];
                nums[x] = nums[y];
                nums[y] = temp;
            }
        }

        int temp = nums[y];
        nums[y] = nums[low];
        nums[low] = temp;

        return y;
    }
}
