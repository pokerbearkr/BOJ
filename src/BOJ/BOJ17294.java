package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ17294 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        if (n.length() == 1) {
            System.out.println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
            System.exit(0);
        }
        int start = (int) n.charAt(0);
        int plus = (int) n.charAt(1)-start;
        for(int i=2; i<n.length(); i++) {
            int before = (int)n.charAt(i-1);
            int next = (int)n.charAt(i);
            if(next-before != plus) {
                System.out.println("흥칫뿡!! <(￣ ﹌ ￣)>");
                System.exit(0);
            }
        }
        System.out.println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
    }
}
