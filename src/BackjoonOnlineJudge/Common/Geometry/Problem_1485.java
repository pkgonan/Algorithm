package BackjoonOnlineJudge.Common.Geometry;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_1485 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0; i<T; i++){
            Point[] arr = new Point[4];

            for(int j=0; j<4; j++)
                arr[j] = new Point(sc.nextInt(), sc.nextInt());
            Arrays.sort(arr);

            if(isSquare(arr)) System.out.println(1);
            else System.out.println(0);
        }
    }

    static boolean isSquare(Point[] arr){
        int[] dis = new int[3];

        for(int i=0; i<3; i++)
            dis[i] = getLength(arr[0], arr[i+1]);

        if(dis[0] == dis[1] && dis[0] + dis[1] == dis[2]){
            int d1 = getLength(arr[1], arr[3]);
            int d2 = getLength(arr[2], arr[3]);
            if(d1 == d2 && d1 == dis[0]) return true;
        }
        return false;
    }

    static int getLength(Point a, Point b){
        return (int)(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    static class Point implements Comparable<Point>{
        int x,y;
        public Point(int x, int y){
            this.x=x; this.y=y;
        }
        @Override
        public int compareTo(Point o) {
            if(this.x > o.x) return 1;
            else if(this.x < o.x) return -1;
            else{
                if(this.y > o.y) return 1;
                else if(this.y == o.y) return 0;
                return -1;
            }
        }
    }
}