package programmers;

public class Pro70129 {
    public static void main(String[] args) {
        String s = "110010101001";

        int zeroCount = 0; // 제거된 0의 개수
        int count = 0;

        while (!s.equals("1")) {
            int ones = 0;

            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zeroCount++;
                } else {
                    ones++;
                }
            }

            s = Integer.toBinaryString(ones);
            count++;
        }


    }
}
