package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int mod = 20000303;
        int remainder = 0;

        // 문자열로 입력받은 숫자를 한 자리씩 처리하면서 나머지 계산
        for (int i = 0; i < input.length(); i++) {
            remainder = (remainder * 10 + (input.charAt(i) - '0')) % mod;
        }

        System.out.println(remainder);
    }
}
