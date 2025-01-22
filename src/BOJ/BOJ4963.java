package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4963 {
    private static int[] nextX = {1, 0, -1, 0, 1, -1, 1, -1};
    private static int[] nextY = {0, 1, 0, -1, 1, 1, -1, -1};
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()); // 너비
            int h = Integer.parseInt(st.nextToken()); // 높이
            if (w == 0 && h == 0) break;

            int[][] map = new int[h][w];
            visited = new boolean[h][w];
            int count = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    map[i][j] = temp;
                    if (temp == 0) visited[i][j] = true;
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j]) {
                        dfs(map, i, j, h, w);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int[][] map, int startX, int startY, int h, int w) {
        visited[startX][startY] = true;

        for (int i = 0; i < 8; i++) {
            int nx = startX + nextX[i];
            int ny = startY + nextY[i];

            if (nx >= 0 && ny >= 0 && nx < h && ny < w && !visited[nx][ny] && map[nx][ny] == 1) {
                dfs(map, nx, ny, h, w);
            }
        }
    }
}