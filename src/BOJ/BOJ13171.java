package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ13171 {
    static final long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long A = Long.parseLong(bf.readLine()); // A 입력
        long X = Long.parseLong(bf.readLine()); // X 입력

        // 결과 계산: A^X % 1000000007
        long result = modPow(A, X, MOD);

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