package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2440 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            String s = "*".repeat(i);
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
