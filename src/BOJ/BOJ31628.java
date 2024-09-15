package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ31628 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[][] arr = new String[10][10];

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 10; j++) {
                arr[i][j] = st.nextToken();
            }
        }

        boolean rowCheck = true, colCheck = true;

        String firstRowColor = arr[0][0];
        String firstColColor = arr[0][0];

        for (int i = 1; i < 10; i++) {
            if (!arr[0][i].equals(firstRowColor)) {
                rowCheck = false;
            }
            if (!arr[i][0].equals(firstColColor)) {
                colCheck = false;
            }
        }

        if (rowCheck || colCheck) {
            System.out.println("1");
            return;
        }

        for (int i = 0; i < 10; i++) {
            String rowColor = arr[i][0];
            String colColor = arr[0][i];
            boolean rowSame = true, colSame = true;

            for (int j = 1; j < 10; j++) {
                if (!arr[i][j].equals(rowColor)) {
                    rowSame = false;
                }
                if (!arr[j][i].equals(colColor)) {
                    colSame = false;
                }
                if (!rowSame && !colSame) {
                    break;
                }
            }

            if (rowSame || colSame) {
                System.out.println("1");
                return;
            }
        }

        System.out.println("0");
    }
}
