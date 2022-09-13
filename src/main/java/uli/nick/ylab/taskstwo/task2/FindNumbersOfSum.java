package uli.nick.ylab.taskstwo.task2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(sum - num)) {
                return new int[]{(sum - num), num};
            }
            set.add(num);
        }
        return new int[2];
    }

    public static int[] findNumbersOfSumByStream(int[] nums, int sum) {
        if (nums == null || nums.length < 2) {
            return new int[2];
        }

        Set<Integer> set = new HashSet<>();

        return Arrays.stream(nums)
                .boxed()
                .filter(first -> set.contains(sum - first) &
                        (set.add(first) || first == sum - first))
                .findFirst()
                .map(first -> new int[]{sum - first, first})
                .orElse(new int[2]);
    }
}
