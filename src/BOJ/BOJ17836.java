package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17836 {
    private final static int[] nextX = {-1, 0, +1, 0};
    private final static int[] nextY = {0, -1, 0, +1};
    private static int N,M,T;
    private static int[][] map;
    private static int swordX, swordY;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tem = Integer.parseInt(st.nextToken());
                if (tem == 2) {
                    swordX = i;
                    swordY = j;
                }
                map[i][j] = tem;
            }
        }

    }

    private static int way1() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int time = cur[2];
            if (time > T) {
                return -1;
            }
            if(x==N-1 && y==M-1) return time;
        }
        return -1;
    }

    private static int way2() {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        return -1;
    }
}
