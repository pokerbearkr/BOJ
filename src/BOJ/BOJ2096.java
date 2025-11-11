package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//public class BOJ2096 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        int[][] arr = new int[N][3];
//
//        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            arr[i][0] = Integer.parseInt(st.nextToken());
//            arr[i][1] = Integer.parseInt(st.nextToken());
//            arr[i][2] = Integer.parseInt(st.nextToken());
//
//        }
//
//        int[][] arr2 = new int[N][3];
//
//        for (int i = 0; i < N; i++) {
//            System.arraycopy(arr[i], 0, arr2[i], 0, 3);
//        }
//
//        for (int i = 1; i < N; i++) {
//            arr[i][0]=Math.max(arr[i-1][0]+arr[i][0], arr[i-1][1]+arr[i][0]);
//            arr[i][1]=Math.max(arr[i-1][0]+arr[i][1], Math.max(arr[i-1][1]+arr[i][1],arr[i-1][2]+arr[i][1]));
//            arr[i][2]=Math.max(arr[i-1][1]+arr[i][2],arr[i-1][2]+arr[i][2]);
//        }
//
//        System.out.print(Math.max(arr[N-1][0], Math.max(arr[N-1][1],arr[N-1][2]))+" ");
//
//        for (int i = 1; i < N; i++) {
//            arr2[i][0]=Math.min(arr2[i-1][0],arr2[i-1][1])+arr2[i][0];
//            arr2[i][1]=Math.min(arr2[i-1][0],Math.min(arr2[i-1][1],arr2[i-1][2]))+arr2[i][1];
//            arr2[i][2]=Math.min(arr2[i-1][1],arr2[i-1][2])+arr2[i][2];
//        }
//        System.out.println(Math.min(arr2[N-1][0],Math.min(arr2[N-1][1],arr2[N-1][2])));
//    }
//}
public class BOJ2096 {

    public static void main(String[] args) throws Exception {
        int count = read();

        int[] min = new int[3];
        int[] max = new int[3];
        for (int i = 0; i < 3; i++) {
            min[i] = read();
        }
        for (int i = 0; i < 3; i++) {
            max[i] = min[i];
        }

        int temp;
        int[] line;
        for (int i = 1; i < count; i++) {
            line = new int[3];
            for (int j = 0; j < 3; j++) {
                line[j] = read();
            }

            temp = max[1];
            max[1] = Math.max(max[0], Math.max(max[1], max[2])) + line[1];
            max[0] = Math.max(max[0], temp) + line[0];
            max[2] = Math.max(temp, max[2]) + line[2];

            temp = min[1];
            min[1] = Math.min(min[0], Math.min(min[1], min[2])) + line[1];
            min[0] = Math.min(min[0], temp) + line[0];
            min[2] = Math.min(temp, min[2]) + line[2];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Math.max(max[0], Math.max(max[1], max[2]))).append(" ").append(Math.min(min[0], Math.min(min[1], min[2])));
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}