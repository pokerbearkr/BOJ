package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2573 {
    private static int n, m;
    private static int iceCount = 0;

    private static int[] nextX = {1, 0, -1, 0};
    private static int[] nextY = {0, 1, 0, -1};

    private static int[][] ice;
    private static int[][] tem;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ice = new int[n][m];
        tem = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                ice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {
            visited = new boolean[n][m];
            iceCount = 0;

            countIce();

            if (iceCount >= 2) {
                System.out.println(year);
                break;
            }

            if (iceCount == 0) {
                System.out.println(0);
                break;
            }

            oneYear();
            year++;
        }
    }

    private static void oneYear() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ice[i][j] != 0) {
                    int waterCount = 0;
                    for (int k = 0; k < 4; k++) {
                        int x = i + nextX[k];
                        int y = j + nextY[k];
                        if (x >= 0 && x < n && y >= 0 && y < m && ice[x][y] == 0) {
                            waterCount++;
                        }
                    }
                    tem[i][j] = Math.max(0, ice[i][j] - waterCount);
                } else {
                    tem[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.arraycopy(tem[i], 0, ice[i], 0, m);
        }
    }

    private static void countIce() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ice[i][j] != 0 && !visited[i][j]) {
                    iceCount++;
                    dfs(i, j);
                }
            }
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + nextX[i];
            int newY = y + nextY[i];

            if (newX >= 0 && newY >= 0 && newX < n && newY < m && !visited[newX][newY] && ice[newX][newY] != 0) {
                dfs(newX, newY);
            }
        }
    }
}