package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11060 {
    private static int N;
    private static int[] arr;
    private static Queue<int[]> queue = new ArrayDeque<>();
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        queue.add(new int[]{0,0});
        visited[0] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int now = current[0];
            int count = current[1];

            if (now == N - 1) {
                System.out.println(count);
                return;
            }

            for (int i = 1; i <= arr[now]; i++) {
                int nextPos = now + i;

                if (nextPos < N && !visited[nextPos]) {
                    visited[nextPos] = true;
                    queue.add(new int[]{nextPos, count + 1});
                }
            }
        }
        System.out.println(-1);
    }
}