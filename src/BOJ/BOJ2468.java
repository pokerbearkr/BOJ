package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2468 {
    static int[][] arr;
    static boolean[][] visited;
    static int n;
    static int[] dx = {0, 0, -1, 1}; // 상하좌우 이동
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        int waterMax = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                waterMax = Math.max(waterMax, arr[i][j]);
            }
        }

        int maxSafeZones = 0;

        for (int water = 0; water <= waterMax; water++) {
            visited = new boolean[n][n];
            int safeZones = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && arr[i][j] > water) {
                        dfs(i, j, water);
                        safeZones++;
                    }
                }
            }

            maxSafeZones = Math.max(maxSafeZones, safeZones);
        }

        System.out.println(maxSafeZones);
    }

    private static void dfs(int x, int y, int water) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (!visited[nx][ny] && arr[nx][ny] > water) {
                    dfs(nx, ny, water);
                }
            }
        }
    }
}