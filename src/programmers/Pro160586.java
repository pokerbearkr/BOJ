package programmers;

import java.util.ArrayList;
import java.util.List;

public class Pro160586 {
    public static void main(String[] args) {
        String[] keymap = {"ABACD","BCEFD"};
        String[] targets = {"ABCD","AABB"};

        List<Integer> answer = new ArrayList<>();

        for(String s : targets) {
            int count=0;
            for (int i = 0; i < s.length(); i++) {
                char targetChar = s.charAt(i);

                int index = 101;

                for(String key : keymap) {
                    if (key.indexOf(targetChar) != -1 ) {
                        index = Math.min(index, key.indexOf(targetChar)+1);
                    }
                }
                if (index == 101) {
                    answer.add(-1);
                    break;
                }
                count+=index;
            }
            answer.add(count);
        }
        int[] answerArr = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            answerArr[i] = answer.get(i);
        }
        System.out.println(answerArr);
    }
}
