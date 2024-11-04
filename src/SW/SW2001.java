package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW2001 {
    static BufferedReader bf;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for (int i = 1; i <= T; i++) {
            System.out.print("#" + i + " ");
            System.out.println(test());
        }
    }

    public static int test() throws IOException {
        st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] fly = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                fly[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;

        for (int i = 0; i <= N - M; i++) {
            for (int j = 0; j <= N - M; j++) {
                int tem = 0;

                for (int k = 0; k < M; k++) {
                    for (int l = 0; l < M; l++) {
                        tem += fly[i + k][j + l];
                    }
                }
                if (tem > ans) {
                    ans = tem;
                }
            }
        }
        return ans;
    }
}