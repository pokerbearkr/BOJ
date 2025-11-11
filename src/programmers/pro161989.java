package programmers;

public class pro161989 {
    public static void main(String[] args) {
        int n=4;
        int m =1;
        int[] section = {1,2,3,4};
        int doneWall=0;
        int count=0;

        for (int i = 0; i < section.length; i++) {
            if (doneWall < section[i]) {
                doneWall = section[i] + m-1;
                count++;
            }
        }
        System.out.println(count);
    }
}
