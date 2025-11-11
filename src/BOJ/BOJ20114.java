package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ20114 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        char[] combinedChars = new char[n * w];
        Arrays.fill(combinedChars, '?');

        for (int i = 0; i < h; i++) {
            String line = br.readLine();
            for (int j = 0; j < n * w; j++) {
                if (line.charAt(j) != '?') {
                    combinedChars[j] = line.charAt(j);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char resultChar = '?';
            for (int j = 0; j < w; j++) {
                char currentChar = combinedChars[i * w + j];
                if (currentChar != '?') {
                    resultChar = currentChar;
                    break;
                }
            }
            ans.append(resultChar);
        }

        System.out.println(ans);
    }
}