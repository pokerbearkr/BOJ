package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
// 정답은 맞았지만 오래걸림
public class BOJ16435 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[] input = bf.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            list.add(Integer.parseInt(input[i]));
        }
        while(true){
            if(list.isEmpty()){
                System.out.println(K);
                return;
            }
            int min = Collections.min(list);

            if (min>K){
                System.out.println(K);
                return;
            }
            K++;
            list.remove(Integer.valueOf(min));
        }
    }
}
