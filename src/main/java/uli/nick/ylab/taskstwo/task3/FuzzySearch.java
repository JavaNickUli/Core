package uli.nick.ylab.taskstwo.task3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Task3: Реализовать функцию нечеткого поиска.
 */

public class FuzzySearch {

    public static void main(String[] args) {
        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel"));
        System.out.println(fuzzySearch("cwhl", "cartwheel"));
        System.out.println(fuzzySearch("cwhee", "cartwheel"));
        System.out.println(fuzzySearch("cartwheel", "cartwheel"));
        System.out.println(fuzzySearch("cwheeel", "cartwheel"));
        System.out.println(fuzzySearch("lw", "cartwheel"));
    }

    public static boolean fuzzySearch(String origin, String target) {
        if (origin == null || origin.length() == 0 || target == null || origin.length() > target.length()) {
            return false;
        }

        int index = 0;

        for (char symbol : target.toCharArray()) {
            if (origin.charAt(index) == symbol && ++index == origin.length()) {
                return true;
            }
        }

        return false;
    }

    public static boolean fuzzySearchByStream(String origin, String target) {
        if (origin == null || origin.length() == 0 || target == null || origin.length() > target.length()) {
            return false;
        }

        AtomicInteger index = new AtomicInteger(0);

        return origin.chars()
                .allMatch(origChar -> target.chars()
                        .skip(index.get())
                        .peek(targChar -> index.getAndIncrement())
                        .filter(targChar -> targChar == origChar)
                        .findFirst()
                        .isPresent()
                );
    }
}
