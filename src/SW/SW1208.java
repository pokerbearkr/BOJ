package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//S/W 문제해결 Flatten
public class SW1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i < 11; i++) {
            int dump = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            int[] box = new int[100];
            for (int j = 0; j < 100; j++) {
                box[j] = Integer.parseInt(st.nextToken());
            }
            System.out.print("#" + i + " ");
            System.out.println(test(dump, box));

        }

    }

    public static int test(int dump, int[] box) {
        for (int i = 0; i < dump; i++) {
            Arrays.sort(box);
            if (box[99] - box[0] <= 1) {
                break;
            }
            box[99] -= 1;
            box[0] += 1;
        }
        Arrays.sort(box);
        return box[99] - box[0];

    }

}
