package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ31738 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        if (n>=m) {
            System.out.println(0);
            return;
        }
        long fact = 1;

        for (int i = 2; i <=n ; i++) {
            fact = fact * i % m;
        }
        System.out.println(fact);
    }
}
