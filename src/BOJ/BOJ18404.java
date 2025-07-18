package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18404 {
    private static final int[] nextX = {1, 2, 2, 1, -1, -2, -2, -1};
    private static final int[] nextY = {2, 1, -1, -2, -2, -1, 1, 2};
    private static int[][] dist;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken()) - 1;
        int startY = Integer.parseInt(st.nextToken()) - 1;

        dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }
        bfs(startX, startY);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int enemyX = Integer.parseInt(st.nextToken()) - 1;
            int enemyY = Integer.parseInt(st.nextToken()) - 1;
            sb.append(dist[enemyX][enemyY]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        dist[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int nowX = cur[0];
            int nowY = cur[1];

            for (int i = 0; i < 8; i++) {
                int nx = nowX + nextX[i];
                int ny = nowY + nextY[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[nowX][nowY] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
