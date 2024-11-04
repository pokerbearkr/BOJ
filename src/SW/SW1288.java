package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1288 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int i = 1; i < T+1; i++) {
            int N = Integer.parseInt(bf.readLine());
            System.out.print("#"+i+" ");
            System.out.println(Test(N));
        }

    }

    public static int Test(int N) {
        boolean[] arr = new boolean[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = false;
        }
        int i = 0;
        while(true){
            if (allDigitsSeen(arr)) {
                return i*N;
            } else {
                i++;
            }
            int targetNum = i*N;
            while (targetNum > 0) {
                arr[targetNum%10]=true;
                targetNum=targetNum/10;
            }

        }
    }
    public static boolean allDigitsSeen(boolean[] arr) {
        for (boolean seen : arr) {
            if (!seen) {
                return false;
            }
        }
        return true;
    }
}
