package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3184 {

    private static int n;
    private static int m;
    private static char[][] arr;
    private static boolean[][] visited;

    private static int sheep;
    private static int wolf;
    private static int totalSheep;
    private static int totalWolf;

    private static int[] nextX = {1, 0, -1, 0};
    private static int[] nextY = {0, 1, 0, -1};




    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visited = new boolean[n][m];

        totalSheep=0;
        totalWolf=0;


        for (int i = 0; i < n; i++) {
            String str = bf.readLine();
            for (int j = 0; j < m; j++) {
                char ch = str.charAt(j);
                if (ch == '#') {
                    visited[i][j] = true;
                }
                arr[i][j]=ch;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    sheep = 0;
                    wolf = 0;
                    dfs(i, j);
                    if (sheep > wolf) {
                        totalSheep += sheep;
                    } else {
                        totalWolf += wolf;
                    }
                }
            }
        }

        sb.append(totalSheep).append(" ").append(totalWolf);
        System.out.println(sb);

    }

    private static void dfs(int x, int y) {
        if (arr[x][y] == 'o') {
            sheep++;
        } else if (arr[x][y] == 'v') {
            wolf++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + nextX[i];
            int ny = y + nextY[i];

            if(nx>=0&&ny>=0&&nx<n&&ny<m&&!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }

    }
}
