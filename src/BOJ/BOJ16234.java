package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16234 {
    private static int n, L, R;
    private static int[][] map;
    private static boolean[][] visited;
    private static List<int[]> cowork;
    private static Queue<int[]> queue;
    private static int ans = 0;

    private static final int[] nextX = {1, 0, -1, 0};
    private static final int[] nextY = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            visited = new boolean[n][n];
            boolean isMoved = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        cowork = new ArrayList<>();
                        queue = new ArrayDeque<>();

                        queue.add(new int[]{i, j});
                        cowork.add(new int[]{i, j});
                        visited[i][j] = true;

                        if (bfs()) {
                            isMoved = true; // 인구 이동 발생했음
                        }
                    }
                }
            }

            if (!isMoved) break;
            ans++;
        }

        System.out.println(ans);
    }

    private static boolean bfs() {
        boolean moved = false;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + nextX[i];
                int ny = y + nextY[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    int diff = Math.abs(map[x][y] - map[nx][ny]);
                    if (diff >= L && diff <= R) {
                        queue.add(new int[]{nx, ny});
                        cowork.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        moved = true;
                    }
                }
            }
        }

        if (cowork.size() > 1) {
            int sum = 0;
            for (int[] value : cowork) {
                sum += map[value[0]][value[1]];
            }
            int newPopulation = sum / cowork.size();

            for (int[] value : cowork) {
                map[value[0]][value[1]] = newPopulation;
            }
        }

        return moved;
    }
}