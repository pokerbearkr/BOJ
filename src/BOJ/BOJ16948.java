package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16948 {
    private final static int[] nextX = {-2, -2, 0, 0, +2, +2};
    private final static int[] nextY = {-1, +1, -2, +2, -1, +1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int endX = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startX, startY,0});
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];
            if (x == endX && y == endY) {
                System.out.println(count);
                return;
            }
            for (int i = 0; i < 6; i++) {
                int nX = x + nextX[i];
                int nY = y + nextY[i];
                if(nX>=0&&nY>=0&&nX<N&&nY<N&&!visited[nX][nY]) {
                    visited[nX][nY] = true;
                    queue.add(new int[]{nX, nY,count+1});
                }
            }
        }

        System.out.println(-1);

    }
}
