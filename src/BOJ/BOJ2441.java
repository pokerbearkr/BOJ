package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2441 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());



        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                sb.append(" ");
            }
            for (int j = i; j < n; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
