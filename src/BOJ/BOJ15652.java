package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15652 {
    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        dfs(1,0);
        System.out.println(sb);



    }
    private static void dfs(int start, int depth){
        if(depth==M){
            for(int val : arr){
                sb.append(val).append(" ");
            }
            sb.append('\n');
            return;

        }
        for (int i = start; i <= N; i++) {
            arr[depth]=i;
            dfs(i,depth+1);
        }


    }
}
