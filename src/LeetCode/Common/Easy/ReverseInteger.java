package LeetCode.Common.Easy;

/**
 * LeetCode
 * Problem : https://leetcode.com/problems/reverse-integer
 **/
public class ReverseInteger {

    public int reverse(int x) {
        return doReverse(x);
    }

    private int doReverse(int n) {
        long result = 0;
        while (n != 0) {
            int remain = n % 10;
            n /= 10;
            result *= 10;
            result += remain;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
        return (int) result;
    }
}
