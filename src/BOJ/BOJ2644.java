package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2644 {
    private static int end;
    private static Map<Integer, List<Integer>> map;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.putIfAbsent(a, new ArrayList<>());
            map.putIfAbsent(b, new ArrayList<>());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        int result = dfs(start, 0);
        System.out.println(result == -1 ? -1 : result);
    }

    private static int dfs(int current, int count) {
        if (current == end) {
            return count;
        }

        visited[current] = true;

        if (map.containsKey(current)) {
            for (int next : map.get(current)) {
                if (!visited[next]) {
                    int result = dfs(next, count + 1);
                    if (result != -1) {
                        return result;
                    }
                }
            }
        }
        return -1;
    }
}