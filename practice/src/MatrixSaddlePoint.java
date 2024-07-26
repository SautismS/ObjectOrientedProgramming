import java.util.Random;

public class MatrixSaddlePoint {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java MatrixSaddlePoint <rows> <columns>");
            return;
        }

        int rows = Integer.parseInt(args[0]);
        int columns = Integer.parseInt(args[1]);

        if (rows < 1 || rows > 1000 || columns < 1 || columns > 1000) {
            System.out.println("Rows and columns must be between 1 and 1000.");
            return;
        }

        int[][] matrix = generateMatrix(rows, columns);
        System.out.println("Generated Matrix:");
        printMatrix(matrix);

        int[] saddlePoint = findSaddlePoint(matrix);
        if (saddlePoint != null) {
            System.out.println("Saddle Point:");
            System.out.println("(" + saddlePoint[0] + ", " + saddlePoint[1] + ") Value: " + matrix[saddlePoint[0]][saddlePoint[1]]);
        } else {
            System.out.println("No saddle point found.");
        }
    }

    public static int[][] generateMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = random.nextInt(1000); // Generating random integers between 0 and 999
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    public static int[] findSaddlePoint(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            int maxInRow = matrix[i][0];
            int columnIndex = 0;

            // Find the maximum element in the row
            for (int j = 1; j < columns; j++) {
                if (matrix[i][j] > maxInRow) {
                    maxInRow = matrix[i][j];
                    columnIndex = j;
                }
            }

            // Check if the maximum element in the row is also the minimum element in its column
            boolean isSaddlePoint = true;
            for (int k = 0; k < rows; k++) {
                if (matrix[k][columnIndex] < maxInRow) {
                    isSaddlePoint = false;
                    break;
                }
            }

            if (isSaddlePoint) {
                return new int[]{i, columnIndex};
            }
        }

        return null; // No saddle point found
    }
}
