package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2018 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 1; // 자기자신 1개는 무조건 들어감
        int sum = 0;
        int start = 1;
        int end = 1;

        while (end <= N) { // end가 N 보다 커지면 종료
            if (sum < N) { // sum이 N보다 작으면 오른쪽을 늘림
                sum += end;
                end++;
            } else if (sum > N) {
                sum -= start;
                start++;
            } else {
                count++;
                sum -= start;
                start++;
                sum += end;
                end++;
            }
        }
        System.out.println(count);
    }
}