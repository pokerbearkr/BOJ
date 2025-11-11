package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ5554 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum=0;
        sum+=Integer.parseInt(br.readLine());
        sum+=Integer.parseInt(br.readLine());
        sum+=Integer.parseInt(br.readLine());
        sum+=Integer.parseInt(br.readLine());

        System.out.println(sum/60);
        System.out.println(sum%60);
    }
}
