package week1;

public class Homework {
    public static void main(String[] args) {
        int nrArgs = args.length;
        if(nrArgs != 1){
            System.out.println("You need to pass exactly one argument!");
            return;
        }
        try{
            int n = Integer.parseInt(args[0]);
            if(n <= 0){
                System.out.println("Your value should be greater than 0!");
                return;
            }
            long startTime = System.currentTimeMillis();
            int[][] latinSquare = createLatinSquare(n);
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            if(n > 30000){
                System.out.println("Running time in milliseconds: " + runTime);
            }
            else{
                printLatinSquare(latinSquare, n);
            }

        }
        catch (NumberFormatException exc){
            System.out.println("Argument must be an integer!");
        }
    }

    public static int[][] createLatinSquare(int n){
        int[][] latinSquare = new int[n][n];
        int rotationPoint = n;
        for(int i = 0; i < n; i++){
            int value = 1;
            int index = rotationPoint;
            while(index < n){
                latinSquare[i][index++] = value++;
            }
            for(int j = 0; j < rotationPoint; j++){
                latinSquare[i][j] = value++;
            }
            rotationPoint--;
        }
        return latinSquare;
    }

    public static void printLatinSquare(int[][] latinSquare, int n){
        for(int i = 0; i < n; i++){
            String currentLine = "Line " + (i+1) + ":     ";
            for(int j = 0; j < n; j++)
                currentLine = currentLine + latinSquare[i][j] + " ";
            System.out.println(currentLine);
        }
        for(int i = 0; i < n; i++){
            String currentColumn = "Column " + (i+1) + ":   ";
            for(int j = 0; j < n; j++)
                currentColumn = currentColumn + latinSquare[j][i] + " ";
            System.out.println(currentColumn);
        }
    }
}
