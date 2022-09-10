package uli.nick.ylab.taskstwo.task2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.BDDAssertions.then;
import static uli.nick.ylab.taskstwo.task2.FindNumbersOfSum.findNumbersOfSum;
import static uli.nick.ylab.taskstwo.task2.FindNumbersOfSum.findNumbersOfSumByStream;

class FindNumbersOfSumTest {

    @Test
    void mainTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        FindNumbersOfSum.main(null);

        String actual = out.toString();
        String expected = "[3, 7]" + System.lineSeparator();

        then(actual).isEqualTo(expected);
    }

    @Test
    void findNumbersOfSumTest0() {
        int[] nums = new int[]{3, 4, 2, 7};
        int sum = 10;

        int[] actual = findNumbersOfSum(nums, sum);
        int[] actualStream = findNumbersOfSumByStream(nums, sum);
        int[] expected = new int[]{3, 7};

        then(actual).isEqualTo(expected);
        then(actualStream).isEqualTo(expected);
    }

    @Test
    void findNumbersOfSumTest1() {
        int[] nums = new int[]{-3, 4, 2, 13};
        int sum = 10;

        int[] actual = findNumbersOfSum(nums, sum);
        int[] actualStream = findNumbersOfSumByStream(nums, sum);
        int[] expected = new int[]{-3, 13};

        then(actual).isEqualTo(expected);
        then(actualStream).isEqualTo(expected);
    }

    @Test
    void findNumbersOfSumTest2() {
        int[] nums = new int[]{-3, 4, 2, 3};
        int sum = 0;

        int[] actual = findNumbersOfSum(nums, sum);
        int[] actualStream = findNumbersOfSumByStream(nums, sum);
        int[] expected = new int[]{-3, 3};

        then(actual).isEqualTo(expected);
        then(actualStream).isEqualTo(expected);
    }

    @Test
    void findNumbersOfSumTest3() {
        int[] nums = new int[]{-3, 4, 2, -7};
        int sum = -10;

        int[] actual = findNumbersOfSum(nums, sum);
        int[] actualStream = findNumbersOfSumByStream(nums, sum);
        int[] expected = new int[]{-3, -7};

        then(actual).isEqualTo(expected);
        then(actualStream).isEqualTo(expected);
    }

    @Test
    void findNumbersOfSumTest4() {
        int[] nums = new int[]{3, 0, 2, 10};
        int sum = 10;

        int[] actual = findNumbersOfSum(nums, sum);
        int[] actualStream = findNumbersOfSumByStream(nums, sum);
        int[] expected = new int[]{0, 10};

        then(actual).isEqualTo(expected);
        then(actualStream).isEqualTo(expected);
    }

    @Test
    void findNumbersOfSumTest5() {
        int[] nums = new int[]{5, 4, 5, 10};
        int sum = 10;

        int[] actual = findNumbersOfSum(nums, sum);
        int[] actualStream = findNumbersOfSumByStream(nums, sum);
        int[] expected = new int[]{5, 5};

        then(actual).isEqualTo(expected);
        then(actualStream).isEqualTo(expected);
    }

    @Test
    void findNumbersOfSumTest6() {
        int[] nums = new int[]{5, 4, 2, 10};
        int sum = 10;

        int[] actual = findNumbersOfSum(nums, sum);
        int[] actualStream = findNumbersOfSumByStream(nums, sum);
        int[] expected = new int[2];

        then(actual).isEqualTo(expected);
        then(actualStream).isEqualTo(expected);
    }

    @Test
    void findNumbersOfSumTest7() {
        int[] nums = new int[]{5};
        int sum = 10;

        int[] actual = findNumbersOfSum(nums, sum);
        int[] actualStream = findNumbersOfSumByStream(nums, sum);
        int[] expected = new int[2];

        then(actual).isEqualTo(expected);
        then(actualStream).isEqualTo(expected);
    }

    @Test
    void findNumbersOfSumTest8() {
        int[] nums = new int[2];
        int sum = 10;

        int[] actual = findNumbersOfSum(nums, sum);
        int[] actualStream = findNumbersOfSumByStream(nums, sum);
        int[] expected = new int[2];

        then(actual).isEqualTo(expected);
        then(actualStream).isEqualTo(expected);
    }

    @Test
    void findNumbersOfSumTest9() {
        int[] nums = null;
        int sum = 10;

        int[] actual = findNumbersOfSum(nums, sum);
        int[] actualStream = findNumbersOfSumByStream(nums, sum);
        int[] expected = new int[2];

        then(actual).isEqualTo(expected);
        then(actualStream).isEqualTo(expected);
    }
}