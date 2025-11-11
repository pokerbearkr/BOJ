package BOJ;

public class BOJ14732 {
    public static void main(String[] args) throws Exception {
        boolean[][] arr = new boolean[500][500];

        int N = read();
        int ans=0;
        for (int i = 0; i < N; i++) {
            int x1 = read();
            int y1 = read();
            int x2 = read();
            int y2 = read();
            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    if (!arr[j][k]) {
                        ans++;
                    }
                    arr[j][k]=true;
                }
            }
        }


        System.out.println(ans);

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
