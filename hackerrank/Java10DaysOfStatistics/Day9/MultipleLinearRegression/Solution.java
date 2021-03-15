package hackerrank.Java10DaysOfStatistics.Day9.MultipleLinearRegression;

import java.util.Scanner;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        double[][] matrixX = new double[n][m + 1];

        double[] matrixY = new double[n];

        for (int i = 0; i < n; i++) {
            matrixX[i][0] = 1;

            for (int j = 1; j <= m; j++) {
                matrixX[i][j] = scanner.nextDouble();
            }
            matrixY[i] = scanner.nextDouble();

        }

        double[][] matrixXTranspose = transposeMatrix(matrixX, n, m + 1);

        double[][] XTMultiplyingX = multiplyMatrices(matrixXTranspose, matrixX, m + 1, n, m + 1);

        int q = scanner.nextInt();
        double[][] numberOfFeatureSets = new double[q][m];
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < m; j++) {
                numberOfFeatureSets[i][j] = scanner.nextDouble();
            }
        }
        System.out.println();

        System.out.println("Matrix X:");
        displayMatrix(matrixX);

        System.out.println("Matrix X Transpose:");
        displayMatrix(matrixXTranspose);

        System.out.println("Matrix X Transpose multiply matrix X:");
        displayMatrix(XTMultiplyingX);

        System.out.println("Matrix Y:");
        for (double y : matrixY) {
            System.out.println(y);
        }
        System.out.println("--------------------");

        System.out.println("Elements of Q:");
        displayMatrix(numberOfFeatureSets);
    }

    private static double[][] transposeMatrix(double[][] matrix, int row, int column) {
        double[][] matrixXTranspose = new double[column][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrixXTranspose[j][i] = matrix[i][j];
            }
        }

        return matrixXTranspose;
    }

    private static void displayMatrix(double[][] matrixX) {
        for (double[] x : matrixX) {
            for (double x1 : x) {
                System.out.printf("%.2f\t", x1);
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    public static double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix, int r1, int c1, int c2) {
        if (r1 != c2) {
            throw new IllegalArgumentException("Matrix inner dimensions must agree.");
        }

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
