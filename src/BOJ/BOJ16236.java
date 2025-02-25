package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16236 {

    static int[] moveX = {-1, 0, 0, 1};
    static int[] moveY = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int sharkX = 0, sharkY = 0, sharkSize = 2, totalTime = 0, eaten = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if (temp == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            int[] result = bfs(N, map, sharkX, sharkY, sharkSize);
            if (result == null) break;

            int nextX = result[0], nextY = result[1], dist = result[2];
            totalTime += dist;
            sharkX = nextX;
            sharkY = nextY;
            map[nextX][nextY] = 0;
            eaten++;

            if (eaten == sharkSize) {
                sharkSize++;
                eaten = 0;
            }
        }

        System.out.println(totalTime);
    }

    static int[] bfs(int N, int[][] map, int startX, int startY, int sharkSize) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        List<int[]> fishes = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], dist = current[2];

            if (dist > minDist) break;

            for (int i = 0; i < 4; i++) {
                int nextX = x + moveX[i];
                int nextY = y + moveY[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextX][nextY]) {
                    if (map[nextX][nextY] <= sharkSize) {
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY, dist + 1});

                        if (map[nextX][nextY] > 0 && map[nextX][nextY] < sharkSize) {
                            fishes.add(new int[]{nextX, nextY, dist + 1});
                            minDist = dist + 1;
                        }
                    }
                }
            }
        }

        if (fishes.isEmpty()) return null;
        fishes.sort((a, b) -> {
            if (a[2] == b[2]) {
                if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[2], b[2]);
        });

        return fishes.get(0);
    }
}