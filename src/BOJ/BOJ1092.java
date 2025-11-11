package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1092 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] crane = new int[n];
        for(int i=0; i<n; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(crane);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] box = new int[M];
        for(int i=0; i<M; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(box);

        if(crane[n-1]<box[n-1]) {
            System.out.println(-1);
            return;
        }



    }
}
