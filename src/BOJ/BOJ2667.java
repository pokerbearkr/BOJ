package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2667 {
    static int[][] apt;
    static boolean[][] visited;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {1, 0, -1, 0};
    static int count = 0;
    static int N;
    static int[] danjiCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        apt = new int[N][N];
        visited = new boolean[N][N];
        danjiCount = new int[N * N + 1];

        for (int i = 0; i < N; i++) {
            String[] tem = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                apt[i][j] = Integer.parseInt(tem[j]);
                if (apt[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }
        int startX, startY;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (apt[i][j] == 1 && !visited[i][j]) {
                    count++;
                    startX = i;
                    startY = j;
                    problem(startX, startY);

                }
            }
        }
        System.out.println(count);
        int[] realDanji = new int[count];
        for (int i = 1; i <= count; i++) {
            realDanji[i-1]=danjiCount[i];
        }
        Arrays.sort(realDanji);
        for (int i = 0; i < count; i++) {
            System.out.println(realDanji[i]);
        }
    }

    public static void problem(int i, int j) {
        if (i < 0 || i >= N || j < 0 || j >= N) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        apt[i][j] = count;
        danjiCount[count]++;


        for (int k = 0; k < 4; k++) {
            problem(i + moveX[k], j + moveY[k]);
        }

    }
}
