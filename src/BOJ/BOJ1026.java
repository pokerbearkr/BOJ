package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        LinkedList<Integer> Alist = new LinkedList<>();
        LinkedList<Integer> Blist = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            Alist.add(Integer.parseInt(st.nextToken()));
        }
        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            Blist.add(Integer.parseInt(st1.nextToken()));
        }
        Alist.sort(null);
        Blist.sort(Collections.reverseOrder());

        int sum = 0;
        for (int j = 0; j < N; j++) {
            sum += Alist.get(j) * Blist.get(j);
        }
        System.out.println(sum);
    }
}