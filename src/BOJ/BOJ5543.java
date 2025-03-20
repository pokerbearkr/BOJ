package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ5543 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int burger = Integer.MAX_VALUE;

        burger = Math.min(burger, Integer.parseInt(br.readLine()));
        burger = Math.min(burger, Integer.parseInt(br.readLine()));
        burger = Math.min(burger, Integer.parseInt(br.readLine()));

        int drink = Integer.MAX_VALUE;

        drink = Math.min(drink, Integer.parseInt(br.readLine()));
        drink = Math.min(drink, Integer.parseInt(br.readLine()));

        System.out.println(burger+drink-50);

    }
}
