package uli.nick.ylab.tasks.addtasks;

/**
 * Task*: Удалить в массиве все числа, которые повторяются более двух раз.
 */

public class DeleteFromArrayMoreThenTwo {

    public static void main(String[] args) {
        int[] test = {3, 3, 3, 3, 6, 7, 3, 3, 1};
        displayArray(deleteMoreThenTwo(test));
    }

    public static int[] deleteMoreThenTwo(int[] array) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            int count = 0;
            int number = array[i];
            for (int j = i; j < size; j++) {
                if (number == array[j] && count++ > 1) {
                    int k = i;
                    for (int l = i; l < size; l++) {
                        if (number != array[l]) {
                            if (k != l) {
                                array[k] = array[l];
                            }
                            k++;
                        }
                    }
                    i--;
                    size = k;
                }
            }
        }
        int[] trimArray = new int[size];
        System.arraycopy(array, 0, trimArray, 0, size);
        return trimArray;
    }

    public static void displayArray(int[] array) {
        for (int element : array) {
            System.out.print(element + "\t");
        }
        System.out.println();
    }
}
