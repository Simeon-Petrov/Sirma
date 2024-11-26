import java.util.Scanner;

public class MatrixDiagonalSum_7 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        int n = Integer.parseInt(dimensions[0]);

        int[][] matrix = new int[n][n];


        for (int i = 0; i < n; i++) {
            String[] elements = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(elements[j]);
            }
        }


        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int i = 0; i < n; i++) {
            primaryDiagonalSum += matrix[i][i];
            secondaryDiagonalSum += matrix[i][n - 1 - i];
        }


        System.out.println(primaryDiagonalSum + secondaryDiagonalSum);
    }
}