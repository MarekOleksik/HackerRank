package hackerrank.Java10DaysOfStatistics.Day9.MultipleLinearRegression;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        double[][] matrixX = new double[n][m + 1];

        double[][] matrixY = new double[n][2];

        for (int i = 0; i < n; i++) {
            matrixX[i][0] = 1;

            for (int j = 1; j <= m; j++) {
                matrixX[i][j] = scanner.nextDouble();
            }
            matrixY[i][0] = scanner.nextDouble();
            matrixY[i][1] = 0;

        }

        int q = scanner.nextInt();
        double[][] numberOfFeatureSets = new double[q][m];
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < m; j++) {
                numberOfFeatureSets[i][j] = scanner.nextDouble();
            }
        }

        double[][] matrixXTranspose = transposeMatrix(matrixX);
        double[][] XTMultiplyingX = multiplyMatrices(matrixXTranspose, matrixX);
        double[][] inversedMatrix = inverseMatrix(XTMultiplyingX);
        double[][] inversedMatrixMultipliedMatrixXTranspose = multiplyMatrices(inversedMatrix, matrixXTranspose);
        double[][] inversedMatrixMultipliedMatrixXTransposeMultiY = multiplyMatrices(inversedMatrixMultipliedMatrixXTranspose, matrixY);

        List<Double> results = new LinkedList<>();
        double sum;
        for (int i = 0; i < numberOfFeatureSets.length; i++) {
            sum = inversedMatrixMultipliedMatrixXTransposeMultiY[0][0];
            for (int j = 0; j < numberOfFeatureSets[0].length; j++) {
                sum += numberOfFeatureSets[i][j] * inversedMatrixMultipliedMatrixXTransposeMultiY[j + 1][0];
            }
            results.add(sum);
        }

        for (double res : results) {
            System.out.printf("%.2f\n", res);
        }
    }

    private static double[][] inverseMatrix(double[][] matrix) {
        int n = matrix.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i = 0; i < n; ++i)
            b[i][i] = 1;

        // Transform the matrix into an upper triangle
        gaussian(matrix, index);

        // Update the matrix b[i][j] with the ratios stored
        for (int i = 0; i < n - 1; ++i)
            for (int j = i + 1; j < n; ++j)
                for (int k = 0; k < n; ++k)
                    b[index[j]][k]
                            -= matrix[index[j]][i] * b[index[i]][k];

        // Perform backward substitutions
        for (int i = 0; i < n; ++i) {
            x[n - 1][i] = b[index[n - 1]][i] / matrix[index[n - 1]][n - 1];
            for (int j = n - 2; j >= 0; --j) {
                x[j][i] = b[index[j]][i];
                for (int k = j + 1; k < n; ++k) {
                    x[j][i] -= matrix[index[j]][k] * x[k][i];
                }
                x[j][i] /= matrix[index[j]][j];
            }
        }
        return x;
    }

    private static void gaussian(double a[][], int index[]) {
        int n = index.length;
        double c[] = new double[n];

        // Initialize the index
        for (int i = 0; i < n; ++i)
            index[i] = i;

        // Find the rescaling factors, one from each row
        for (int i = 0; i < n; ++i) {
            double c1 = 0;
            for (int j = 0; j < n; ++j) {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }

        // Search the pivoting element from each column
        int k = 0;
        for (int j = 0; j < n - 1; ++j) {
            double pi1 = 0;
            for (int i = j; i < n; ++i) {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }

            // Interchange rows according to the pivoting order
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i = j + 1; i < n; ++i) {
                double pj = a[index[i]][j] / a[index[j]][j];

                // Record pivoting ratios below the diagonal
                a[index[i]][j] = pj;

                // Modify other elements accordingly
                for (int l = j + 1; l < n; ++l)
                    a[index[i]][l] -= pj * a[index[j]][l];
            }
        }
    }

    private static double[][] transposeMatrix(double[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        double[][] matrixXTranspose = new double[column][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrixXTranspose[j][i] = matrix[i][j];
            }
        }

        return matrixXTranspose;
    }

    private static double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
        if (firstMatrix[0].length != secondMatrix.length) {
            throw new IllegalArgumentException("Matrix inner dimensions must agree.");
        }
        int r1 = firstMatrix.length;
        int c1 = firstMatrix[0].length;
        int c2 = secondMatrix[0].length;

        double[][] product = new double[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }

        return product;
    }

}
