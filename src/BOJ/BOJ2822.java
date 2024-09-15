package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2822 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num[] = new int[8];
        for (int i = 0; i < 8; i++) {
            num[i] = Integer.parseInt(bf.readLine());
        }
        int[] ranks = new int[8];

        for (int i = 0; i < 8; i++) {
            int rank = 1;
            for (int j = 0; j < 8; j++) {
                if (num[i] < num[j]) {
                    rank++;
                }
            }
            ranks[i] = rank;
        }
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            if (ranks[i] <= 5) {

                sum += num[i];
            }
        }
        System.out.println(sum);

        for (int i = 0; i < 8; i++) {
            if (ranks[i] <= 5) {
                System.out.print(i + 1 + " ");
            }

        }

    }
}
