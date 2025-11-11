package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13118 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] people = new int[4];

        for (int i = 0; i < 4; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        int target = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 4; i++) {
            if (people[i] == target) {
                System.out.println(i+1);
                return;
            }
        }
        System.out.println(0);

    }
}
