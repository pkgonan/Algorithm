package BackjoonOnlineJudge.Common.Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_14499 {
    static int N,M,X,Y,K;
    static int[][] map;
    static int[] order;
    static int[] box = { 0, 0, 0 ,0 ,0 ,0 };

    static final int RIGHT = 1;
    static final int LEFT = 2;
    static final int UP = 3;
    static final int DOWN = 4;

    public static void main(String[] args) throws IOException{
        init();
        getResult();
    }

    static void getResult(){
        int i = X;
        int j = Y;
        // 명령 하나씩 가져와
        for(int k=0; k<K; k++) {
            if (order[k] == RIGHT) { // 동
                if(isPromising(i, j+1)) {
                    rotation(RIGHT);
                    j++;
                    check(i, j);
                }
            } else if (order[k] == LEFT) { // 서
                if(isPromising(i, j-1)) {
                    rotation(LEFT);
                    j--;
                    check(i, j);
                }
            } else if (order[k] == UP) { //북
                if(isPromising(i-1, j)) {
                    rotation(UP);
                    i--;
                    check(i, j);
                }
            } else { //남
                if(isPromising(i+1, j)) {
                    rotation(DOWN);
                    i++;
                    check(i, j);
                }
            }
        }
    }

    static boolean isPromising(int i, int j){
        if(0<=i && i<N && 0<=j && j<M) return true;
        return false;
    }

    static void swap(int i, int j){
        int tmp = box[i];
        box[i] = box[j];
        box[j] = tmp;
    }

    static void rotation(int flag){
        if (flag == RIGHT) { // 동
            swap(3,4);
            swap(4,1);
            swap(1,5);
        } else if (flag == LEFT) { //서
            swap(3,5);
            swap(4,5);
            swap(1,5);
        } else if (flag == UP) { //북
            swap(0,3);
            swap(1,3);
            swap(2,3);;
        } else { //남
            swap(0,1);
            swap(1,2);
            swap(2,3);
        }
    }

    static void check(int i, int j){
        if (map[i][j] == 0) //이동한 칸의 수가 0일때
            map[i][j] = box[1];
        else {
            box[1] = map[i][j];
            map[i][j] = 0;
        }
        System.out.println(box[3]);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        X = Integer.parseInt(s[2]);
        Y = Integer.parseInt(s[3]);
        K = Integer.parseInt(s[4]);
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(s[j]);
        }
        order = new int[K];
        s = br.readLine().split(" ");
        for(int i=0; i<K; i++)
            order[i] = Integer.parseInt(s[i]);
    }
}