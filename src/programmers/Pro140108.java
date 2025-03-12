package programmers;

public class Pro140108 {
    public static void main(String[] args) {
        String s = "aaabbaccccabba";

        int count = 0;
        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);
            int targetCount = 1;
            int elseCount = 0;

            int j = i + 1;
            while (j < s.length()) {
                if (c == s.charAt(j)) {
                    targetCount++;
                } else {
                    elseCount++;
                }
                if (targetCount == elseCount) {
                    break;
                }
                j++;
            }
            count++;
            i = j + 1;
        }
        System.out.println(count);
    }
}