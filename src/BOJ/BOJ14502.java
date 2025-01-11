package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14502 {
    static int N, M;
    static int[][] arr;
    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, 1, 0, -1};
    static int maxSafeArea = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        List<int[]> emptySpaces = new ArrayList<>();
        Queue<int[]> virusQueue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    emptySpaces.add(new int[]{i, j});
                } else if (arr[i][j] == 2) {
                    virusQueue.add(new int[]{i, j});
                }
            }
        }

        combineWalls(0, 0, emptySpaces, virusQueue);
        System.out.println(maxSafeArea);
    }

    static void combineWalls(int start, int count, List<int[]> emptySpaces, Queue<int[]> virusQueue) {
        if (count == 3) {
            maxSafeArea = Math.max(maxSafeArea, simulateVirusSpread(virusQueue));
            return;
        }

        for (int i = start; i < emptySpaces.size(); i++) {
            int[] space = emptySpaces.get(i);
            arr[space[0]][space[1]] = 1;
            combineWalls(i + 1, count + 1, emptySpaces, virusQueue);
            arr[space[0]][space[1]] = 0;
        }
    }

    static int simulateVirusSpread(Queue<int[]> virusQueue) {
        int[][] tempArr = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new ArrayDeque<>(virusQueue);

        for (int i = 0; i < N; i++) {
            tempArr[i] = arr[i].clone();
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + moveX[i];
                int nextY = nowY + moveY[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M
                        && tempArr[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    tempArr[nextX][nextY] = 2;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempArr[i][j] == 0) {
                    safeArea++;
                }
            }
        }
        return safeArea;
    }
}