package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1032 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        boolean[] isDifferent = new boolean[arr[0].length()];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[0].length(); j++) {
                if (arr[0].charAt(j) != arr[i].charAt(j)) {
                    isDifferent[j] = true;
                }
            }
        }

        for (int i = 0; i < arr[0].length(); i++) {
            if (isDifferent[i]) {
                System.out.print('?');
            } else {
                System.out.print(arr[0].charAt(i));
            }
        }
    }
}