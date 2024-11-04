package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15654 {
    static int N,M;
    static int[] arr;
    static int[] useList;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        useList = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            useList[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(useList);
        dfs(1,0);
        System.out.println(sb);



    }
    private static void dfs(int start, int depth){
        if(depth==M){
            for(int val : useList){
                sb.append(val).append(" ");
            }
            sb.append('\n');
            return;

        }
        for (int i = start; i <= N; i++) {
            arr[depth]=useList[i];
            dfs(i,depth+1);
        }


    }
}
