package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17086 {
    private static final int[] nextX = {1, 1, 1, 0, 0, -1, -1, -1};
    private static final int[] nextY = {1, 0, -1, 1, -1, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] distance = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int max = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];

            for (int k = 0; k < 8; k++) {
                int nx = x + nextX[k];
                int ny = y + nextY[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    distance[nx][ny] = distance[x][y] + 1;
                    max = Math.max(max, distance[nx][ny]);
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        System.out.println(max);
    }
}