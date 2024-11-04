package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long A = Long.parseLong(st.nextToken()); // A
        long X = Long.parseLong(st.nextToken()); // X
        long C = Long.parseLong(st.nextToken()); // C

        // 결과 계산: A^X % C
        long result = modPow(A, X, C);

        // 결과 출력
        System.out.println(result);
    }

    // 빠른 거듭제곱 메서드 (분할 정복 방식)
    public static long modPow(long base, long exp, long mod) {
        long result = 1;
        base = base % mod; // base를 mod로 미리 나눔

        while (exp > 0) {
            // 현재 지수가 홀수면 result에 base 곱하고 mod로 나눔
            if ((exp % 2) == 1) {
                result = (result * base) % mod;
            }

            // base를 제곱하고 mod로 나눔
            base = (base * base) % mod;

            // 지수를 절반으로 나눔
            exp = exp / 2;
        }

        return result;
    }
}