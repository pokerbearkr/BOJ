package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

 // java에서 list,array사용의 기초;
public class BOJ15904 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String A = bf.readLine();

        char[] ch = A.toCharArray();
        ArrayList<Character> list = new ArrayList<Character>();

        for(char c:ch){
            if(Character.isUpperCase(c)){
                list.add(c);
            }
        }
        String target = "UCPC";
        int index = 0;
        for(char c : list){
            if(c==target.charAt(index)){
                index++;
            }
            if(index==target.length()){
                System.out.println("I love UCPC");
                return;
            }

        }
        System.out.println("I hate UCPC");

    }
}
