package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1264 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Character[] mo = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        while(true) {
            String s = br.readLine();
            if (s.equals("#")) {
                return;
            }
            int sum=0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(Arrays.asList(mo).contains(c)) {
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }
}
