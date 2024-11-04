package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1206 {
    static BufferedReader bf;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));

        //10번 돌리기
        for (int i = 1; i <11; i++) {
            System.out.print("#"+i+" ");
            System.out.println(test());
        }
    }

    public static int test() throws IOException{
        int N = Integer.parseInt(bf.readLine());
        int[] building = new int[N + 4];
        int sum=0;
        building[0]=0;
        building[1]=0;
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            building[i + 2] = Integer.parseInt(st.nextToken());
        }
        for (int i = 2; i < N+2; i++) {
            if (building[i - 2] < building[i] && building[i - 1] < building[i] && building[i+1]<building[i] && building[i+2]< building[i]) {
                sum+=building[i]-Math.max(Math.max(building[i-2],building[i-1]),Math.max(building[i+1],building[i+2]));
            }
        }
        return sum;

    }
}
