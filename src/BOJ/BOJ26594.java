package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ26594 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (s.length() == 0) {
            return;
        }
        


        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
        }
        System.out.println(count);
    }
}