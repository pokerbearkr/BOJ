package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ3053 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        double a = Math.PI*n*n;
        double b = 2.0*n*n;

        System.out.printf("%.6f\n",a);
        System.out.printf("%.6f",b);
    }
}
