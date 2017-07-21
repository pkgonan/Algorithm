package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_2999 {
    static int R, C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String msg = sc.nextLine();
        getRC(msg.length());

        char[][] matrix = new char[R][C];
        setMatrix(matrix, msg);

        System.out.println(decript(matrix));
    }

    static String decript(char[][] matrix){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<R; i++)
            for(int j=0; j<C; j++)
                sb.append(matrix[i][j]);

        return sb.toString();
    }

    static void setMatrix(char[][] matrix, String msg){
        int idx = 0;

        for(int i=0; i<C; i++)
            for(int j=0; j<R; j++)
                matrix[j][i] = msg.charAt(idx++);
    }

    static void getRC(int N){
        for(int i=1; i<=(int)Math.sqrt(N); i++){
            if(N % i == 0) {
                R = i;
                C = N / i;
            }
        }
    }
}