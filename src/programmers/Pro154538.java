package programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class Pro154538 {
    public static void main(String[] args) {
        System.out.println(solution(10, 40, 5));
    }

    public static int solution(int x, int y, int n) {
        if (x == y) return 0;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[y + 1];
        queue.add(new int[]{x, 0});
        visited[x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int nowX = cur[0];
            int count = cur[1];

            if (nowX == y) {
                return count;
            }

            int[] nextValues = {nowX + n, nowX * 2, nowX * 3};

            for (int next : nextValues) {
                if (next <= y && !visited[next]) {
                    queue.add(new int[]{next, count + 1});
                    visited[next] = true;
                }
            }
        }
        return -1;
    }
}
