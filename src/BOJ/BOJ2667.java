package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2667 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[][] apart = new int[N][N];

        for (int i = 0; i < N; i++) {
            String tem = bf.readLine();
            for (int j = 0; j < N; j++) {
                apart[i][j] = Character.getNumericValue(tem.charAt(j));
            }
        }

        boolean[][] used = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (used[i][j]) {
                    continue;
                } else {

                }
            }
        }



    }
}
