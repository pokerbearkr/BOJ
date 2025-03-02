package programmers;

public class pro131128 {
    public static void main(String[] args) {
        String X = "12321";
        String Y = "42531";
        class Solution {
            public String solution(String X, String Y) {
                int[] xNumber = new int[10];
                int[] yNumber = new int[10];
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < X.length(); i++) {
                    xNumber[X.charAt(i) - '0']++;
                }
                for (int i = 0; i < Y.length(); i++) {
                    yNumber[Y.charAt(i) - '0']++;
                }
                String answer = "";
                for (int i = 9; i >=0 ; i--) {
                    if(i==0&&sb.length()==0&&Math.min(xNumber[i],yNumber[i])>=1){
                        return "0";
                    }
                    for (int j = 0; j < Math.min(xNumber[i],yNumber[i]); j++) {
                        sb.append(i);
                    }
                }
                if(sb.length()==0) return "-1";
                return sb.toString();
            }
        }

    }
}

