package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ28701 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum+=i;
        }
        sb.append(sum).append("\n");
        sum=sum*sum;
        sb.append(sum).append("\n");
        sum=0;
        for (int i = 1; i <= n; i++) {
            sum+=i*i*i;
        }
        sb.append(sum).append("\n");
        System.out.println(sb);
    }
}
