import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1
        int[] nums1 = {1, 3, 2, 3, 1};
        System.out.println("Number of important reverse pairs: " + sol.reversePairs(nums1));
        // Expected output: 2

        // Test case 2
        int[] nums2 = {2, 4, 3, 5, 1};
        System.out.println("Number of important reverse pairs: " + sol.reversePairs(nums2));
        // Expected output: 3

        // Test case 3
        int[] nums3 = {5,4,3,2,1};
        System.out.println("Number of important reverse pairs: " + sol.reversePairs(nums3));
        // You can test other edge cases
    }
}

class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

        // Count important reverse pairs
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        // Merge step to keep nums sorted
        merge(nums, left, mid, right);

        return count;
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];

        System.arraycopy(temp, 0, nums, left, temp.length);
    }
}
