package programmers;

public class pro12977 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 6, 4};
        int count = 0 ;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                for (int k = j+1; k < nums.length ; k++) {
                    if(isSosu(nums[i], nums[j], nums[k])) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isSosu(int a, int b, int c) {
        int n = a+b+c;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
