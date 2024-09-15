package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1012 {
    static int[][] arr;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int C = Integer.parseInt(bf.readLine());

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(bf.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int ans = 0;

            arr = new int[M][N];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (arr[j][k] == 1) {
                        baechu(j, k);
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    // DFS를 통해 인접한 배추 군집을 탐색
    public static void baechu(int x, int y) {
        if (x < 0 || x >= M || y < 0 || y >= N || arr[x][y] != 1) {
            return;
        }

        arr[x][y] = 0; // 방문 처리

        // 상, 하, 좌, 우로 탐색
        baechu(x - 1, y);
        baechu(x + 1, y);
        baechu(x, y - 1);
        baechu(x, y + 1);
    }
}