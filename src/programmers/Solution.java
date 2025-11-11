package programmers;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean capitalize = true;

        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                answer.append(ch);
                capitalize = true;
            } else {
                if (capitalize) {
                    answer.append(Character.toUpperCase(ch));
                } else {
                    answer.append(Character.toLowerCase(ch));
                }
                capitalize = false;
            }
        }
        return answer.toString();
    }
}