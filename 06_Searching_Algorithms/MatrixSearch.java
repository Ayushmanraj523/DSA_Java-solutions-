//5. Search in 2D Array (Matrix)
//Concept: Searching in multi-dimensional arrays


public class MatrixSearch {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };
        
        int target = 6;
        boolean found = false;
        int rowPos = -1, colPos = -1;
        
        // Search through rows and columns
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == target) {
                    found = true;
                    rowPos = row;
                    colPos = col;
                    break;
                }
            }
            if (found) break;
        }
        
        if (found) {
            System.out.println(target + " found at position: [" + rowPos + "][" + colPos + "]");
        } else {
            System.out.println(target + " not found in matrix");
        }
        
        // Find maximum in each row
        System.out.println("\nMaximum in each row:");
        for (int row = 0; row < matrix.length; row++) {
            int rowMax = matrix[row][0];
            for (int col = 1; col < matrix[row].length; col++) {
                if (matrix[row][col] > rowMax) {
                    rowMax = matrix[row][col];
                }
            }
            System.out.println("Row " + row + " max: " + rowMax);
        }
    }

}
