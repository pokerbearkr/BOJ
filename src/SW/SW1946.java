package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1946 {
    static BufferedReader bf;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int i = 1; i < T + 1; i++) {
            System.out.println("#" + i);
            test();
        }
    }

    public static void test() throws IOException {
        int N = Integer.parseInt(bf.readLine());
        int count = 10;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String Ci = st.nextToken();
            int Ki = Integer.parseInt(st.nextToken());
            while (Ki > 0) {
                if (count == 0) {
                    System.out.println(" ");
                    count = 10;
                }
                System.out.print(Ci);
                Ki--;
                count--;
            }
        }
        System.out.println(" ");
    }
}
