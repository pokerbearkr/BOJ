package BOJ;
import java.util.Scanner;
public class BOJ4101 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(true) {
            long A=scanner.nextLong();
            long B=scanner.nextLong();
            if(A==0 && B==0){
                break;
            }
            if(A>B){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }

        }
    }
}
