package programmers;

public class pro133499 {
    public static void main(String[] args) {
        String[] babbling = {"aya", "yee", "u", "maa"};
        String[] word = {"aya", "ye", "woo", "ma"};
        int count = 0;

        for (String s : babbling) {
            int before = -1;  // 이전 발음한 단어를 초기화
            boolean isOK = true;

            for (int j = 0; j < s.length(); ) {
                if (j + 2 <= s.length() && s.substring(j, j + 2).equals(word[1]) && before != 2) {
                    before = 2;
                    j += 2;
                } else if (j + 2 <= s.length() && s.substring(j, j + 2).equals(word[3]) && before != 4) {
                    before = 4;
                    j += 2;
                } else if (j + 3 <= s.length() && s.substring(j, j + 3).equals(word[0]) && before != 1) {
                    before = 1;
                    j += 3;
                } else if (j + 3 <= s.length() && s.substring(j, j + 3).equals(word[2]) && before != 3) {
                    before = 3;
                    j += 3;
                } else {
                    isOK = false;
                    break;
                }
            }
            if (isOK) {
                count++;
            }
        }
        System.out.println(count);
    }
}
