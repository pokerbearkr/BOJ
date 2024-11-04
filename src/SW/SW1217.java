package SW;

import java.util.Scanner;

// 거듭제곱
public class SW1217 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            int k = sc.nextInt();
            System.out.print("#" + k + " ");
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(ans(n,m));

        }

    }

    public static int ans(int n, int m) {
        int ans=1;
        for (int i = 0; i < m; i++) {
            ans*=n;
        }
        return ans;
    }
}
