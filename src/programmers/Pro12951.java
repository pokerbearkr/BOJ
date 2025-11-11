package programmers;

public class Pro12951 {
    public static void main(String[] args) {
        String s = "3people unFollowed me";
        System.out.println(solution(s));
    }

    public static String solution(String s) {
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
