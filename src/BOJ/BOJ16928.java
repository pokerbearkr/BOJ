package BOJ;

import java.util.*;

public class BOJ16928 {
    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();

        HashMap<Integer, Integer> LS = new HashMap<>();
        for (int i = 0; i < n + m; i++) {

            LS.put(read(),read());
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];
        queue.add(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int position = now[0];
            int moves = now[1];

            if (position == 100) {
                System.out.println(moves);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = position + i;

                if (next > 100 || visited[next]) continue;
                visited[next] = true;

                if (LS.containsKey(next)) {
                    next = LS.get(next);
                }
                queue.add(new int[]{next, moves + 1});
            }
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}