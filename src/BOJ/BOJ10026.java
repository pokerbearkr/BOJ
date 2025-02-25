package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ10026 {
    private static int[] moveX = {1, 0, -1, 0};
    private static int[] moveY = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] normal = new char[N][N];
        char[][] odd = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char temp = line.charAt(j);
                normal[i][j] = temp;
                odd[i][j] = (temp == 'B') ? 'B' : 'R';
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(problem(N,normal)).append(" ").append(problem(N,odd));
        System.out.println(sb);

    }

    private static int problem(int N, char[][] arr) {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new ArrayDeque<>();

        int count=0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                    count++;
                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        int x = now[0];
                        int y = now[1];

                        for (int k = 0; k < 4; k++) {
                            int nextX = x + moveX[k];
                            int nextY = y + moveY[k];

                            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N||visited[nextX][nextY]){
                                continue;
                            } else {
                                if(arr[x][y] == (arr[nextX][nextY])) {
                                    visited[nextX][nextY] = true;
                                    queue.add(new int[] {nextX, nextY});
                                }
                            }

                        }
                    }

                }
            }
        }
        return count;
    }
}
