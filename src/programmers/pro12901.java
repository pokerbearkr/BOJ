package programmers;

import java.util.*;

public class pro12901 {
    public static void main(String[] args) {
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        List<String> card1 = new ArrayList<>(Arrays.asList(cards1));
        List<String> card2 = new ArrayList<>(Arrays.asList(cards2));

        for (String word : goal) {
            if (!card1.isEmpty() && word.equals(card1.get(0))) {
                card1.remove(0);
            } else if (!card2.isEmpty() && word.equals(card2.get(0))) {
                card2.remove(0);
            } else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}