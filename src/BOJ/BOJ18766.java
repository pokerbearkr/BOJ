package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ18766 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            problem();
        }

    }
    private static void problem() throws Exception {
        int n = Integer.parseInt(br.readLine());
        HashMap<String,Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = st.nextToken();
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = st.nextToken();
            if (map.containsKey(s)) {
                if (map.get(s) == 0) {
                    System.out.println("CHEATER");
                    return;
                } else {
                    map.put(s, map.get(s) - 1);
                }

            } else {
                System.out.println("CHEATER");
                return;
            }
        }
        System.out.println("NOT CHEATER");
    }

}
