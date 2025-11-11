package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7453 {
    public static void main(String[] args) throws Exception {
        // 데이터 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 배열 선언
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];

        // 데이터 입력
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        // AB, CD 더한 배열 생성
        int[] sumAB = new int[N*N];
        int[] sumCD = new int[N*N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sumAB[count]=A[i]+B[j];
                sumCD[count]=C[i]+D[j];
                count++;
            }
        }

        Arrays.sort(sumAB);
        Arrays.sort(sumCD);

        // long으로 타입 변경
        long answer = 0;
        int left = 0; // sumAB 배열의 시작
        int right = N * N - 1; // sumCD 배열의 끝

        while (left < N * N && right >= 0) {
            // currentSum도 long으로 계산
            long currentSum = (long) sumAB[left] + sumCD[right];

            if (currentSum == 0) {
                // 중복된 값의 개수를 세서 곱해줌.
                long countA = 0;
                long countB = 0;
                int currentA = sumAB[left];
                int currentB = sumCD[right];

                while (left < N * N && sumAB[left] == currentA) {
                    countA++;
                    left++;
                }

                while (right >= 0 && sumCD[right] == currentB) {
                    countB++;
                    right--;
                }
                answer += countA * countB;
            } else if (currentSum < 0) {
                // 합이 0보다 작으면, sumAB의 값을 키워야 하므로 left 포인터를 이동
                left++;
            } else {
                // 합이 0보다 크면, sumCD의 값을 줄여야 하므로 right 포인터를 이동
                right--;
            }
        }
        System.out.println(answer);
    }
}