package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW2007 {

    static BufferedReader bf;

    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for (int i = 1; i < T + 1; i++) {
            System.out.print("#" + i + " ");
            System.out.println(solution());
        }

    }

    private static int solution() throws IOException {
        String target = bf.readLine();
        for (int i = 1; i <= 10; i++) {
            if (target.length() % i == 0) {
                if (isPattern(i, target)) {
                    return i;
                }
            }
        }
        return 1;
    }

    public static boolean isPattern(int n, String target) {
        String pattern = target.substring(0, n);
        for (int i = 0; i < target.length(); i += n) {
            if (!pattern.equals(target.substring(i, i + n))) {
                return false;
            }
        }
        return true;
    }
}