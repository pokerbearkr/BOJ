package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1948 {
    static BufferedReader bf;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int i = 1; i < T+1; i++) {
            System.out.print("#"+ i +" ");
            System.out.println(test());
        }


    }

    public static int test() throws IOException{
        int ans;
        st = new StringTokenizer(bf.readLine());
        int fm = Integer.parseInt(st.nextToken());
        int fd = Integer.parseInt(st.nextToken());
        int sm = Integer.parseInt(st.nextToken());
        int sd = Integer.parseInt(st.nextToken());
        return (MonthToDay(sm)+sd)-(MonthToDay(fm)+fd)+1;

    }

    public static int MonthToDay(int a) {
        if (a == 1) {
            return 0;
        } else if (a == 2) {
            return 31;
        } else if (a == 3) {
            return 59;
        } else if (a == 4) {
            return 90;
        } else if (a == 5) {
            return 120;
        } else if (a == 6) {
            return 151;
        } else if (a == 7) {
            return 181;
        } else if (a == 8) {
            return 212;
        } else if (a == 9) {
            return 243;
        } else if (a == 10) {
            return 273;
        } else if (a == 11) {
            return 304;
        } else if (a == 12) {
            return 334;
        }
        return 0;
    }

}
