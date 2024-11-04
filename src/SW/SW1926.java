package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        test(N);
    }

    public static void test(int N) {

        for (int i = 1; i <= N; i++) {
            String target = i + "";
            int k = is369here(target);
            if (k== 0) {
                System.out.print(target+" ");
            } else {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < k; j++) {
                    sb.append("-");
                }
                System.out.print(sb+" ");
            }
        }
    }

    public static int is369here(String moonjang) {
        int ans=0;
        char[] target = moonjang.toCharArray();
        for (int i = 0; i <target.length; i++) {
            if (target[i] == '3' || target[i] == '6' || target[i] == '9') {
                ans+=1;
            }
        }
        return ans;
    }
}
