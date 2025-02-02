package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1246 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] customers = new int[M];
        for (int i = 0; i < M; i++) {
            customers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(customers);

        int eggPrice=0;
        int count=0;
        int maxPrice=0;
        for (int price : customers) {
            if ((M - count) > N) {
                if (maxPrice < N * price) {
                    eggPrice = price;
                    maxPrice = N * price;
                }
            } else {
                if(maxPrice < price*(M-count)) {
                    eggPrice = price;
                    maxPrice = price*(M-count);
                }
            }
            count++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(eggPrice).append(" ").append(maxPrice);
        System.out.println(sb);
    }
}
