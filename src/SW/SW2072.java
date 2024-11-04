package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//  홀수만 더하기
public class SW2072 {
    static int N;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {;
        N = Integer.parseInt(bf.readLine());

        for (int i = 1; i < N+1; i++) {
            System.out.print("#"+i+" ");
            System.out.println(test(i));
        }
    }

    private static int test(int i) throws IOException{
        st = new StringTokenizer(bf.readLine());
        int sum=0;
        int[] arr = new int[10];
        for (int j = 0; j <10; j++) {
            arr[j] = Integer.parseInt(st.nextToken());
        }
        for (int j = 0; j < 10; j++) {
            if (arr[j] % 2 != 0) {
                sum += arr[j];
            }
        }
        return sum;

    }
}
