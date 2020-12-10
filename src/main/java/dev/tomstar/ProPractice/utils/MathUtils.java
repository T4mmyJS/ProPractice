package dev.tomstar.ProPractice.utils;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class MathUtils {

    public static int[] getValues(int start, int end) {
        if (start > end) {
            return IntStream.rangeClosed(end - start, 0).toArray();
        }

        return IntStream.rangeClosed(0 , end - start).toArray();
    }

    public static int getRandom(int start, int end) {
        return ThreadLocalRandom.current().nextInt(start, end + 1);
    }

}
