package programmers;

public class pro134240 {
    public static void main(String[] args) {
        int[] food = {1,7,1,2};
        String s = "";

        for (int i = 1; i < food.length ; i++) {
            for (int j = 0; j < food[i]/2; j++) {
                s+=i+"";
            }
        }

        String s2 = "";
        for (int i = s.length()-1; i >=0; i--) {
            s2+=s.charAt(i);
        }
        System.out.println(s+"0"+s2);
    }
}
