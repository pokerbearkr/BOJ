package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ24389 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int m = ~n + 1; // n의 2의 보수

        int tem = n ^ m; // n과 2의 보수의 서로 다른 비트(1)를 구함

        int ans = 0;

        // tem이 0이 아닐 때까지 반복
        while (tem != 0) {
            // 가장 오른쪽 비트가 1인지 확인
            if ((tem & 1) == 1) {
                ans++;
            }
            // tem을 오른쪽으로 한 칸 이동
            tem >>>= 1;
        }

        System.out.println(ans);
    }
}