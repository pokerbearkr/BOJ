package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String data1 = bf.readLine();
        String data[] = data1.split(" ");
        int A = Integer.parseInt(data[0]);
        int B = Integer.parseInt(data[1]);
        int C = Integer.parseInt(data[2]);
        int D = Integer.parseInt(data[3]);
        System.out.println(Math.min(Math.min(A,C-A),Math.min(B,D-B)));
    }
}
