package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ28455 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if (N > 42) {
            Arrays.sort(arr);
            int[] t = Arrays.copyOfRange(arr, arr.length-42, arr.length);
            int[] ans = problem(t);
            System.out.println(ans[0] + " " + ans[1]);
        } else {
            int[] ans = problem(arr);
            System.out.println(ans[0] + " " + ans[1]);
        }


    }

    private static int[] problem(int[] arr) {
        int sum = 0;
        int sum1 = 0;
        for (int i = 0; i < arr.length; i++) {
            int target = arr[i];
            if (target >= 250) {
                sum += 5;
            } else if (target >= 200) {
                sum+=4;
            }else if (target >= 140) {
                sum+=3;
            }else if (target >= 100) {
                sum+=2;
            }else if (target >= 60) {
                sum+=1;
            }
            sum1 += target;
        }
        return new int[]{sum1, sum};
    }
}
