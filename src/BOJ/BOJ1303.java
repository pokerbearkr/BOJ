package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1303 {

    private static int n,m;
    private static Character[][] map;
    private static boolean[][] visited;
    private static int[] nextX = {1, 0, -1, 0};
    private static int[] nextY = {0, 1, 0, -1};
    private static Queue<int[]> queue = new ArrayDeque<>();
    private static int count;

    private static int whiteCount =0;
    private static int blueCount=0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new Character[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    count=0;
                    bfs();
                    if (map[i][j] == 'W') {
                        whiteCount +=count*count;
                    } else if (map[i][j] == 'B') {
                        blueCount+=count*count;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(whiteCount).append(" ").append(blueCount);
        System.out.println(sb);
    }

    private static void bfs() {
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = x + nextX[i];
                int ny = y + nextY[i];
                if(nx>=0&&nx<m&&ny>=0&&ny<n&&!visited[nx][ny]&&map[nx][ny]==map[x][y]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }

        }
    }
}
