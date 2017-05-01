package BackjoonOnlineJudge.Common.BitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_11723{
    static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        int M = Integer.parseInt(sc.readLine());
        int bitNum = 0;

        for(int i=0; i<M; i++){
            String[] s = sc.readLine().split(" ");
            if(s[0].equals("all") || s[0].equals("empty")){
                if(s[0].equals("all")) bitNum = (1<<20)-1;
                else bitNum = 0;
            }
            else{
                int n = Integer.parseInt(s[1])-1;

                if(s[0].equals("add") && ((bitNum & (1<<n))==0))
                    bitNum = bitNum | (1<<n);
                else if(s[0].equals("check")){
                    if((bitNum & (1<<n)) == 0) sb.append(0+"\n");
                    else sb.append(1+"\n");
                }
                else if(s[0].equals("toggle")){
                    if((bitNum & (1<<n)) == 0) bitNum = bitNum | (1<<n);
                    else bitNum = bitNum ^ (1<<n);
                }
                else{
                    if((bitNum & (1<<n)) != 0) bitNum = bitNum & ~(1<<n);
                }
            }
        }
        System.out.print(sb.toString());
    }
}