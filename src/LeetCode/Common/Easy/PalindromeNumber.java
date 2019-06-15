package LeetCode.Common.Easy;

/**
 * LeetCode
 * Problem : https://leetcode.com/problems/palindrome-number
 **/
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int copy_x = x;
        int reverse_x = 0;
        while (copy_x > 0) {
            int remain = copy_x % 10;
            copy_x /= 10;
            reverse_x *= 10;
            reverse_x += remain;
        }
        return reverse_x == x;
    }
}
