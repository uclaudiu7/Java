package week1;

public class Bonus1 {
    public static void main(String[] args) {
        int nrArgs = args.length;
        if(nrArgs != 1){
            System.out.println("Please provide the number of vertices in your graph and only that number!");
            return;
        }
        try{
            int n = Integer.parseInt(args[0]);
            int[][] adjacencyMatrix = createAdjacencyMatrix(n);
            System.out.println("The adjacency matrix: ");
            printMatrix(adjacencyMatrix, n);

            int[][] previousMultiplication = adjacencyMatrix;
            for(int i = 1; i < n; i++) {
                previousMultiplication = multiplyMatrix(previousMultiplication, adjacencyMatrix, n);
                System.out.println("The adjacency matrix raised to the power " + (i+1) + ":");
                printMatrix(previousMultiplication, n);
            }

        }
        catch (NumberFormatException exc){
            System.out.println("You must provide an integer!");
        }
    }

    public static int[][] createAdjacencyMatrix(int n){
        int[][] adjacencyMatrix = new int[n][n];
        /*
         *     In a cycle graph the first vertex is adjacent with the 2nd and the last,
         *   the 2nd vertex will be adjacent with the 1st and the 3rd and so on...
         */
        int lastVertex = n-1;
        int nextVertex = 1;
        for(int i = 0; i < n; i++){
            adjacencyMatrix[i][nextVertex] = 1;
            adjacencyMatrix[i][lastVertex] = 1;
            nextVertex = (nextVertex+1) % n; // In case we go past n, we should come back to the beginning
            lastVertex = (lastVertex+1) % n;
        }
        return adjacencyMatrix;
    }

    public static int[][] multiplyMatrix(int[][] A, int[][] B, int n){
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    public static void printMatrix(int[][] matrix, int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}