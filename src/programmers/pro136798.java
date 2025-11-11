package programmers;

public class pro136798 {
    public static void main(String[] args) {
        int number = 10;
        int limit = 3;
        int power = 2;
        int sum = 0;

        for (int i = 1; i <= number; i++) {
            sum += yakSu(i, limit, power);
        }
        System.out.println(sum);
    }

    private static int yakSu(int n, int limit, int power) {
        int count = 0;
        int sqrt = (int) Math.sqrt(n);

        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                count++;
                if (i != n / i) count++;
            }
        }

        return count > limit ? power : count;
    }
}