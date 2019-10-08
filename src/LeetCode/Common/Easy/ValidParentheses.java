package LeetCode.Common.Easy;

import java.util.Stack;

/**
 * LeetCode
 * Problem : https://leetcode.com/problems/valid-parentheses
 **/
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false;

                char pop = stack.pop();

                if (ch == ')' && pop != '(') return false;
                if (ch == '}' && pop != '{') return false;
                if (ch == ']' && pop != '[') return false;
            }
        }

        if (!stack.isEmpty()) return false;
        return true;
    }
}
