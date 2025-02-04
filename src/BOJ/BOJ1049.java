package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1049 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] sixPackage = new int[M];
        int[] onePackage = new int[M];

        for (int i = 0; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            sixPackage[i] = Integer.parseInt(st.nextToken());
            onePackage[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sixPackage);
        Arrays.sort(onePackage);

        int sixPrice = sixPackage[0];
        int onePrice = onePackage[0];

        if ((double)sixPrice / 6 > onePrice) {
            System.out.println(N*onePrice);
            return;
        }

        int totalPrice = 0;
        totalPrice = Math.min((N / 6) * sixPrice + N % 6 * onePrice, (N / 6 + 1) * sixPrice);
        System.out.println(totalPrice);

    }
}
