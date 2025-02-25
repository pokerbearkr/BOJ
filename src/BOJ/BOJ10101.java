package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10101 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        if (a + b + c != 180) {
            System.out.println("Error");
            return;
        }
        if (a == b || b == c || c == a) {
            if (a == b && b == c) {
                System.out.println("Equilateral");
                return;
            }
            System.out.println("Isosceles");
            return;
        }
        System.out.println("Scalene");

    }
}
