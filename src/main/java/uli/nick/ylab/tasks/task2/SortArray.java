package uli.nick.ylab.tasks.task2;

/**
 * Task2: Отсортируйте массив [5,6,3,2,5,1,4,9].
 */

public class SortArray {

    public static void main(String[] args) {
        int[] givenArray = {5, 6, 3, 2, 5, 1, 4, 9};
        displayArray(givenArray);
        displayArray(sortArray(givenArray));

        assert checkSortOrder(sortArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7}));
        assert checkSortOrder(sortArray(new int[]{7, 6, 5, 4, 3, 2, 1, 0}));
        assert checkSortOrder(sortArray(new int[]{3, 2, 1, 0, 7, 6, 5, 4}));
        assert checkSortOrder(sortArray(new int[]{0, 1, 2, 3, 0, 1, 2, 3}));
        assert checkSortOrder(sortArray(new int[]{7, 0, 6, 1, 5, 2, 4, 3}));
        assert checkSortOrder(sortArray(new int[]{6, 6, 6, 6, 2, 2, 2, 2}));
        assert checkSortOrder(sortArray(new int[]{0, 0, 7, 7, 0, 0, 4, 4}));
        assert checkSortOrder(sortArray(new int[]{0, 1, 2, 3, 0, 1, 2, 3}));
        assert checkSortOrder(sortArray(new int[]{7, 1, 0, 1, 0, 1, 0, 1}));
        assert checkSortOrder(sortArray(new int[]{0, 1, 0, 1, 0, 1, 0, 7}));
        assert checkSortOrder(sortArray(new int[]
                {356, 1, 235, 975, 33, 724, 6757, 7, 29, 402, 54, 121, 9}));
    }

    public static int[] sortArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                int lesser = array[i];
                int j = i;
                do {
                    array[j--] = array[j];
                } while (j != 0 && lesser < array[j - 1]);
                array[j] = lesser;
            }
        }
        return array;
    }

    public static void displayArray(int[] array) {
        for (int element : array) {
            System.out.print(element + "\t");
        }
        System.out.println();
    }

    public static boolean checkSortOrder(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }
}