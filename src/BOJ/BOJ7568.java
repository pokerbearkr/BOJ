package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr =new int[N];
        int[] arr2 =new int[N];
        StringTokenizer st ;

        for (int i = 0; i < N; i++) {
            st= new StringTokenizer(bf.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
            arr2[i]=Integer.parseInt(st.nextToken());
        }
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            ans[i]=1;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i]<arr[j]&&arr2[i]<arr2[j]){
                    ans[i]+=1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(ans[i]+" ");
        }
    }
}
