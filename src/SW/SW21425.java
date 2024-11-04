package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW21425 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            System.out.println(test(A, B, N));
        }
    }

    public static int test(int A, int B, int N) {
        int ans=0;
        while (A > N || B > N) {

        }
    return 1;
    }
}
