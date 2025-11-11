package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1402 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            problem();
        }
        System.out.println(sb);
    }

    private static void problem() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int tem = A;
        int sum = 0;

        for (int i = 2; i <= Math.sqrt(A); i++) {
            while (tem % i == 0) {
                    sum += i;
                    tem = tem / i;
            }
        }
        if (tem > 1) {
            sum+=tem;
        }
        if (sum <= B) {
            sb.append("yes\n");
        } else {
            sb.append("NO\n");
        }
    }
}
