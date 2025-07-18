package programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class Pro43165 {
    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        int answer = 0;

        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{numbers[0], 1});
        queue.add(new int[]{-numbers[0], 1});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curSum = cur[0];
            int index = cur[1];

            if (index == numbers.length) {
                if (curSum == target) {
                    answer++;
                }
                continue;
            }

            queue.add(new int[]{curSum + numbers[index], index + 1});
            queue.add(new int[]{curSum - numbers[index], index + 1});
        }

        System.out.println(answer);
    }
}
