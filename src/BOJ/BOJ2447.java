package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2447 {
    static boolean[][] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(bf.readLine());
        ans = new boolean[N][N];
        recur(N,0,0);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(ans[i][j] ? "*" : " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
    private static void recur(int K,int x,int y){
        if(K==1){
            ans[x][y]=true;
            return;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(!(i==1&&j==1)){
                    recur(K/3,x+i*K/3,y+j*K/3);
                }
            }
        }
    }
}
