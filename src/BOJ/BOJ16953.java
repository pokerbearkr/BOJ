package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16953 {
    static long start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        System.out.println(bfs(start));
    }

    private static long bfs(long start) {
        Queue<Long> queue = new LinkedList<>();
        Queue<Long> steps = new LinkedList<>();
        queue.add(start);
        steps.add(1L);

        while (!queue.isEmpty()) {
            long current = queue.poll();
            long step = steps.poll();

            if (current == end) {
                return step;
            }

            if (current * 2 <= end) {
                queue.add(current * 2);
                steps.add(step + 1);
            }
            if (current * 10 + 1 <= end) {
                queue.add(current * 10 + 1);
                steps.add(step + 1);
            }
        }
        return -1;
    }
}