package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SW1285 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());

        for (int i = 1; i < N+1; i++) {
            int people = Integer.parseInt(bf.readLine());
            HashMap<Integer,Integer> arr = new HashMap<>();
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < people; j++) {
                int a = Integer.parseInt(st.nextToken());
                arr.put(Math.abs(a), arr.getOrDefault(Math.abs(a), 0) + 1);
            }
            int minValue = Collections.min(arr.keySet());

            System.out.print("#"+i+" ");
            System.out.println(minValue+" "+arr.get(minValue));

        }

    }
}
