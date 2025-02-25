package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1094 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int t = 64;
        int ans =0;
        while (n!=0)
            if (n >= t) {
                n-=t;
                t/=2;
                ans++;
            }else{
                t/=2;
            }
        System.out.println(ans);
    }
}
