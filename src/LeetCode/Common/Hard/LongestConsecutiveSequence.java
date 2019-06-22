package LeetCode.Common.Hard;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode
 * Problem : https://leetcode.com/problems/longest-consecutive-sequence
 **/
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int max = 0;
        for (int num : nums) {
            int cnt = 1;
            int left = num - 1;
            int right = num + 1;

            while (set.contains(left)) {
                set.remove(left);
                left--;
                cnt++;
            }
            while (set.contains(right)) {
                set.remove(right);
                right++;
                cnt++;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
