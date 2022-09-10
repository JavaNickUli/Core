package uli.nick.ylab.taskstwo.task2;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Task2: [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10.
 */

public class FindNumbersOfSum {

    private static final int[] nums = new int[]{3, 4, 2, 7};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findNumbersOfSum(nums, 10)));
    }

    public static int[] findNumbersOfSum(int[] nums, int sum) {
        if (nums == null) {
            return new int[2];
        }
        
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == sum) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        
        return new int[2];
    }

    public static int[] findNumbersOfSumByStream(int[] nums, int sum) {
        if (nums == null || nums.length < 2) {
            return new int[2];
        }
        
        AtomicInteger index = new AtomicInteger(0);

        return Arrays.stream(nums)
                .peek(first -> index.getAndIncrement())
                .filter(first -> Arrays.stream(nums)
                        .skip(index.get())
                        .filter(second -> second + first == sum)
                        .findFirst()
                        .isPresent())
                .boxed()
                .findFirst()
                .map(first -> new int[]{first, sum - first})
                .orElse(new int[2]);
    }
}
