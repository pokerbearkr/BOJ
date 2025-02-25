package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9019 {
    static char[] next = {'D', 'S', 'L', 'R'};

    static class DSLR {
        int num;
        String way;

        public DSLR(int num, String way) {
            this.num = num;
            this.way = way;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            DSLR(start, end);
        }
    }

    private static void DSLR(int start, int end) {
        Queue<DSLR> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[10000];
        queue.add(new DSLR(start, ""));
        visited[start] = true;

        while (!queue.isEmpty()) {
            DSLR d = queue.poll();
            int now = d.num;
            String way = d.way;

            if (now == end) {
                System.out.println(way);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextNum = 0;
                char command = next[i];

                switch (command) {
                    case 'D':
                        nextNum = (now * 2) % 10000;
                        break;

                    case 'S':
                        nextNum = (now == 0) ? 9999 : now - 1;
                        break;

                    case 'L':
                        nextNum = (now % 1000) * 10 + (now / 1000);
                        break;

                    case 'R':
                        nextNum = (now / 10) + (now % 10) * 1000;
                        break;
                }

                if (!visited[nextNum]) {
                    visited[nextNum] = true;
                    queue.add(new DSLR(nextNum, way + command));
                }
            }
        }
    }
}