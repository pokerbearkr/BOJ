package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class pro138477 {
    public static void main(String[] args) throws Exception {
        int k=3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        List<Integer> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            list.add(score[i]);
            if (list.size() > k) {
                Collections.sort(list);
                list.remove(0);
            }
            ans.add(list.get(0));
        }
        int[] answer = ans.stream().mapToInt(i->i).toArray();
    }
}
