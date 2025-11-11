package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ1342 {
    private static String s;
    private static char[] chars;
    private static boolean[] visited;
    private static Set<String> unique;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        chars = s.toCharArray();
        visited = new boolean[s.length()];
        unique = new HashSet<>();

        dfs("", 0);
        System.out.println(unique.size());
    }

    private static void dfs(String cur, int depth) {
        if (depth == s.length()) {
            if (isLuckyString(cur)) {
                unique.add(cur);
            }
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(cur + chars[i], depth + 1);
                visited[i] = false;
            }
        }
    }

    private static boolean isLuckyString(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}