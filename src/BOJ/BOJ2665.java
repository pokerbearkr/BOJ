package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ2665 {
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static class Node implements Comparable<Node> {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost; // 더 적게 부순 순서대로
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = bf.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0));
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.x == n - 1 && cur.y == n - 1) {
                System.out.println(cur.cost);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (map[nx][ny] == 1) {
                        pq.add(new Node(nx, ny, cur.cost)); // 흰 방이면 cost 그대로
                    } else {
                        pq.add(new Node(nx, ny, cur.cost + 1)); // 검은 방이면 +1
                    }
                }
            }
        }
    }
}