package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ32626 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long startX = Long.parseLong(st.nextToken());
        long startY = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long endX = Long.parseLong(st.nextToken());
        long endY = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long blockX = Long.parseLong(st.nextToken());
        long blockY = Long.parseLong(st.nextToken());

        if (startX == endX) {
            if (startX == blockX && ((startY < blockY && blockY < endY) || (endY < blockY && blockY < startY))) {
                System.out.println(2);
            } else {
                System.out.println(0);
            }
            return;
        }

        if (startY == endY) {
            if (startY == blockY && ((startX < blockX && blockX < endX) || (endX < blockX && blockX < startX))) {
                System.out.println(2);
            } else {
                System.out.println(0);
            }
            return;
        }

        boolean path1Blocked = false;
        if (startX == blockX && ((startY < blockY && blockY < endY) || (endY < blockY && blockY < startY))) {
            path1Blocked = true;
        }
        if (endY == blockY && ((startX < blockX && blockX < endX) || (endX < blockX && blockX < startX))) {
            path1Blocked = true;
        }

        boolean path2Blocked = false;
        if (startY == blockY && ((startX < blockX && blockX < endX) || (endX < blockX && blockX < startX))) {
            path2Blocked = true;
        }
        if (endX == blockX && ((startY < blockY && blockY < endY) || (endY < blockY && blockY < startY))) {
            path2Blocked = true;
        }

        if (path1Blocked && path2Blocked) {
            System.out.println(2);
        } else {
            System.out.println(1);
        }
    }
}