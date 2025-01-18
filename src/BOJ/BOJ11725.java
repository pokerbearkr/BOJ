package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11725 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<>()); // 초기화
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        int[] parents = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        findParents(map, parents, visited, N);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void findParents(TreeMap<Integer, List<Integer>> map, int[] parents, boolean[] visited, int N) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int near : map.get(cur)) {
                if (!visited[near]) {
                    parents[near] = cur;
                    visited[near] = true;
                    queue.offer(near);
                }
            }
        }
    }
}