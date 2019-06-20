package LeetCode.Common.Easy;

import java.util.Arrays;

/**
 * LeetCode
 * Problem : https://leetcode.com/problems/shortest-unsorted-continuous-subarray
 **/
public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);

        int start = 1;
        int end = 0;
        for (int i=0; i<temp.length; i++)
            if (nums[i] != temp[i]) {
                start = i;
                break;
            }

        for (int i=temp.length-1; i>=0; i--)
            if (nums[i] != temp[i]) {
                end = i;
                break;
            }

        return end - start + 1;
    }
}
