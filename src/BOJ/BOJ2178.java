package BOJ;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class BOJ2178 {
    static boolean[][] arr;
    static int N, M;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        N = read();
        M = read();
        arr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = System.in.read() == '1';
            }
            System.in.read();
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        Deque<int[]> bfsQueue = new ArrayDeque<>();
        bfsQueue.add(new int[]{0, 0});

        int count, time = 1;
        int[] temp;
        while (!bfsQueue.isEmpty()) {
            time++;

            count = bfsQueue.size();
            for (int i = 0; i < count; i++) {
                temp = bfsQueue.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nextX = temp[0] + moveX[dir];
                    int nextY = temp[1] + moveY[dir];

                    if (nextX == N - 1 && nextY == M - 1) {
                        return time;
                    }

                    if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M  && !visited[nextX][nextY] && arr[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        bfsQueue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
        return -1;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
