package LeetCode.Common.Easy;

/**
 * LeetCode
 * Problem : https://leetcode.com/problems/rotate-array
 **/
public class RotateArray {

    public void rotate(int[] nums, int k) {
        int size = nums.length;
        k = k % size;

        int start = 0;
        int mid = size - k - 1;
        int end = size - 1;

        reverse(nums, start, mid);
        reverse(nums, mid + 1, end);
        reverse(nums, start, end);
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }
}
