import java.util.*;

public class DiagonalSum {

	public static void main(String[] args) {
		double matrix[][] = { {1, 2, 3, 4.0}, //readInput();
							  {5, 6.5, 7, 8}, 
							  {9, 10, 11, 12}, 
							  {13, 14, 15, 16} };
		
		System.out.println("The sum of the elements in the major diagonals is " + sumMajorDiagonals(matrix)[0] + " & " + sumMajorDiagonals(matrix)[1]);
		
	}
	
	public static int[][] readInput() {
		Scanner in = new Scanner(System.in);
		
		int[][] matrix = new int[4][4]; 
		System.out.println("Enter the elements of the matrix.");
        for (int i = 0; i < matrix.length; i++) { 
              for (int j = 0 ;j < matrix[i].length; j++) { 
            	  matrix[i][j] = in.nextInt(); 
              } System.out.println(); 
        }
        in.close();
        
        return matrix;
	}
	
	public static double[] sumMajorDiagonals(double[][] matrix) {
		double[] sum = new double[2];
		for (int i = 0; i < matrix.length; i++) {
			sum[0] += matrix[i][i];
		}
		for (int i = 0; i < matrix.length; i++) {
			sum[1] += matrix[matrix.length - 1 - i][matrix.length - 1 - i];
		}
		
		return sum;
	}

}
