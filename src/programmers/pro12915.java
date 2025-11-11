package programmers;

import java.util.ArrayList;
import java.util.List;

public class pro12915 {
    public static void main(String[] args) throws Exception {
        String s = "banana";

        String st = s.charAt(0) + "";
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        for (int i = 1; i < s.length(); i++) {
            int n = st.lastIndexOf(s.charAt(i));
            if (n == -1) {
                list.add(-1);
            }else{
                list.add(i-n);
            }
            st+=s.charAt(i);
        }
        System.out.println(list);
    }
}
