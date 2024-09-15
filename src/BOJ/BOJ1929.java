package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[B + 1];
        for (int i = 2; i <= B; i++) {
            arr[i] = true;
        }
        for (int i = 2; i * i <= B; i++) {
            if (arr[i]) {
                for (int j = i * i; j <= B; j += i) {
                    arr[j] = false;
                }
            }
        }
        for (int i = A; i <= B; i++) {
            if (arr[i]) {
                System.out.println(i);
            }
        }

    }
}
