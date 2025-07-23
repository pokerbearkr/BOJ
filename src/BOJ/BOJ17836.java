package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17836 {
    private final static int[] nextX = {-1, 0, +1, 0};
    private final static int[] nextY = {0, -1, 0, +1};
    private static int N, M, T;
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

        int time1 = way1(); // 검 없이 가는 경로
        int time2 = way2(); // 검을 획득 후 가는 경로

        // 두 경로의 시간 비교
        if (time1 == -1 && time2 == -1) {
            System.out.println("Fail");
        } else if (time1 == -1) {
            if (time2 <= T) {
                System.out.println(time2);
            } else {
                System.out.println("Fail");
            }
        } else if (time2 == -1) {
            if (time1 <= T) {
                System.out.println(time1);
            } else {
                System.out.println("Fail");
            }
        } else {
            int minTime = Math.min(time1, time2);
            if (minTime <= T) {
                System.out.println(minTime);
            } else {
                System.out.println("Fail");
            }
        }
    }

    private static int way1() {
        // 검 없이 공주님에게 가는 BFS
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int time = cur[2];

            if (x == N - 1 && y == M - 1) {
                return time;
            }
            if (time >= T) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + nextX[i];
                int ny = y + nextY[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] != 1) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, time + 1});
                    }
                }
            }
        }
        return -1; // 공주님에게 도달할 수 없을 때
    }

    private static int way2() {
        // 시작점에서 검까지 가는 BFS
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        int timeToSword = -1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int time = cur[2];

            if (x == swordX && y == swordY) {
                timeToSword = time;
                break;
            }
            if (time >= T) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + nextX[i];
                int ny = y + nextY[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] != 1) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, time + 1});
                    }
                }
            }
        }

        // 검을 찾았다면, 검에서 공주님까지 거리 계산
        if (timeToSword != -1) {
            int timeFromSwordToPrincess = Math.abs(N - 1 - swordX) + Math.abs(M - 1 - swordY);
            return timeToSword + timeFromSwordToPrincess;
        }

        return -1; // 검을 찾을 수 없을 때
    }
}