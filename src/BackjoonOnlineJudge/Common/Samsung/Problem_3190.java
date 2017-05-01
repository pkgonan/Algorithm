package BackjoonOnlineJudge.Common.Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Problem_3190 {
    static int N, K,L;
    static LinkedList<Point> snake;
    static boolean[][] apple;
    static ArrayList<Order> orderList;
    final static int[] xx = { 1, 0, -1, 0 };
    final static int[] yy = { 0, 1, 0, -1 };
    final static int EAST = 0, SOUTH = 1, WEST = 2, NORTH = 3;

    public static void main(String[] args) throws IOException{
        init();
        System.out.println(start());
    }

    static int start(){
        int now_side = EAST;
        int allcount = 0;
        int now_i = 1, now_j = 1;
        snake.add(new Point(1,1));

        for(Order order : orderList) {
            int next_sec = order.sec;
            char next_side = order.side;

            int tmpcnt = allcount;
            int cnt = -1;
            while(cnt + tmpcnt< next_sec){
                cnt++;
                allcount++;

                if(now_side == EAST){ //현재 동쪽 방향
                    if(next_sec-tmpcnt == cnt){
                        if(next_side == 'L'){ // 다음에는 왼쪽
                            now_i += yy[3];
                            now_j += xx[3];
                            now_side = NORTH;
                        } else{ //다음은 오른쪽
                            now_i += yy[1];
                            now_j += xx[1];
                            now_side = SOUTH;
                        }
                    }else{
                        now_i += yy[0];
                        now_j += xx[0];
                    }
                } else if(now_side == SOUTH){ //현재 남쪽방향
                    if(next_sec-tmpcnt == cnt){
                        if(next_side == 'L'){ // 다음에는 왼쪽
                            now_i += yy[0];
                            now_j += xx[0];
                            now_side = EAST;
                        } else{ //다음은 오른쪽
                            now_i += yy[2];
                            now_j += xx[2];
                            now_side = WEST;
                        }
                    }else{
                        now_i += yy[1];
                        now_j += xx[1];
                    }
                } else if(now_side == WEST){ //현재 서쪽방향
                    if(next_sec-tmpcnt == cnt){
                        if(next_side == 'L'){ // 다음에는 왼쪽
                            now_i += yy[1];
                            now_j += xx[1];
                            now_side = SOUTH;
                        } else{ //다음은 오른쪽
                            now_i += yy[3];
                            now_j += xx[3];
                            now_side = NORTH;
                        }
                    }else{
                        now_i += yy[2];
                        now_j += xx[2];
                    }
                } else { //현재 북쪽방향
                    if(next_sec-tmpcnt == cnt){
                        if(next_side == 'L'){ // 다음에는 왼쪽
                            now_i += yy[2];
                            now_j += xx[2];
                            now_side = WEST;
                        } else{ //다음은 오른쪽
                            now_i += yy[0];
                            now_j += xx[0];
                            now_side = EAST;
                        }
                    }else{
                        now_i += yy[3];
                        now_j += xx[3];
                    }
                }

                if(1>now_i || now_i>N || 1>now_j || now_j>N  || isBodyCrashed(now_i, now_j)) return allcount;
                snake.addFirst(new Point(now_i, now_j));
                if(!apple[now_i][now_j]) snake.removeLast();
                if(apple[now_i][now_j]) apple[now_i][now_j] = false;
            }
        }
        return allcount;
    }

    static boolean isBodyCrashed(int i, int j){
        ListIterator<Point> a = snake.listIterator();
        while (a.hasNext()){
            Point p = a.next();
            if(i==p.i && j==p.j) return true;
        }
        return false;
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        apple = new boolean[N+1][N+1];
        snake = new LinkedList<>();
        for(int i=0; i<K; i++) {
            String[] s = br.readLine().split(" ");
            int ai = Integer.parseInt(s[0]);
            int aj = Integer.parseInt(s[1]);
            apple[ai][aj] = true;
        }
        L = Integer.parseInt(br.readLine());
        orderList = new ArrayList<>();
        char lastSide = 'L';
        for(int i=0; i<L; i++) {
            String[] s = br.readLine().split(" ");
            int oi = Integer.parseInt(s[0]);
            char oj = s[1].charAt(0);
            orderList.add(new Order(oi, oj));
            if(i==L-1) lastSide = oj;
        }
        for(int i=0; i<L; i++)
            orderList.add(new Order(10000000, lastSide));
    }

    static class Point{
        int i, j;
        public Point(int i, int j){
            this.i=i; this.j=j;
        }
    }

    static class Order{
        int sec;
        char side;
        public Order(int sec, char side){
            this.sec=sec; this.side=side;
        }
    }
}