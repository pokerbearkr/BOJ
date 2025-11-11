package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ33042 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String tem = bf.readLine();
        String[] arr = tem.split(" ");
        HashMap<String,Integer> arr2 = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String string = arr[i];
            if (arr2.containsKey(string)) {
                arr2.put(string,arr2.get(string)+1);
                if (arr2.get(string) == 5) {
                    System.out.println(i+1);
                    return;
                }
            } else {
                arr2.put(string,1);
            }
        }
        System.out.println(0);

    }
}
