package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 {
    static int blue=0;
    static int white=0;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        recur(N,0,0);
        System.out.println(white);
        System.out.println(blue);


    }

    private static void recur(int K,int x,int y){
        int base = arr[x][y];
        boolean isit=true;
        for (int i = x; i < x+K; i++) {
            for (int j = y; j <y+K ; j++) {
                if(arr[i][j]!=base){
                    isit=false;
                }
            }
        }
        if(isit){
            if(base==1){
                blue++;
            }else{
                white++;
            }
        }else{
            recur(K/2,x,y);
            recur(K/2,x+K/2,y);
            recur(K/2,x,y+K/2);
            recur(K/2,x+K/2,y+K/2);
        }
    }
}
