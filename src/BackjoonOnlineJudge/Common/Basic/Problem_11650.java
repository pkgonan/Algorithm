package BackjoonOnlineJudge.Common.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem_11650 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Point> arr = new ArrayList<>();

        while (--N >= 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(arr, new Point());

        for(Point now : arr)
            System.out.println(now.x + " " + now.y);
    }

    static class Point implements Comparator<Point>{
        int x,y;
        public Point(int x, int y){
            this.x=x; this.y=y;
        }
        public Point() {}
        @Override
        public int compare(Point o1, Point o2) {
            if(o1.x < o2.x) return -1;
            else if(o1.x == o2.x) {
                if(o1.y < o2.y) return -1;
                else if(o1.y == o2.y) return 0;
                else return 1;
            }
            else return 1;
        }
    }
}