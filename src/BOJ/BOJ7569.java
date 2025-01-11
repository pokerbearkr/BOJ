package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {
    static int[][][] tomato;
    static boolean[][][] visited;
    static int[] moveX = {0, 1, 0, -1, 0, 0};
    static int[] moveY = {1, 0, -1, 0, 0, 0};
    static int[] moveZ = {0, 0, 0, 0, 1, -1};
    static int N, M, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[N][M][H];
        visited = new boolean[N][M][H];

        Queue<int[]> queue = new LinkedList<>();
        int unripeCount = 0;

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    tomato[n][m][h] = Integer.parseInt(st.nextToken());
                    if (tomato[n][m][h] == 1) {
                        queue.add(new int[]{n, m, h, 0});
                        visited[n][m][h] = true;
                    } else if (tomato[n][m][h] == 0) {
                        unripeCount++;
                    }
                }
            }
        }


        int maxDays = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], z = current[2], days = current[3];
            maxDays = Math.max(maxDays, days);

            for (int i = 0; i < 6; i++) {
                int nx = x + moveX[i];
                int ny = y + moveY[i];
                int nz = z + moveZ[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H) {
                    if (!visited[nx][ny][nz] && tomato[nx][ny][nz] == 0) {
                        visited[nx][ny][nz] = true;
                        tomato[nx][ny][nz] = 1;
                        queue.add(new int[]{nx, ny, nz, days + 1});
                        unripeCount--;
                    }
                }
            }
        }

        if (unripeCount == 0) {
            System.out.println(maxDays);
        } else {
            System.out.println(-1);
        }
    }
}