package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ13235 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        boolean ispallin = true;
        int len = target.length();
        for (int i = 0; i <len/2 ; i++) {
            if (target.charAt(i) != target.charAt(len - i-1)) {
                ispallin = false;
                break;
            }
        }
        if (ispallin) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }
}
