package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String A = bf.readLine();
        String B = bf.readLine();
        String C = bf.readLine();
        int target=0;
        if(isNumberic(A)){
            target = Integer.parseInt(A)+3;
        }else if(isNumberic(B)){
            target = Integer.parseInt(B)+2;
        }else if(isNumberic(C)) {
            target = Integer.parseInt(C)+1;
        }

        if(target%3==0&&target%5==0){
            System.out.println("FizzBuzz");
        }else if(target%3==0&&target%5!=0){
            System.out.println("Fizz");
        }else if(target%3!=0&&target%5==0){
            System.out.println("Buzz");
        }else{
            System.out.println(target);
        }

    }
    public static boolean isNumberic(String str) {
        return str.matches("[+-]?\\d*(\\.\\d+)?");
    }
}
