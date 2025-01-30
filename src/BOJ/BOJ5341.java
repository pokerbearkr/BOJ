package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ5341 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            int A = Integer.parseInt(br.readLine());
            if(A == 0) break;
            System.out.println(A*(A+1)/2);
        }
    }
}
