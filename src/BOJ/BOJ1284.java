package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1284 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals("0")) {
                break;
            }
            int sum = 1;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '1') {
                    sum+=2;
                } else if (c == '0') {
                    sum += 4;
                } else {
                    sum+=3;
                }
                sum+=1;
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
