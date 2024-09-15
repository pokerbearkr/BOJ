package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9625 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int A = 0;
        int B = 1;
        int tem = 0;
        for (int i = 1; i < N; i++) {
            tem = A;
            A = B;
            B += tem;

        }
        System.out.print(A + " ");
        System.out.print(B);
    }
}
