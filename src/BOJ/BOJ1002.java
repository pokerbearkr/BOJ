package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1002 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            System.out.println(Turretproblem());
        }
    }

    private static int Turretproblem() throws IOException {
        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int r1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());

        double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

        if (x1 == x2 && y1 == y2) {
            if (r1 == r2) {
                return -1;
            } else {
                return 0;
            }
        }
        if (Math.abs(distance - (r1 + r2)) < 1e-9) {
            return 1;
        }

        if (Math.abs(distance - Math.abs(r1 - r2)) < 1e-9) {
            return 1;
        }
        if (distance < r1 + r2 && distance > Math.abs(r1 - r2)) {
            return 2;
        }

        return 0;
    }
}