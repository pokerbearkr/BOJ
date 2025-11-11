package programmers;

import java.util.*;

public class Pro132265 {
    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        System.out.println(solution(topping));
    }

    public static int solution(int[] topping) {
        int answer = 0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int t : topping) {
            list1.add(t);
            set1.add(t);
        }

        for (int i = 0; i < topping.length; i++) {
            int t = list1.remove(0);
            list2.add(t);
            set2.add(t);

            if (!list1.contains(t)) {
                set1.remove(t);
            }

            if (set1.size() == set2.size()) {
                answer++;
            }
        }

        return answer;
    }
}