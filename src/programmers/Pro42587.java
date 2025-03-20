package programmers;

import java.util.*;

public class Pro42587 {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        Queue<int[]> queue = new ArrayDeque<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});
            priorityQueue.add(priorities[i]);
        }

        int answer = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[1] == priorityQueue.peek()) {
                answer++;
                priorityQueue.poll();

                if (current[0] == location) {
                    return answer;
                }
            } else {
                queue.add(current);
            }
        }

        return answer;
    }
}
