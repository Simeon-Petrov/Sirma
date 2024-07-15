import java.util.Scanner;

public class CompareMatrices_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows1 = sc.nextInt();
        int cols1 = sc.nextInt();

        int[][] matrix1 = new int[rows1][cols1];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }

        int rows2 = sc.nextInt();
        int cols2 = sc.nextInt();

        int[][] matrix2 = new int[rows2][cols2];
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }

        boolean isEqual = compareMatrices(matrix1, matrix2);


        if (isEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }


    public static boolean compareMatrices(int[][] matrix1, int[][] matrix2) {

        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            return false;
        }

        // Сравняване на елементите по редове и колони
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
