package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3061 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(bf.readLine());
            System.out.println(problem(k));
        }
    }

    public static int problem(int k) throws IOException{
        int[] arr = new int[k];
        int count=0;
        int tem;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < k-1; i++) {
            for (int j = 0; j < k-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    count++;
                    tem = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1]=tem;
                }
            }
        }

        return count;
    }
}
