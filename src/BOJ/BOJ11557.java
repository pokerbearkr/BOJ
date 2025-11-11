package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ11557 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            System.out.println(problem());
        }
    }

    private static String problem() throws IOException {
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        int maxVal = 0;
        String result = "";

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxVal) {
                maxVal = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }
}