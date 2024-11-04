package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ1697 {
    static int N, K;
    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N));
    }

    private static int bfs(int start) {
        Deque<Integer> bfsQueue = new ArrayDeque<>();
        boolean[] visited = new boolean[MAX + 1];
        int[] time = new int[MAX + 1];

        bfsQueue.add(start);
        visited[start] = true;

        while (!bfsQueue.isEmpty()) {
            int current = bfsQueue.poll();

            if (current == K) {
                return time[current];
            }

            if (current - 1 >= 0 && !visited[current - 1]) {
                bfsQueue.add(current - 1);
                visited[current - 1] = true;
                time[current - 1] = time[current] + 1;
            }
            if (current + 1 <= MAX && !visited[current + 1]) {
                bfsQueue.add(current + 1);
                visited[current + 1] = true;
                time[current + 1] = time[current] + 1;
            }
            if (current * 2 <= MAX && !visited[current * 2]) {
                bfsQueue.add(current * 2);
                visited[current * 2] = true;
                time[current * 2] = time[current] + 1;
            }
        }

        return -1;
    }
}