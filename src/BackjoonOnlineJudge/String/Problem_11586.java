package BackjoonOnlineJudge.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_11586 {
    static int N, K;
    static char[][] face, result;

    public static void main(String[] args) throws IOException{
        init();
        printFace();
    }

    static void printFace(){
        if(K==1)
            print(face);
        else if(K==2){
            for(int i=0; i<N; i++)
                for (int j = 0; j < N; j++)
                    result[i][N-1-j] = face[i][j];
            print(result);
        }
        else{
            for(int i=0; i<N; i++)
                for (int j = 0; j < N; j++)
                    result[N-1-i][j] = face[i][j];
            print(result);
        }
    }

    static void print(char[][] face){
        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(face[i][j]);
            System.out.println();
        }
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        face = new char[N][N];
        result = new char[N][N];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j=0; j<N; j++)
                face[i][j] = s.charAt(j);
        }
        K = Integer.parseInt(br.readLine());
    }
}