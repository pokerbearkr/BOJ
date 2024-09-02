package BOJ;
import java.util.Scanner;
public class BOJ2420 {
    public static void main(String[] args) {
        long A,B;
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextInt();
        B = scanner.nextInt();
        if(A>B){
            System.out.println(A-B);
        }else{
            System.out.println(B-A);
        }
    }
}
