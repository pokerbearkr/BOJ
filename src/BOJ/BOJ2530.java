package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2530 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        second += n;
        minute += second / 60;
        second %= 60;

        hour += minute / 60;
        minute %= 60;

        hour %= 24;

        System.out.println(hour + " " + minute + " " + second);
    }
}