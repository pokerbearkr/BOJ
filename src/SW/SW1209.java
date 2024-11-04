package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1209 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(bf.readLine());
            int max = 0;

            // 배열 만들고 집어넣기
            int[][] arr = new int[100][100];
            for (int j = 0; j < 100; j++) {
                st = new StringTokenizer(bf.readLine());
                for (int k = 0; k < 100; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // 가로,세로 확인
            for (int j = 0; j < 100; j++) {
                int temsum=0;
                int temsum1=0;
                for (int k = 0; k < 100; k++) {
                    temsum += arr[j][k];
                    temsum1 += arr[k][j];
                }
                if (temsum > max) {
                    max=temsum;
                }
                if (temsum1 > max) {
                    max=temsum1;
                }
            }
            int temsum=0;
            // 대각선 확인
            for (int j = 0; j < 100; j++) {

                temsum += arr[j][j];
            }
            if (temsum > max) {
                max=temsum;
            }

            //반대 대각선확인
            temsum=0;
            for (int j = 0; j <100 ; j++) {
                temsum+=arr[99-j][j];

            }
            if (temsum > max) {
                max=temsum;
            }

            System.out.print("#"+num+" ");
            System.out.println(max);
        }

    }
}
