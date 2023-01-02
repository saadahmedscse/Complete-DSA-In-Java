package Sorting;

public class QuickSort {
    
    public static void quickSort(int[] nums) {
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
        int mid = low + (high - low) / 2;

        swap(nums, low, mid);

        int pivot = nums[low];
        int x = low;
        int y = high;

        while (x < y) {
            while (x < high && nums[x] <= pivot) x++;
            while (y >= 0 && nums[y] > pivot) y--;

            if (x < y) {
                swap(nums, x, y);
            }
        }

        swap(nums, low, y);

        return y;
    }

    public static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
