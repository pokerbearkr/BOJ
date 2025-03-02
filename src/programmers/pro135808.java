package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class pro135808 {
    public static void main(String[] args) {
        int k =4;
        int m = 3;
        int[] score ={4,1,2,2,4,4,4,4,1,2,4,2};

        Arrays.sort(score);
        int ans = 0;
        int box = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = score.length-1; i >=0; i--) {
            list.add(score[i]);
            box++;
            if (box % m == 0) {
                Collections.sort(list);
                ans+=list.getFirst()*m;
                list.clear();
                box=0;
            }
        }
        System.out.println(ans);

    }
}
