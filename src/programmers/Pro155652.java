package programmers;

public class Pro155652 {
    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            int count = 0;
            while (count < index) {
                c = (char) ((c - 'a' + 1) % 26 + 'a');
                if (skip.indexOf(c) == -1) {
                    count++;
                }
            }
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}