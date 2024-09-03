package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(bf.readLine());
        int arr[] = new int[21];
        arr[0]=0;
        arr[1]=1;
        for(int i=2;i<21;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        System.out.println(arr[A]);
        }
    }
