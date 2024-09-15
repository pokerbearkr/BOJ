package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st ;
        st = new StringTokenizer(bf.readLine());
        int[] size = new int[6];
        for (int i = 0; i < 6; i++) {
            size[i]=Integer.parseInt(st.nextToken());

        }
        st = new StringTokenizer(bf.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int ans = 0 ;
        for (int i = 0; i < 6; i++) {
            if(size[i]==0){
                ans+=0;
            }else if(size[i]%T==0) {
                ans+=size[i]/T;
            }
            else{
                    int a = size[i]/T;
                    ans+=a+1;
                }
            }

        System.out.println(ans);
        System.out.println((int)N/P+" "+N%P);
        }

    }

