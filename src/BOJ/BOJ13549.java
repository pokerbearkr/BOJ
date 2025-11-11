package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ13549 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[200000];

        PriorityQueue<Subin> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
        queue.add(new Subin(N, 0));

        while (!queue.isEmpty()) {
            Subin current = queue.poll();
            int nowX = current.position;
            int time = current.time;

            if (nowX < 0 || nowX > 100000 || visited[nowX]) {
                continue;
            }

            visited[nowX] = true;

            if (nowX == K) {
                System.out.println(time);
                return;
            }
            queue.add(new Subin(nowX * 2, time));
            queue.add(new Subin(nowX - 1, time + 1));
            queue.add(new Subin(nowX + 1, time + 1));
        }
    }
    static class Subin {
        int position;
        int time;

        public Subin(int position, int time) {
            this.position = position;
            this.time = time;
        }
    }
}