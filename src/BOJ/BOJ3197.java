package BOJ;
import java.io.*;
import java.util.*;

public class BOJ3197 {
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {1, 0, -1, 0};
    static char[][] arr;
    static int R, C;
    static int[] start, end;
    static Queue<int[]> waterQueue = new LinkedList<>();
    static Queue<int[]> swanQueue = new LinkedList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            String tem = bf.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = tem.charAt(j);
                if (arr[i][j] == 'L') {
                    if (start == null) {
                        start = new int[]{i, j};
                    } else {
                        end = new int[]{i, j};
                    }
                    arr[i][j] = '.';
                }
                if (arr[i][j] == '.') {
                    waterQueue.add(new int[]{i, j});
                }
            }
        }

        swanQueue.add(start);
        visited = new boolean[R][C];
        visited[start[0]][start[1]] = true;

        int days = 0;
        while (true) {
            if (bfsSwan()) {
                System.out.println(days);
                break;
            }
            meltIce();
            days++;
        }
    }

    public static boolean bfsSwan() {
        Queue<int[]> tempQueue = new LinkedList<>(swanQueue);
        swanQueue.clear();
        boolean found = false;

        while (!tempQueue.isEmpty()) {
            int[] pos = tempQueue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nextX = pos[0] + moveX[dir];
                int nextY = pos[1] + moveY[dir];

                if (nextX == end[0] && nextY == end[1]) {
                    found = true;
                    break;
                }

                if (nextX >= 0 && nextY >= 0 && nextX < R && nextY < C && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    if (arr[nextX][nextY] == '.') {
                        tempQueue.add(new int[]{nextX, nextY});
                    } else if (arr[nextX][nextY] == 'X') {
                        swanQueue.add(new int[]{nextX, nextY});
                    }
                }
            }
            if (found) break;
        }

        return found;
    }

    public static void meltIce() {
        int size = waterQueue.size();
        for (int i = 0; i < size; i++) {
            int[] pos = waterQueue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nextX = pos[0] + moveX[dir];
                int nextY = pos[1] + moveY[dir];

                if (nextX >= 0 && nextY >= 0 && nextX < R && nextY < C && arr[nextX][nextY] == 'X') {
                    arr[nextX][nextY] = '.';
                    waterQueue.add(new int[]{nextX, nextY});
                }
            }
        }
    }
}