package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14442 {

    private static int[] nextX = {1, 0, -1, 0};
    private static int[] nextY = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];
            int breakCount = cur[3];

            if (x == n && y == m) {
                System.out.println(count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + nextX[i];
                int ny = y + nextY[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    if (map[nx][ny] == 1) {
                    }

                }
            }

        }
    }
}
