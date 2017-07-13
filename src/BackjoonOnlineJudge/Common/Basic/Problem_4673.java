package BackjoonOnlineJudge.Common.Basic;

public class Problem_4673 {
    public static void main(String[] args){
        boolean[] check = new boolean[10001];

        for(int i=1; i<=10000; i++) {
            int n = i;
            if(check[n]) continue;

            while (n <= 10000){
                int next = getNext(n);
                if(next > 10000 || n==next) break;
                check[next] = true;
                n = next;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=10000; i++)
            if(!check[i])
                sb.append(String.valueOf(i)).append('\n');

        System.out.println(sb.toString());
    }

    static int getNext(int n){
        int sum = n;
        while (n > 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}