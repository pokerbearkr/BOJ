package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ28136 {
    static int N;
    static int[] A;
    static int Answer = 0;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];  // 원형 배열을 위해 N+1 크기로 선언
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void settings() {
        A[N] = A[0];  // 원형 배열처럼 마지막 값이 첫 번째 값과 연결되도록 설정
        for (int i = 0; i < N; i++) {
            if (A[i] >= A[i + 1]) {
                Answer++;
            }
        }
    }

    public static void findAnswer() {
        System.out.println(Answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        settings();
        findAnswer();
    }
}