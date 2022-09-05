package uli.nick.ylab.tasks.task1;

/**
 *  Task1: Заполните массив случайным числами и выведите максимальное, минимальное и среднее значение.
 */

public class RandomMinMaxAverage {

    private static double random = System.nanoTime();

    public static void main(String[] args) {
        int[][] table = new int[30][25];
        fillTableRandom(table, 100);
        displayTable(table);
        maxMinAverage(table);
    }

    public static void maxMinAverage(int[][] array) {
        int max = array[0][0], min = max;
        int sum = 0, count = 0;
        for (int[] row : array) {
            for (int cell : row) {
                if (max < cell) {
                    max = cell;
                }
                if (min > cell) {
                    min = cell;
                }
                sum += cell;
                count++;
            }
        }
        System.out.println("MAX = " + max + ", MIN = " + min + ", AVERAGE = " + (double) sum / count);
    }

    public static void displayTable(int[][] array) {
        for (int[] row : array) {
            for (int cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }

    public static void fillTableRandom(int[][] array, int range) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (getRandom() * range);
            }
        }
    }

    public static double getRandom() {
        random = (double) String.valueOf(random).hashCode() / Integer.MIN_VALUE;
        return random < 0 ? -random : random;
    }
}

