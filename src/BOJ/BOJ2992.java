package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ2992 {
    private static int n;
    private static int count;
    private static List<Integer> list = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        String str = String.valueOf(n);
        count = str.length();
        for (char c : str.toCharArray()) {
            list.add(c - '0');
        }

        Collections.sort(list);
        visited = new boolean[list.size()];

        System.out.println(dfs("", 0));
    }

    private static String dfs(String s, int length) {
        if (length == count) {
            int num = Integer.parseInt(s);
            if (num > n) {
                return s;
            }
            return "0";
        }

        for (int i = 0; i < list.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                String result = dfs(s + list.get(i), length + 1);
                if (!result.equals("0")) return result;
                visited[i] = false;
            }
        }

        return "0";
    }
}