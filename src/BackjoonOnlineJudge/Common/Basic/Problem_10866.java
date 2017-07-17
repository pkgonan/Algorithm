package BackjoonOnlineJudge.Common.Basic;

import java.util.LinkedList;
import java.util.Scanner;

public class Problem_10866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        LinkedList<Integer> deque = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for(int i=0; i<n; i++){
            String s = sc.nextLine();

            if(s.equals("front")){
                if(deque.isEmpty()) result.append(-1).append('\n');
                else result.append(deque.peekFirst()).append('\n');
            }
            else if(s.equals("back")){
                if(deque.isEmpty()) result.append(-1).append('\n');
                else result.append(deque.peekLast()).append('\n');
            }
            else if(s.equals("size")){
                result.append(deque.size()).append('\n');
            }
            else if(s.equals("empty")){
                if(deque.isEmpty()) result.append(1).append('\n');
                else result.append(0).append('\n');
            }
            else if(s.equals("pop_front")){
                if(deque.isEmpty()) result.append(-1).append('\n');
                else result.append(deque.pollFirst()).append('\n');
            }
            else if(s.equals("pop_back")){
                if(deque.isEmpty()) result.append(-1).append('\n');
                else result.append(deque.pollLast()).append('\n');
            }
            else{
                String[] order = s.split(" ");

                if(order[0].equals("push_back"))
                    deque.addLast(Integer.parseInt(order[1]));
                else
                    deque.addFirst(Integer.parseInt(order[1]));
            }
        }

        System.out.print(result.toString());
    }
}