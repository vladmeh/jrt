package array;

/**
 * @autor mvl on 06.07.2017.
 */
public class RotateMatrix {
    public static  int[][] matrix = {
            {0, 1, 2, 3},
            {1, 2, 3, 4},
            {2, 3, 4, 5},
            {3, 4, 5, 6},
    };

    public static void main(String[] args) {
        printMatrix(matrix);
        for (int i = 0; i < 4; i++) {
            rotateToRight();
        }
    }

    /**
     * классический поворот двумерного массива по часовой стрелке
     */
    private static void rotateToRight(){
        final int h = matrix.length;
        final int w = matrix[0].length;
        int[][] rotateMatrix = new int[w][h];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                rotateMatrix[j][h-1-i] = matrix[i][j];
            }
        }
        matrix = rotateMatrix;
        System.out.println("rotate");
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix){
        for (int[] rows : matrix) {
            for (int col : rows) {
                System.out.printf("[%d]", col);
            }
            System.out.println();
        }
    }
}
