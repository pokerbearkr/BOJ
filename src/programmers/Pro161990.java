package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pro161990 {
    public static void main(String[] args) {
        String[] wallpaper = {".#...","..#..","...#."};

        Set<Integer> Xset = new HashSet<>();
        Set<Integer> Yset = new HashSet<>();

        for (int i = 0; i < wallpaper.length; i++) {
             for (int j = 0; j < wallpaper[i].length(); j++) {
                 if(wallpaper[i].charAt(j) == '#') {
                     Xset.add(i);
                     Yset.add(j);
                 }
             }
        }
        int minX = Xset.stream().min(Integer::compareTo).get();
        int minY = Yset.stream().min(Integer::compareTo).get();
        int maxX = Xset.stream().max(Integer::compareTo).get();
        int maxY = Yset.stream().max(Integer::compareTo).get();



    }
}
