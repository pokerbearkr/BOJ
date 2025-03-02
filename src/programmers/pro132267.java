package programmers;

public class pro132267 {
    public static void main(String[] args) throws Exception {
        int a=3,b=1,n=20;
        int ans=0;

        while (n >= a) {
            ans+=n/a*b;
            n=(n/a)*b+(n%a);
        }
        System.out.println(ans);
    }
}
