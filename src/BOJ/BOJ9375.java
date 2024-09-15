package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());


        for (int i = 0; i < N; i++) {
            int wear = 0;
            String[] arr = new String[30]; // 들어오는 옷종류
            ArrayList<String> arr2 = new ArrayList<String>(30); //중복여부확인
            int[] arr3 = new int[30]; //해당 옷 개수
            wear = Integer.parseInt(bf.readLine());
            for (int j = 0; j < wear; j++) {
                st = new StringTokenizer(bf.readLine());
                st.nextToken();
                arr[j]= st.nextToken();
                boolean found = arr2.contains(arr[j]);
                if(found){
                    arr3[arr2.indexOf(arr[j])]+=1;
                }else{
                    arr2.add(arr[j]);
                    arr3[arr2.indexOf(arr[j])]=1;
                }
            }
            int ans=1;
            for (int j = 0; j < arr2.size(); j++) {
                ans*=(arr3[j]+1);
            }
            System.out.println(ans-1);
        }
    }
}
