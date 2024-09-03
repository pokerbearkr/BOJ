package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for(int i=0;i<=N;i++){
            String C[] = bf.readLine().split(" ");
            double tem = Math.pow(Integer.parseInt(C[0])%10,Integer.parseInt(C[1])%4);
            int tem1 = (int)tem;
            System.out.println(tem1%10);

        }
    }
}
