package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1245 {
    private static int[] nextX = {1, 0, -1, 0, 1, 1, -1, -1}; // 8방향
    private static int[] nextY = {0, 1, 0, -1, 1, -1, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (isPeak(map, visited, i, j, n, m)) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isPeak(int[][] map, boolean[][] visited, int x, int y, int n, int m) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        boolean isPeak = true;
        int height = map[x][y];

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int nowX = arr[0];
            int nowY = arr[1];

            for (int k = 0; k < 8; k++) {
                int nx = nowX + nextX[k];
                int ny = nowY + nextY[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] > height) {
                        isPeak = false;
                    }
                    if (map[nx][ny] == height && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return isPeak;
    }
}