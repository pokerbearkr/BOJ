package BOJ;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ5567 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            map.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        int[] depth = new int[n + 1];

        queue.add(1);
        visited[1] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> list = map.get(cur);

            if (list == null) continue;

            for (int next : list) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    depth[next] = depth[cur] + 1;

                    if (depth[next] <= 2) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}