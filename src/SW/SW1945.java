package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//간단한 소인수 분해
public class SW1945 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int i = 1; i < T + 1; i++) {
            int N = Integer.parseInt(bf.readLine());
            int a=0,b=0,c=0,d=0,e=0;
            while (N % 2 == 0) {
                a+=1;
                N/=2;
            }
            while (N % 3 == 0) {
                b+=1;
                N/=3;
            }
            while (N % 5 == 0) {
                c+=1;
                N/=5;
            }
            while (N % 7 == 0) {
                d+=1;
                N/=7;
            }
            while (N % 11 == 0) {
                e+=1;
                N/=11;
            }

            System.out.print("#"+i+" ");
            System.out.println(a+" "+b+" "+c+" "+d+" "+e);
        }




    }
}
