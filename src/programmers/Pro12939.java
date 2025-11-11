package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Pro12939 {
    public static void main(String[] args) {
        String s = "1 2 3 4";
        StringTokenizer st = new StringTokenizer(s);
        List<Integer> list = new ArrayList<>();
        int n = st.countTokens();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        String answer = list.get(0).toString()+" "+list.get(list.size()-1).toString();
        System.out.println(answer);
    }
}
