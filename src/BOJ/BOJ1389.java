package BOJ;

import java.util.Arrays;

public class BOJ1389 {
    static final int INF = 1000000;

    public static void main(String[] args) throws Exception {

        int n = read(); // 유저 수
        int m = read(); // 친구 관계 수
        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0; // 자기 자신으로의 거리는 0
        }

        for (int i = 0; i < m; i++) {
            int a =read();
            int b =read();
            dist[a][b] = 1;
            dist[b][a] = 1; // 무방향 그래프
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int minPerson = 0;
        int minBacon = INF;

        for (int i = 1; i <= n; i++) {
            int baconSum = 0;
            for (int j = 1; j <= n; j++) {
                baconSum += dist[i][j];
            }
            if (baconSum < minBacon) {
                minBacon = baconSum;
                minPerson = i;
            } else if (baconSum == minBacon && i < minPerson) {
                minPerson = i;
            }
        }

        System.out.println(minPerson);

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}