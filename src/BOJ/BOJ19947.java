package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ19947 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int temMoney = H;

        for (int i = 0; i < Y; i++) {
            temMoney *= 1.05;
        }
        int A = temMoney;
        
        temMoney = H;
        for (int i = 0; i < Y/3; i++) {
            temMoney *= 1.2;
        }
        int B = temMoney;

        temMoney = H;
        for (int i = 0; i < Y / 5; i++) {
            temMoney *= 1.35;
        }
        int C = temMoney;

        System.out.println(Math.max(A,Math.max(B,C)));
    }
}
