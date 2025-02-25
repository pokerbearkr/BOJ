package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12782 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int A, B;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken(), 2);
            B = A ^ Integer.parseInt(st.nextToken(), 2);
            A &= B;
            A = Integer.bitCount(A);
            B = Integer.bitCount(B) - A;
            sb.append(Math.max(A, B)).append("\n");
        }

        System.out.println(sb);
    }
}
