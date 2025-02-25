package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1977 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum=0;
        int low=10000000;

        for (int i = 1; i <= 100 ; i++) {

            int target = i*i;

            if (target >= m && target <= n) {
                sum+=target;
                low=Math.min(low,target);
            }

            if (target > n) {
                break;
            }

        }
        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(low);
        }

    }
}
