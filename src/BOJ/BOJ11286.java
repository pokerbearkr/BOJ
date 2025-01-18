package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ11286 {
    static class arr {
        int num;
        boolean isPlus;

        public arr(int num, boolean isPlus) {
            this.num = num;
            this.isPlus = isPlus;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<arr> pq = new PriorityQueue<>(new Comparator<arr>() {
            @Override
            public int compare(arr o1, arr o2) {
                if (o1.num != o2.num) {
                    return Integer.compare(o1.num, o2.num);
                }
                return Boolean.compare(o1.isPlus, o2.isPlus);
            }
        });

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());
            if (now == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    arr curr = pq.poll();
                    if (curr.isPlus) {
                        sb.append(curr.num).append("\n");
                    } else {
                        sb.append(curr.num * -1).append("\n");
                    }
                }
            } else {
                if (now > 0) {
                    pq.offer(new arr(Math.abs(now), true));
                } else {
                    pq.offer(new arr(Math.abs(now), false));
                }
            }
        }
        System.out.println(sb);
    }
}
