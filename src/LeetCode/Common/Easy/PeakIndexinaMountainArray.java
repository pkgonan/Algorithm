package LeetCode.Common.Easy;

/**
 * LeetCode
 * Problem : https://leetcode.com/problems/peak-index-in-a-mountain-array
 **/
public class PeakIndexinaMountainArray {

    public int peakIndexInMountainArray(int[] A) {
        int before = A[0];
        for (int i = 0; i < A.length; i++) {
            if (before > A[i]) {
                return i - 1;
            }
            before = A[i];
        }
        return 0;
    }
}
