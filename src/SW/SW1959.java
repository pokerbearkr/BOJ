package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1959 {

    static BufferedReader bf;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for (int i = 1; i < T+1; i++) {
            System.out.print("#"+i+" ");
            System.out.println(test());
        }

    }

    public static int test() throws IOException{
        st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int[] b = new int[m];


        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        if (n >= m) {
            return calculateMax(n, m, a, b);
        } else {
            return calculateMax(m, n, b, a);
        }
    }

    public static int calculateMax(int n, int m, int[] a, int[] b) {
        int max = Integer.MIN_VALUE;

        // 배열 길이가 같은 경우
        if (n == m) {
            max = 0;
            for (int i = 0; i < n; i++) {
                max += a[i] * b[i];
            }
            return max;
        }

        // 배열 길이가 다른 경우
        for (int i = 0; i <= n - m; i++) {
            int temp = 0;
            for (int j = 0; j < m; j++) {
                temp += a[i + j] * b[j];
            }
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }
}