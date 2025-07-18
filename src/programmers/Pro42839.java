package programmers;

import java.util.HashSet;
import java.util.Set;

public class Pro42839 {
    public static void main(String[] args) {
        String numbers = "17";
        System.out.println(solution(numbers));
    }

    private static int solution(String numbers) {
        Set<Integer> primes = new HashSet<>();
        boolean[] used = new boolean[numbers.length()];

        backTracking("", numbers, used, primes);

        return primes.size();
    }

    private static void backTracking(String current, String numbers, boolean[] used, Set<Integer> primes) {
        if (!current.isEmpty()) {
            int num = Integer.parseInt(current);
            if (isSosu(num)) {
                primes.add(num);
            }
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                backTracking(current + numbers.charAt(i), numbers, used, primes);
                used[i] = false;
            }
        }
    }

    private static boolean isSosu(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
