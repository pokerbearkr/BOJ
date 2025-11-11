package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ12851 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 방문 체크 배열
        boolean[] visited = new boolean[Math.max(100000, Math.max(N, K) * 2)+1];
        PriorityQueue<Subin> queue = new PriorityQueue<>(Comparator.comparingInt(a->a.time));

        queue.add(new Subin(N, 0));
        int minTime = Integer.MAX_VALUE;
        int count = 0;

        while (!queue.isEmpty()) {
            Subin current = queue.poll();
            int nowX = current.position;
            int time = current.time;


            if (nowX < 0 || nowX > 100000) continue;

            if (visited[nowX] && time > minTime) continue;
            visited[nowX] = true;

            if (nowX == K) {
                if (time < minTime) {
                    minTime = time;
                    count = 1;
                } else if (time == minTime) {
                    count++;
                }
                continue;
            }
            queue.add(new Subin(nowX * 2, time + 1));
            queue.add(new Subin(nowX - 1, time + 1));
            queue.add(new Subin(nowX + 1, time + 1));
        }

        System.out.println(minTime);
        System.out.println(count);
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