package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11944 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        String str = String.valueOf(n);
        int length = str.length();

        int min = Math.min(length*n, m);

        while (sb.length() <= min) {
            sb.append(str);
        }
        while (sb.length() != min) {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb);


    }
}
