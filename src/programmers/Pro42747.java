package programmers;

public class Pro42747 {
    public static void main(String[] args) {
        int[] citations = {3,0,1,6,5};

        int answer = 0;

        for (int i = 1; i <= citations.length; i++) {

            int count = 0;

            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= i) {
                    count++;
                }
            }
            if (answer <= count) {
                answer += count;
            } else {
                return;
            }
        }
    }
}
