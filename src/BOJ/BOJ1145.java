package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1145 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 1;
        while(true) {
            int count=0;
            for (int i = 0; i < 5; i++) {
                if (start % arr[i] == 0) {
                    count++;
                }
            }
            if (count >= 3) {
                System.out.println(start);
                return;
            }
            start++;
        }
    }
}
