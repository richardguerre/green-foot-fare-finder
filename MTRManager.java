import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MTRManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MTRManager extends Actor {
    // A 2D array instance variable
    private double[][] fares ;    
    public void initializeAllFares() {        
        // Assume we have 4 MTR stations
        fares = new double[4][4];        
        // From HangHau
        fares[0][0] = 4.0; // to HangHau
        fares[0][1] = 7.5; // to ChoiHung
        fares[0][2] = 8.5; // to Mongkok
        fares[0][3] = 12.0; // to Central        
        // From ChoiHung
        fares[1][0] = 7.5; // to HangHau
        fares[1][1] = 4.0; // to ChoiHung
        fares[1][2] = 7.5; // to Mongkok
        fares[1][3] = 12.0; // to Central
        // From Mongkok
        fares[2][0] = 8.5; // to HangHau
        fares[2][1] = 7.5; // to ChoiHung
        fares[2][2] = 4.0; // to Mongkok
        fares[2][3] = 11.0; // to Central        
        // From Central 
        fares[3][0] = 12.0; // to HangHau
        fares[3][1] = 12.0; // to ChoiHung
        fares[3][2] = 11.0; // to Mongkok
        fares[3][3] = 4.0; // to Central                
    }
    
    
    //
    // ========= Start your work ============
    //
    
    
    /**
     * TODO: (Task 1) An example of traversing a 2D array
     *  and find the minimum fare
     */
    public double findMinFare2D() {
        double minFare = fares[0][0];
        for(int u=0; u<fares.length; u++){
            for(int i=0; i<fares[0].length; i++){
                if(fares[u][i] < minFare){
                    minFare = fares[u][i];
                }
                System.out.println(minFare);
            }
        }
        return minFare;
 
    }
    
    /**
     * TODO: (Task 1) An example of traversing a 2D array
     *  and find the maximum fare
     */
    public double findMaxFare2D() {
        double maxFare = fares[0][0];
        for(int u=0; u<fares.length; u++){
            for(int i=0; i<fares[0].length; i++){
                if(fares[u][i] > maxFare){
                    maxFare = fares[u][i];
                }
                System.out.println(maxFare);
            }
        }
        return maxFare; // remove this line to start your work
    }
    
    /**
    * TODO: (Task 2) An example of traversing a 2D array
    *  and find the average
    * Return 0.0 if the number of stations is equal to zero
    */
    public double computeAverageFare2D() {
        double sum = 0;
        for(int u=0; u<fares.length; u++){
            for(int i=0; i<fares[0].length; i++){
                sum += fares[u][i];
            }
        }
        //System.out.println(sum);
        double average = sum/(fares.length*fares[0].length);
        return average;
    }
    
    
    /**
    * TODO: (Task 3) returns a 2D array of boolean indicating which stations 
    * one can travel with a given amount of money
    */
   private boolean[][] canGo;
   private boolean[][] findStations2D(double inputAmount) {
        canGo = new boolean[4][4];
        for(int u = 0; u<fares.length; u++){
            for(int i = 0; i<fares.length; i++){
                if(inputAmount >= fares[u][i]){ //inputAmount >= fares[u][i]
                    canGo[u][i] = true;
                    //System.out.println("("+u+","+i+") is true");
                }
                else{ canGo[u][i] = false; System.out.println("("+u+","+i+") is false"); 
                }
            }
        }
        return canGo;
    }
    
   
    
    //
    // ========= End your work ============
    //
    
    
    
    
    
    /**
    * Prints out the indices of the stations one can  
    * travel with a given amount of money
    * Format of the output:
    * 
    * (row1,col1), (row2, col2).....
    * 
    */
   public void printFindStations2D(double inputAmount) {       
       
       // Invoke the method you have written in Task 3
       boolean[][] stations = findStations2D(inputAmount);
       
        // Get the number of rows from the 2D array
        int numOfRows = stations.length;                        
        // assume all columns having the same length
        int numOfCols = stations[0].length;
        
       System.out.println("The indices of stations are: ");
        for (int i=0; i<numOfRows; i++) {
            for ( int j=0; j<numOfCols; j++) {
                if ( stations[i][j] )
                    System.out.print( "(" + i + "," + j + "), ");
            }
        } // end of the nested loop
        System.out.println(); // move to the next line        
        printAllFares(); // print all the fares
    }
   
   boolean hangHau = true;
   boolean choiHung = true;
   boolean mongKok = true;
   boolean central = true;
   public void printNamesOfStations( double inputAmount, String from){
       boolean[][] stations = findStations2D(inputAmount);
       System.out.print("With "+inputAmount+", You can go to: ");
       for(int c=0; c<fares.length; c++){
          for(int r=0; r<fares[0].length; r++){
              switch (from){
                   case "Hang Hau": c = 0; break;
                   case "Choi Hung": c = 1; break;
                   case "Mong Kok": c = 2; break;
                   case "Central": c = 3; break;
                   default: c = c; break;
              }
              if( stations[0][c] ){
                    if(hangHau) 
                    System.out.print("Hang Hau, "); hangHau = false;
                }
              else if( stations[1][c] ){
                    if(choiHung)
                    System.out.print("Choi Hung, "); choiHung = false;
                }
              else if( stations[2][c] ){
                    if(mongKok)
                    System.out.print("Mong Kok, "); mongKok = false;
                }
              else if( stations[3][c] ){
                    if(central)
                    System.out.print("Central, "); central = false;
                }
          }
       }
       System.out.println();
       printAllFares();
    }
    
    
    
    
    
    
    /**
     * Get the fare of the MTR based two indices
     * Return -1.0 if one of the indices is invalid
     */
    public double getFareByIndices(int rowIndex, int colIndex) {                
        // Get the number of rows from the 2D array
        int numOfRows = fares.length;                        
        // assume all columns having the same length
        int numOfCols = fares[0].length;        
        // Invalid row index
        if ( rowIndex < 0 || rowIndex >= numOfRows )
            return -1.0;        
        // Invalid column index
        if ( colIndex < 0 || colIndex >= numOfCols )
            return -1.0;            
        // return the fare at rowIndex, colIndex
        return fares[rowIndex][colIndex];        
    }
    
    /**
     * Print all the fares
     * System.out.print and System.out.println 
     * will be used in this example
     */
    public void printAllFares() {        
       // Get the number of rows from the 2D array
        int numOfRows = fares.length;                        
        // assume all columns having the same length
        int numOfCols = fares[0].length;           
        // Traversing a 2D array using a nested loop
        for ( int r=0; r<numOfRows; r++) {            
            // print the row number
            System.out.print("Row " + r + " : ");
            for (int c=0; c<numOfCols; c++) {
                System.out.print( getFareByIndices(r,c) + "," );
            }
            System.out.println(); // next line
        }                         
    }

    
    /**
     * Act - do whatever the MTRManager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
