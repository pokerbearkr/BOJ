package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ2217 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(br.readLine());

         Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int count=1;
        int maxWeight=arr[0];

        for (int weight : arr) {
            if (maxWeight > weight * count) {
                break;
            }
            maxWeight = Math.max(maxWeight, weight*count);
            count++;
        }

        System.out.println(maxWeight);

    }
}
