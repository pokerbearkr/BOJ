package BOJ;

public class BOJ6064 {
    public static void main(String[] args) throws Exception {
        int T = read();
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int M = read();
            int N = read();
            int x = read();
            int y = read();
            sb.append(findYear(M, N, x, y)).append("\n");
        }
        System.out.print(sb);
    }

    private static int findYear(int M, int N, int x, int y) {
        int lcm = lcm(M, N);

        for (int currentX = x; currentX <= lcm; currentX += M) {
            if ((currentX - 1) % N + 1 == y) {
                return currentX;
            }
        }

        return -1;
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);

    }private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }


}