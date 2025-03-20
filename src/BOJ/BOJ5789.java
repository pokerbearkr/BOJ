package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ5789 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            int length = s.length();
            if (s.charAt(length / 2) == s.charAt(length / 2 - 1)) {
                System.out.println("Do-it");
            } else {
                System.out.println("Do-it-Not");
            }
        }
    }
}
