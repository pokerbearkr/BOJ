package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2583 {
    private static int M;
    private static int N;
    private static int[] nextX = {1, 0, -1, 0};
    private static int[] nextY = {0, 1, 0, -1};
    private static boolean[][] visited;
    private static int partSum;
    private static ArrayList<Integer> sumArr;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new boolean[M][N];
        sumArr = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            for (int j = startY; j < endY; j++) {
                for (int k = startX; k < endX; k++) {
                    visited[j][k] = true;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    partSum = 0;
                    dfs(i, j);
                    sumArr.add(partSum);
                }
            }
        }

        Collections.sort(sumArr);
        System.out.println(sumArr.size());
        for (int area : sumArr) {
            System.out.print(area + " ");
        }
    }

    private static void dfs(int startX, int startY) {
        partSum++;
        visited[startX][startY] = true;

        for (int i = 0; i < 4; i++) {
            int nx = startX + nextX[i];
            int ny = startY + nextY[i];
            if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}