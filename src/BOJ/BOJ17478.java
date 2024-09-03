package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17478 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        jae(N);
    }
    private static void jae(int i){
        System.out.println("1111");
        if(i==1) {
            return;
        }

        jae(i-1);

        System.out.println("222");
    }

}
