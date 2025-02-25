package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ28126 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int countU = 0;
        int countX = 0;
        int countR = 0;
        String str = br.readLine();
        for (int i = 0; i < N; i++) {
            char c = str.charAt(i);
            if(c == 'U') countU++;
            else if(c == 'X') countX++;
            else if(c == 'R') countR++;
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());




        }




    }
}
