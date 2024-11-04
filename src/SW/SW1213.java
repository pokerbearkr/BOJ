package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1213 {
    static BufferedReader bf;

    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            test();
        }
    }

    private static void test() throws IOException {
        int tcnum = Integer.parseInt(bf.readLine());
        String target = bf.readLine();
        String moonjang = bf.readLine();

        int targetlenght = target.length();
        int moonjanglength = moonjang.length();
        int ans = 0;

        for (int i = 0; i <= moonjanglength - targetlenght; i++) {
            if (moonjang.substring(i, i + targetlenght).equals(target)) {
                ans += 1;
            }
        }

        System.out.print("#" + tcnum + " ");
        System.out.println(ans);
    }
}