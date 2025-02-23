package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = N - 1;
        int minAbs = Integer.MAX_VALUE;
        int answerStart = 0;
        int answerEnd = 0;

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (Math.abs(sum) < minAbs) {
                minAbs = Math.abs(sum);
                answerStart = start;
                answerEnd = end;
            }

            if (sum > 0) {
                end--;
            } else if (sum < 0) {
                start++;
            } else {

                System.out.println(arr[start] + " " + arr[end]);
                return;
            }
        }

        System.out.println(arr[answerStart] + " " + arr[answerEnd]);
    }
}