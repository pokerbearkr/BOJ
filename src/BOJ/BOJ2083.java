package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2083 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] s = br.readLine().split(" ");
            if(s[0].equals("#")&&s[1].equals("0")&&s[2].equals("0")) break;

            if (Integer.parseInt(s[1]) > 17 || Integer.parseInt(s[2]) >= 80) {
                sb.append(s[0]).append(" ").append("Senior").append("\n");
            } else {
                sb.append(s[0]).append(" ").append("Junior").append("\n");
            }
        }
        System.out.println(sb);
    }
}
