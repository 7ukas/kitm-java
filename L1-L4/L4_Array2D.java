import java.util.Random;
import java.util.Scanner;

public class L4_Array2D {
    public static boolean containsValue(int[][] matrix, int targetValue) {
        for (int[] row : matrix) {
            for (int value : row) {
                if (value == targetValue) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void matrixDemo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter columns: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        double avg = 0; // of all elements

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("matrix[" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
                avg += matrix[i][j];
            }
        }
        avg /= (matrix.length * matrix[0].length);

        System.out.println("\nMatrix: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.printf("\nAverage: %.2f", avg);
    }

    /* 50% */
    public static int maxMirror(int[] arr) {
        int length = 0;
        int tempLength = 1;

        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i+1] == arr[i]+1 || arr[i+1] == arr[i]-1) {
                tempLength++;

                if (tempLength > length) {
                    length = tempLength;
                }
            } else tempLength = 1;
        }

        return length;
    }

    public static boolean has22(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == 2 && arr[i+1] == 2) {
                return true;
            }
        }

        return false;
    }

    public static int[] createArray(int len) {
        int[] arr = new int[len];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(1264);
        }

        return arr;
    }

    public static int getMin(int[] arr) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return min;
    }

    public static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static int getSum(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum;
    }

    public static double getAvg(int[] arr) {
        return (double)getSum(arr) / arr.length;
    }
}
