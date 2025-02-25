package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1439 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char[] arr = str.toCharArray();
        int length = arr.length;

        int left = 0;
        int right = length - 1;
        int zeroToOne = 0;
        int oneToZero = 0;

        while (left < length - 1) {
            if (arr[left] != arr[left + 1]) {
                if (arr[left] == '0') zeroToOne++;
                else oneToZero++;
            }
            left++;
        }

        if (arr[length - 1] == '0') zeroToOne++;
        else oneToZero++;

        System.out.println(Math.min(zeroToOne, oneToZero));
    }
}