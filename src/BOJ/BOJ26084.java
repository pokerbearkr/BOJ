package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ26084 {
    public static void main(String[] args) throws IOException {
        String[] teamName = new String[3];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "");
        for (int i = 0; i < 3; i++) {
            teamName[i] = st.nextToken();
        }

        int N = Integer.parseInt(br.readLine());

        String[] Name = new String[N];

        for (int i = 0; i < N; i++) {
            Name[i] = br.readLine();
        }


    }
}
