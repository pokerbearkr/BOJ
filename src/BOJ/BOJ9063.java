package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ9063 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(0);
            return;
        }
        Set<Integer> xSet = new HashSet<>();
        Set<Integer> ySet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xSet.add(Integer.parseInt(st.nextToken()));
            ySet.add(Integer.parseInt(st.nextToken()));
        }

        if (xSet.size() == 1 || ySet.size() == 1) {
            System.out.println(0);
            return;
        }

        int minX, minY, maxX, maxY;

        minX = xSet.stream().min(Integer::compareTo).get();
        minY = ySet.stream().min(Integer::compareTo).get();
        maxX = xSet.stream().max(Integer::compareTo).get();
        maxY = ySet.stream().max(Integer::compareTo).get();

        int square = (maxX - minX) * (maxY - minY);
        System.out.println(square);

    }
}
