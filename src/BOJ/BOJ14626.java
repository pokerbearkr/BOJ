package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ14626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String isbn = br.readLine();

        int sum = 0;
        int starIndex = -1;
        int starWeight = 0;

        for (int i = 0; i < 13; i++) {
            char target = isbn.charAt(i);
            int weight = (i % 2 == 0) ? 1 : 3;

            if (target == '*') {
                starIndex = i;
                starWeight = weight;
            } else {
                int digit = Character.getNumericValue(target);
                sum += digit * weight;
            }
        }
        int remainder = (10 - (sum % 10)) % 10;
        int ans = -1;

        for (int x = 0; x <= 9; x++) {
            if ((x * starWeight) % 10 == remainder) {
                ans = x;
                break;
            }
        }

        System.out.println(ans);
    }
}