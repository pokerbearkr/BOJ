package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ1247 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int N = Integer.parseInt(br.readLine());
            BigInteger sum = BigInteger.ZERO;
            for (int j = 0; j < N; j++) {
                sum = sum.add(BigInteger.valueOf(Long.parseLong(br.readLine())));
            }
            if (sum.compareTo(BigInteger.ZERO)>0) {
                sb.append("+\n");
            } else if (sum.compareTo(BigInteger.ZERO)==0) {
                sb.append("0\n");
            } else {
                sb.append("-\n");
            }
        }
        System.out.println(sb);
    }
}
