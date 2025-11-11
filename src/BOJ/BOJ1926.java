package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1926 {

    private static int[] nextX = {1, 0, -1, 0};
    private static int[] nextY = {0, 1, 0, -1};

    private static int[][] painting;
    private static boolean[][] visited;


    private static int n;
    private static int m;
    private static int size;
    private static int maxSize=0;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        painting = new int[n][m];
        visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int temp = Integer.parseInt(st.nextToken());
                painting[i][j] = temp;

                if (temp == 0) {
                    visited[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j]) {
                    count++;
                    size = 0;
                    visited[i][j] = true;
                    dfs(i,j);
                }
            }
        }
        System.out.println(count);
        System.out.println(maxSize);


    }

    private static void dfs(int x, int y) {
        size++;
        if(size>maxSize) maxSize=size;

        for (int i = 0; i < 4; i++) {
            int nx = x + nextX[i];
            int ny = y + nextY[i];

            if(nx>=0&&ny>=0&&nx<n&&ny<m&&!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx,ny);
            }
        }
    }
}
