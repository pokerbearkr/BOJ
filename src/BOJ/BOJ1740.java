package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1740 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long ans = 0;
        long powOf3 = 1;

        while (n > 0) {
            // n의 가장 오른쪽 비트가 1인지 확인
            if ((n & 1) == 1) {
                ans += powOf3;
            }

            // n을 오른쪽으로 1비트 이동
            n >>= 1;

            // 3의 거듭제곱 값을 갱신
            powOf3 *= 3;
        }

        System.out.println(ans);
    }
}