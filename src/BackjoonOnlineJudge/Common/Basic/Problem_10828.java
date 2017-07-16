package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;
import java.util.Stack;

public class Problem_10828 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for(int i=0; i<N; i++){
            String order = sc.nextLine();

            if(order.equals("pop")){
                if(stack.isEmpty()) result.append(-1).append('\n');
                else result.append(stack.pop()).append('\n');
            }
            else if(order.equals("size")){
                result.append(stack.size()).append('\n');
            }
            else if(order.equals("empty")){
                if(stack.isEmpty()) result.append(1).append('\n');
                else result.append(0).append('\n');
            }
            else if(order.equals("top")){
                if(stack.isEmpty()) result.append(-1).append('\n');
                else result.append(stack.peek()).append('\n');
            }
            else{
                String[] s = order.split(" ");
                stack.push(Integer.parseInt(s[1]));
            }
        }

        System.out.print(result.toString());
    }
}