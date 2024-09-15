package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int minblock = 256;
        int maxblock = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] < minblock) {
                    minblock = arr[i][j];
                }
                if (arr[i][j] > maxblock) {
                    maxblock = arr[i][j];
                }
            }
        }

        int mintime = Integer.MAX_VALUE;
        int anshigh = 0;

        for (int targethigh = minblock; targethigh <= maxblock; targethigh++) {
            int inventory = B;
            int time = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[j][k] > targethigh) {
                        time += (arr[j][k] - targethigh) * 2;
                        inventory += (arr[j][k] - targethigh);
                    } else {
                        time += (targethigh - arr[j][k]);
                        inventory -= (targethigh - arr[j][k]);
                    }
                }
            }

            if (inventory >= 0 && time <= mintime) {
                mintime = time;
                anshigh = targethigh;
            }
        }

        System.out.println(mintime + " " + anshigh);
    }
}