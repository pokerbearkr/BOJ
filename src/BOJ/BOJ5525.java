package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // PN에서 N
        int M = Integer.parseInt(bf.readLine()); // 문자열 S의 길이
        String S = bf.readLine();

        int count = 0; // PN의 개수
        int patternCount = 0; // IOI 패턴 반복 횟수

        for (int i = 1; i < M - 1; i++) {
            // "IOI" 패턴 확인
            if (S.charAt(i - 1) == 'I' && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                patternCount++; // IOI 패턴이 발견되면 카운트 증가
                if (patternCount == N) {
                    count++; // N번 반복된 경우 PN 발견
                    patternCount--; // 겹침을 위해 패턴 하나 감소
                }
                i++; // O 다음부터 다시 검사
            } else {
                patternCount = 0; // 패턴이 끊기면 초기화
            }
        }

        System.out.println(count);
    }
}
