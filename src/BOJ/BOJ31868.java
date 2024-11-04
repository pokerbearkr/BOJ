package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ31868 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int target = (int)Math.pow(2,N-1);
        if(target>K){
            System.out.println("0");
            return;
        }
        int ans=0;
        while(target<=K){
            ans++;
            K-=target;
        }
        System.out.println(ans);

    }
}
