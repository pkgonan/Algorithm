package LeetCode.Common.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode
 * Problem : https://leetcode.com/problems/two-sum
 **/
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            int val = target - num;
            if (!map.containsKey(val)) {
                map.put(num, i);
            } else {
                result.add(map.get(val));
                result.add(i);
                break;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
