package BackjoonOnlineJudge.DynamicProgramming;

import java.util.Scanner;

public class Problem_1149 {
    int N;
    int[][] RGB;

    public void getMinimumValue(){
        for(int i=1; i<N; i++){
            RGB[i][0] = min(RGB[i-1][1] , RGB[i-1][2]) + RGB[i][0];
            RGB[i][1] = min(RGB[i-1][0] , RGB[i-1][2]) + RGB[i][1];
            RGB[i][2] = min(RGB[i-1][0] , RGB[i-1][1]) + RGB[i][2];
        }
        System.out.println(min(min(RGB[N-1][0], RGB[N-1][1]), RGB[N-1][2]));
    }

    public int min(int first, int second){
        return (first > second)? second : first;
    }

    public void init(){
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        RGB = new int[N][3];

        for(int i=0; i<N; i++)
            for(int j=0; j<3; j++)
                RGB[i][j] = scanner.nextInt();
        scanner.close();
    }
}
