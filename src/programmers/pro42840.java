package programmers;

import java.util.Arrays;

public class pro42840 {
    public static void main(String[] args) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] answer = {1, 3, 2, 4, 2};
        int[] answerCount = new int[]{0,0,0};
        for (int i = 0; i < answer.length; i++) {
            if(answer[i] == one[i%5]) {
                answerCount[0]++;
            }
            if(answer[i] == two[i%8]) {
                answerCount[1]++;
            }
            if(answer[i] == three[i%10]) {
                answerCount[2]++;
            }
        }
        if(answerCount[0]>answerCount[1]&&answerCount[0]>answerCount[2]) {
        }


    }
}
