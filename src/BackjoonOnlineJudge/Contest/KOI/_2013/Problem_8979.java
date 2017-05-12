package BackjoonOnlineJudge.Contest.KOI._2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_8979 {
    static int N, K;
    static PriorityQueue<Medal> pq;

    public static void main(String[] args) throws IOException{
        init();
        printResult();
    }

    static void printResult(){
        int rank = 0, cnt = 0;
        Medal before = null;

        while(!pq.isEmpty()){
            Medal now = pq.poll();

            if(before != null && now.gold==before.gold && now.silver==before.silver && now.bronze==before.bronze)
                cnt++;
            else{
                rank = ++rank + cnt;
                cnt = 0;
            }

            before = now;
            if(now.num == K) break;
        }
        System.out.println(rank);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            pq.add(new Medal(num, gold, silver, bronze));
        }
    }

    static class Medal implements Comparable<Medal>{
        int num, gold, silver, bronze;
        public Medal(int num, int gold, int silver, int bronze){
            this.num=num; this.gold=gold; this.silver=silver; this.bronze=bronze;
        }

        @Override
        public int compareTo(Medal o) {
            if(this.gold == o.gold){
                if(this.silver==o.silver){
                    if(this.bronze < o.bronze) return 1;
                    else if(this.bronze == o.bronze) return 0;
                    else return -1;
                }
                else{
                    if(this.silver < o.silver) return 1;
                    else if(this.silver == o.silver) return 0;
                    else return -1;
                }
            }
            else{
                if(this.gold < o.gold) return 1;
                else if(this.gold == o.gold) return 0;
                else return -1;
            }
        }
    }
}