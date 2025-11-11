package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ13270 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int studentCount = Integer.parseInt(br.readLine());

        int min = 0;
        min += studentCount / 2;
        if (studentCount % 2 == 1) {
            min++;
        }
        sb.append(min).append(" ");

        int max = 0;
        max += (studentCount / 3) * 2;
        if (studentCount % 3 == 2) {
            max++;
        }

        sb.append(max);
        System.out.println(sb);
    }
}
