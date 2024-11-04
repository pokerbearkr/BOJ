package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] a = new int[2];
        a[0] = Integer.parseInt(st.nextToken());
        a[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int[] b = new int[2];
        b[0] = Integer.parseInt(st.nextToken());
        b[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int[] c = new int[2];
        c[0] = Integer.parseInt(st.nextToken());
        c[1] = Integer.parseInt(st.nextToken());

        int ans1, ans2;

        if (a[0] == b[0]) {
            ans1=c[0];
        } else if (a[0] == c[0]) {
            ans1 = b[0];
        } else {
            ans1=a[0];
        }
        if (a[1] == b[1]) {
            ans2=c[1];
        } else if (a[1] == c[1]) {
            ans2 = b[1];
        } else {
            ans2=a[1];
        }

        System.out.println(ans1+" "+ans2);

    }
}
