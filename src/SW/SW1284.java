package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1284 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(bf.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            int ansA = p*w;
            System.out.print("#"+i+" ");
            System.out.println(Math.min(ansA,ansB(q,r,s,w)));
        }
    }
    public static int ansB(int q, int r, int s,int w) {
        if (w <= r) {
            return q;
        } else {
            return q+s*(w-r);
        }
    }
}
