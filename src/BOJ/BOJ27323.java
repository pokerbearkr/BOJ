package BOJ;

public class BOJ27323 {
    public static void main(String[] args) throws Exception {
        int A = read();
        int B = read();
        System.out.println(A * B);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }


}
