package programmers;

import java.util.HashMap;
import java.util.Map;

public class Pro178871 {
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        for(String call : callings) {
            for (int i = 1; i < players.length; i++) {
                if(players[i].equals(call)) {
                    String tem = players[i-1];
                    players[i-1] = players[i];
                    players[i] = tem;
                }
            }
        }
        System.out.println(players[0]);
    }

}

