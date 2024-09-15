package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int order;
        PriorityQueue<Integer> arr = new PriorityQueue(Comparator.reverseOrder());

        for (int i = 0; i < N; i++) {
            order = Integer.parseInt(bf.readLine());
            if(order==0){
                if(arr.isEmpty()){
                    System.out.println("0");
                }else{
                    System.out.println(arr.poll());
                }
            }else{
                arr.add(order);
            }

        }


    }
}
