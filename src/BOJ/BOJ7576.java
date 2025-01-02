package BOJ;

import java.io.*;
import java.util.*;

public class BOJ7576 {
    static int N, M;
    static int[][] tomato;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomato = new int[N][M];

        Queue<int[]> queue = new LinkedList<>();
        int emptyCount = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    queue.add(new int[]{i, j}); // 익은 토마토 위치 저장
                } else if (tomato[i][j] == -1) {
                    emptyCount++; // 빈 칸 개수 세기
                }
            }
        }

        int totalCells = N * M;
        int ripeCount = queue.size(); // 처음부터 익은 토마토 개수
        int dayCount = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    // 경계 조건 확인 및 익히기
                    if (nx >= 0 && ny >= 0 && nx < N && ny < M && tomato[nx][ny] == 0) {
                        tomato[nx][ny] = 1;
                        queue.add(new int[]{nx, ny});
                        ripeCount++;
                    }
                }
            }
            if (!queue.isEmpty()) dayCount++;
        }

        if (ripeCount + emptyCount == totalCells) {
            System.out.println(dayCount);
        } else {
            System.out.println(-1);
        }
    }
}