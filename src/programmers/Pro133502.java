package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pro133502 {
    public static void main(String[] args) {
        int[] ingredient = {2,1,1,2,3,1,2,3,1};

        List<Integer> list = new ArrayList<>();
        int count =0;

        for (int i = 0; i < ingredient.length; i++) {
            list.add(ingredient[i]);
            int size = list.size();
            if (size >= 4 && list.subList(size - 4, size).equals(Arrays.asList(1, 2, 3, 1))) {
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
                count++;
            }
        }
        System.out.println(count);
    }
}
