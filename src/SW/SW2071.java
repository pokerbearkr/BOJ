package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//  평균값 구하기
public class SW2071 {
    static int N;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bf.readLine());

        for (int i = 1; i < N+1; i++) {
            System.out.print("#"+i+" ");
            System.out.println((int)test());
        }
    }

    private static double test() throws IOException{
        st = new StringTokenizer(bf.readLine());
        double sum=0;
        int[] arr = new int[10];
        for (int j = 0; j <10; j++) {
            arr[j] = Integer.parseInt(st.nextToken());
        }
        for (int j = 0; j < 10; j++) {
            sum += arr[j];
        }
        return Math.round(sum/10);

    }
}