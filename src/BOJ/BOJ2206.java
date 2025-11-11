package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ2206 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] map = new int[N][M];
        int[] moveX = {1, 0, -1, 0};
        int[] moveY = {0, 1, 0, -1};

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        boolean[][][] visited = new boolean[N][M][2];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0, 1});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int isBreak = now[2];
            int count = now[3];

            if (nowX == N - 1 && nowY == M - 1) {
                System.out.println(count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + moveX[i];
                int nextY = nowY + moveY[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if (map[nextX][nextY] == 0 && !visited[nextX][nextY][isBreak]) {
                        queue.add(new int[]{nextX, nextY, isBreak, count + 1});
                        visited[nextX][nextY][isBreak] = true;
                    }
                    if (map[nextX][nextY] == 1 && isBreak == 0 && !visited[nextX][nextY][1]) {
                        queue.add(new int[]{nextX, nextY, 1, count + 1});
                        visited[nextX][nextY][1] = true;
                    }
                }
            }
        }

        System.out.println(-1);
    }
}