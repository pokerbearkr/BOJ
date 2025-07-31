package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ18112 {
    private static boolean[] isVisitedStart = new boolean[2048];
    private static boolean[] isVisitedEnd = new boolean[2048];
    private static int[] countStart = new int[2048];
    private static int[] countEnd = new int[2048];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String startStr = br.readLine();
        String endStr = br.readLine();

        int start = Integer.parseInt(startStr, 2);
        int end = Integer.parseInt(endStr, 2);

        if (start == end) {
            System.out.println(0);
            return;
        }

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        q1.add(start);
        isVisitedStart[start] = true;
        countStart[start] = 0;

        q2.add(end);
        isVisitedEnd[end] = true;
        countEnd[end] = 0;

        while (!q1.isEmpty() && !q2.isEmpty()) {
            // q1 (start) 쪽 탐색
            int q1Size = q1.size();
            for (int i = 0; i < q1Size; i++) {
                int now = q1.poll();

                if (isVisitedEnd[now]) {
                    System.out.println(countStart[now] + countEnd[now]);
                    return;
                }

                // 1. +1, -1 연산
                int[] nexts = {now + 1, now - 1};
                for (int next : nexts) {
                    if (next >= 0 && next < 2048 && !isVisitedStart[next]) {
                        isVisitedStart[next] = true;
                        countStart[next] = countStart[now] + 1;
                        q1.add(next);
                    }
                }

                // 2. 비트 반전
                String nowBinary = Integer.toBinaryString(now);
                int nowLength = nowBinary.length();
                for (int j = 0; j < nowLength; j++) {
                    if (j == nowLength - 1) continue; // 맨 앞 비트 제외

                    int nextFlip = now ^ (1 << j);
                    if (nextFlip >= 0 && nextFlip < 2048 && !isVisitedStart[nextFlip]) {
                        isVisitedStart[nextFlip] = true;
                        countStart[nextFlip] = countStart[now] + 1;
                        q1.add(nextFlip);
                    }
                }
            }

            // q2 (end) 쪽 탐색
            int q2Size = q2.size();
            for (int i = 0; i < q2Size; i++) {
                int now = q2.poll();

                if (isVisitedStart[now]) {
                    System.out.println(countStart[now] + countEnd[now]);
                    return;
                }

                // 1. +1, -1 연산
                int[] nexts = {now + 1, now - 1};
                for (int next : nexts) {
                    if (next >= 0 && next < 2048 && !isVisitedEnd[next]) {
                        isVisitedEnd[next] = true;
                        countEnd[next] = countEnd[now] + 1;
                        q2.add(next);
                    }
                }

                // 2. 비트 반전
                String nowBinary = Integer.toBinaryString(now);
                int nowLength = nowBinary.length();
                for (int j = 0; j < nowLength; j++) {
                    if (j == nowLength - 1) continue; // 맨 앞 비트 제외

                    int nextFlip = now ^ (1 << j);
                    if (nextFlip >= 0 && nextFlip < 2048 && !isVisitedEnd[nextFlip]) {
                        isVisitedEnd[nextFlip] = true;
                        countEnd[nextFlip] = countEnd[now] + 1;
                        q2.add(nextFlip);
                    }
                }
            }
        }
    }
}