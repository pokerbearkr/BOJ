package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ14935 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int num = Integer.parseInt(s.charAt(0)+"")*s.length();

        for (int i = 0; i < 1000; i++) {
            String temString = String.valueOf(num);
            int tem = Integer.parseInt(temString.charAt(0)+"")*temString.length();
            if (tem == num) {
                System.out.println("FA");
                return;
            } else {
                num=tem;
            }
        }
        System.out.println("NFA");
    }
}
