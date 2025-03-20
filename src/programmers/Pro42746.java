package programmers;

import java.util.Arrays;

public class Pro42746 {
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};

        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        String[] numToStr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numToStr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numToStr, (a, b) -> (b + a).compareTo(a + b));

        if (numToStr[0].equals("0")) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();
        for (String num : numToStr) {
            answer.append(num);
        }

        return answer.toString();
    }
}
