package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2752 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] n = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        StringBuilder sb = new StringBuilder();
        Arrays.sort(n);
        for (int i = 0; i < 3; i++) {
            sb.append(n[i]).append(" ");
        }
        System.out.println(sb);
    }
}
