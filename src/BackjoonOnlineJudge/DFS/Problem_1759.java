package BackjoonOnlineJudge.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_1759 {
    static int L,C;
    static String[] arr;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        init();
        DFS(0,0, 0);
    }

    static void DFS(int ii, int mo, int ja){
        if(sb.length() == L){
            if(mo >= 1 && ja >= 2)
                System.out.println(sb);
            return;
        }

        for(int j=ii; j<arr.length; j++){
            if(!visited[j]){
                visited[j] = true;
                sb.append(arr[j]);
                int moo = arr[j].equals("a") || arr[j].equals("e") || arr[j].equals("i") || arr[j].equals("o") || arr[j].equals("u") ? 1 : 0;
                int jaa = moo == 0 ? 1 : 0;
                DFS(j+1, mo + moo, ja + jaa);
                sb.deleteCharAt(sb.length()-1);
                visited[j] = false;
            }
        }
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        L = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        arr = br.readLine().split(" ");
        Arrays.sort(arr);
        visited = new boolean[arr.length];
        sb = new StringBuilder();
    }
}