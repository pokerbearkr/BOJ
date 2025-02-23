package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16933 {
    private static class State {
        int x, y, kCount, count;
        boolean isDay;

        State(int x, int y, int kCount, int count, boolean isDay) {
            this.x = x;
            this.y = y;
            this.kCount = kCount;
            this.count = count;
            this.isDay = isDay;
        }
    }

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][][][] visited = new boolean[n][m][k + 1][2];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        Queue<State> queue = new ArrayDeque<>();
        queue.add(new State(0, 0, 0, 1, true));
        visited[0][0][0][1] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            if (cur.x == n - 1 && cur.y == m - 1) {
                System.out.println(cur.count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 0 && !visited[nx][ny][cur.kCount][cur.isDay ? 1 : 0]) {
                        visited[nx][ny][cur.kCount][cur.isDay ? 1 : 0] = true;
                        queue.add(new State(nx, ny, cur.kCount, cur.count + 1, !cur.isDay));
                    } else if (map[nx][ny] == 1 && cur.kCount < k && cur.isDay && !visited[nx][ny][cur.kCount + 1][0]) {
                        visited[nx][ny][cur.kCount + 1][0] = true;
                        queue.add(new State(nx, ny, cur.kCount + 1, cur.count + 1, false));
                    }
                }
            }

            // **밤에는 제자리에서 대기할 수 있어야 한다.**
            if (!cur.isDay && !visited[cur.x][cur.y][cur.kCount][1]) {
                visited[cur.x][cur.y][cur.kCount][1] = true;
                queue.add(new State(cur.x, cur.y, cur.kCount, cur.count + 1, true));
            }
        }

        System.out.println(-1);
    }
}
