package Sorting;

public class MergeSort {
    
    public static void mergeSort(int[] nums) { // TC O(NLogN) ___ SC O(N)
        mergeSortHelper(nums, 0, nums.length - 1);
    }

    public static void mergeSortHelper(int[] nums, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSortHelper(nums, low, mid);
            mergeSortHelper(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        int [] newArray = new int[high - low + 1];

        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) newArray[k] = nums[i++];
            else newArray[k] = nums[j++];
            k++;
        }

        while (i <= mid) {
            newArray[k++] = nums[i++];
        }

        while (j <= high) {
            newArray[k++] = nums[j++];
        }

        k = 0;

        for (int x = low; x <= high; x++) {
            nums[x] = newArray[k++];
        }
    }
}
