package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1343 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                count++;
            } else if (s.charAt(i) == '.') {
                if (count > 0) {
                    if (count % 2 == 0) {
                        while (count >= 4) {
                            sb.append("AAAA");
                            count -= 4;
                        }
                        while (count >= 2) {
                            sb.append("BB");
                            count -= 2;
                        }
                    } else {
                        System.out.println(-1);
                        return;
                    }
                }
                sb.append(".");
            }
        }

        if (count > 0) {
            if (count % 2 == 0) {
                while (count >= 4) {
                    sb.append("AAAA");
                    count -= 4;
                }
                while (count >= 2) {
                    sb.append("BB");
                    count -= 2;
                }
            } else {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(sb);
    }
}