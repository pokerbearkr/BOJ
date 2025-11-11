package programmers;
import java.util.*;

public class Pro42586 {

    public class Solution {
        public static List<Integer> solution(int[] progresses, int[] speeds) {
            List<Integer> answer = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < progresses.length; i++) {
                int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
                queue.offer(days);
            }

            while (!queue.isEmpty()) {
                int cnt = 1;
                int first = queue.poll();

                while (!queue.isEmpty() && queue.peek() <= first) {
                    queue.poll();
                    cnt++;
                }
                answer.add(cnt);
            }
            int[] ans = answer.stream().mapToInt(A->A).toArray();

            return answer;
        }

        public static void main(String[] args) {
            int[] progresses = {93, 30, 55};
            int[] speeds = {1, 30, 5};
            System.out.println(solution(progresses, speeds)); // 출력: [2, 1]
        }
    }

}
