package BackjoonOnlineJudge.Contest.ACM_ICPC._2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_13567 {
    final static int NORTH = 0, EAST = 1, SOUTH = 2, WEST = 3;
    static int M, N, nowSide = EAST, now_i, now_j;
    static ArrayList<Order> order;
    static boolean isBroken = false;

    public static void main(String[] args) throws IOException{
        init();
        start();
    }

    static void start(){
        for(Order now : order) {
            if(now.order.equals("MOVE")){
                if(nowSide==NORTH){
                    if(isPromising(now_i + now.dis, now_j)) now_i += now.dis;
                }else if(nowSide==EAST) {
                    if(isPromising(now_i, now_j + now.dis)) now_j += now.dis;
                }else if(nowSide==SOUTH){
                    if(isPromising(now_i - now.dis, now_j)) now_i -= now.dis;
                }else {
                    if(isPromising(now_i, now_j - now.dis)) now_j -= now.dis;
                }
                if(isBroken) break;
            }else{
                if(nowSide==NORTH){
                    if(now.dis==0) nowSide = WEST;
                    else nowSide = EAST;
                }else if(nowSide==EAST) {
                    if(now.dis==0) nowSide = NORTH;
                    else nowSide = SOUTH;
                }else if(nowSide==SOUTH){
                    if(now.dis==0) nowSide = EAST;
                    else nowSide = WEST;
                }else {
                    if(now.dis==0) nowSide = SOUTH;
                    else nowSide = NORTH;
                }
            }
        }
        if(isBroken) System.out.println(-1);
        else System.out.println(now_j + " " + now_i);
    }

    static boolean isPromising(int i, int j){
        if(i<0 || i>M || j<0 || j>M) {
            isBroken = true;
            return false;
        }
        return true;
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        order = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            order.add(new Order(st.nextToken(), Integer.parseInt(st.nextToken())));
        }
    }

    static class Order{
        String order;
        int dis;
        public Order(String order, int dis){
            this.order=order; this.dis=dis;
        }
    }
}