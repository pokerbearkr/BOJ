package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ21736 {
    static int N, M;
    static int[] movex = {0, 1, 0, -1};
    static int[] movey = {1, 0, -1, 0};
    static int startx, starty;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String tem = bf.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = tem.charAt(j);
                if (arr[i][j] == 'I') {
                    startx = i;
                    starty = j;
                }
            }
        }

        int result = bfs();
        if (result == 0) {
            System.out.println("TT");
        } else {
            System.out.println(result);
        }
    }

    private static int bfs() {
        boolean[][] visited = new boolean[N][M];
        visited[startx][starty] = true;

        Deque<int[]> bfsQueue = new ArrayDeque<>();
        bfsQueue.add(new int[]{startx, starty});

        int count = 0;

        while (!bfsQueue.isEmpty()) {
            int[] current = bfsQueue.poll();
            int curX = current[0];
            int curY = current[1];

            for (int dir = 0; dir < 4; dir++) {
                int nextX = curX + movex[dir];
                int nextY = curY + movey[dir];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;

                    if (arr[nextX][nextY] == 'P') {
                        count++;
                    }

                    if (arr[nextX][nextY] != 'X') {
                        bfsQueue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
        return count;
    }
}