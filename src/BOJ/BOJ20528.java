package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20528 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = st.nextToken();
        }
        char start = arr[0].charAt(0);
        for (int i = 1; i < n; i++) {
            if(arr[i].charAt(0) != start) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);

    }
}
