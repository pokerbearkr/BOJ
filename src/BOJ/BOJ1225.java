package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1225 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        String s2 = st.nextToken();

        long sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int num1 = s.charAt(i) - '0';
            for (int j = 0; j < s2.length(); j++) {
                int num2 = s2.charAt(j) - '0';
                sum += (long) num1 * num2;
            }
        }
        System.out.println(sum);
    }
}
