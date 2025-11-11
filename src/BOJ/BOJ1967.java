package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1967 {
    static Map<Integer, List<int[]>> tree = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            tree.put(i, new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            tree.get(a).add(new int[]{b, c});
            tree.get(b).add(new int[]{a, c});
        }

        int[] farthest = bfs(1, N);
        int[] result = bfs(farthest[0], N);
        System.out.println(result[1]);
    }

    private static int[] bfs(int start, int N) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        queue.add(new int[]{start, 0});
        visited[start] = true;

        int farthestNode = start;
        int maxDist = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int now = curr[0], dist = curr[1];

            for (int[] next : tree.get(now)) {
                int nextNode = next[0], weight = next[1];
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(new int[]{nextNode, dist + weight});
                    if (dist + weight > maxDist) {
                        maxDist = dist + weight;
                        farthestNode = nextNode;
                    }
                }
            }
        }
        return new int[]{farthestNode, maxDist};
    }
}