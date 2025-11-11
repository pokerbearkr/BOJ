package BOJ;
import java.util.*;

public class BOJ18232 {
    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();

        int Start = read();
        int End = read();

        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int x = read();
            int y = read();
            graph[x].add(y);
            graph[y].add(x);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];

        queue.add(new int[]{Start, 0});
        visited[Start] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowTime = now[1];

            if (nowX == End) {
                System.out.println(nowTime);
                return;
            }

            for (int next : graph[nowX]) {
                if (!visited[next]) {
                    queue.add(new int[]{next, nowTime + 1});
                    visited[next] = true;
                }
            }

            if (nowX + 1 <= N && !visited[nowX + 1]) {
                queue.add(new int[]{nowX + 1, nowTime + 1});
                visited[nowX + 1] = true;
            }

            if (nowX - 1 > 0 && !visited[nowX - 1]) {
                queue.add(new int[]{nowX - 1, nowTime + 1});
                visited[nowX - 1] = true;
            }
        }
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}