import java.util.Scanner;

public class IntersectionOfTwoMatrices_3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();

        char[][] matrixA = new char[M][N];
        for (int i = 0; i < M; i++) {
            String[] line = sc.nextLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrixA[i][j] = line[j].charAt(0);
            }
        }

        char[][] matrixB = new char[M][N];
        for (int i = 0; i < M; i++) {
            String[] line = sc.nextLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrixB[i][j] = line[j].charAt(0);
            }
        }

        char[][] resultMatrix = new char[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {

                if (matrixA[i][j] == matrixB[i][j]) {
                    resultMatrix[i][j] = matrixA[i][j];
                } else {
                    resultMatrix[i][j] = '*';
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}