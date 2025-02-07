package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7562 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int[] nextX = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int[] nextY = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            System.out.println(problem());
        }
    }

    private static int problem() throws Exception {
        int I = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[I][I];

        Queue<int[]> queue = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int endX = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken());

        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int nowX = point[0];
            int nowY = point[1];
            int count = point[2];

            if (nowX == endX && nowY == endY) {
                return count;
            }

            for (int i = 0; i < 8; i++) {
                int X = nowX + nextX[i];
                int Y = nowY + nextY[i];
                if (X >= 0 && X < I && Y >= 0 && Y < I && !visited[X][Y]) {
                    visited[X][Y] = true;
                    queue.add(new int[]{X, Y, count + 1});
                }
            }

        }
        return -1;
    }
}
