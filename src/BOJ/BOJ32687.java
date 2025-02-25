package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ32687 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        System.out.println(countKRepeats(A, B, K, M));
    }

    private static long countKRepeats(long A, long B, int K, long M) {
        long count = 0;

        // K자리 수 범위
        long start = (long) Math.pow(10, K - 1);
        long end = (long) Math.pow(10, K) - 1;

        for (long base = start; base <= end; base++) {
            StringBuilder repeated = new StringBuilder();

            // 반복해서 숫자를 붙이고 뒤에서 자르기
            while (true) {
                repeated.append(base);
                String fullNumber = repeated.toString();

                // 뒤에서 0개 이상 자르면서 검사
                for (int cut = 0; cut <= fullNumber.length() - K; cut++) {
                    String numStr = fullNumber.substring(0, fullNumber.length() - cut);
                    long num = Long.parseLong(numStr);

                    // 범위와 조건 확인
                    if (num >= A && num <= B && num % M == 0) {
                        count++;
                    }

                    // num이 범위를 벗어나면 더 이상 검사하지 않음
                    if (num > B) {
                        break;
                    }
                }

                // 반복 문자열이 B 이상이 되면 종료
                if (repeated.length() > String.valueOf(B).length()) {
                    break;
                }
            }
        }

        return count;
    }
}