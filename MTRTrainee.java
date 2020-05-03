import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MTRTrainee here.
 * 
 * MTRTrainee is hired as the trainee of the Hang Hau MTR station. 
 * He knows the fare from Hang Hau to all other stations
 * 
 * (In this example, we only have 4 MTR stations: 
 *  Hang Hau, Choi Hung, Mongkok and Central)
 *  
 * Implementation notes:
 * 
 * We use 1D array to store all the fares from Hang Hau MTR station
 * 
 * @author Peter
 * @version  1.0
 */
public class MTRTrainee extends Actor {

    // Default constants of the MTR stations
    public static final int HangHau = 0;
    public static final int ChoiHung = 1;
    public static final int Mongkok = 2;
    public static final int Central = 3;
    
    /**
     * Look up the stations by the input index
     */
    public String lookupStation(int index) {        
        String stationName; 
        switch (index) {
            case HangHau: stationName = "HangHau"; break;
            case ChoiHung: stationName = "ChoiHung"; break;
            case Mongkok: stationName = "Mongkok"; break;
            case Central: stationName = "Central"; break;
            default: stationName = "Invalid station index";
        }
        return stationName;
    }
        

    // An 1D array instance variable
    private double [] fareFromHangHau  ;    
    
    /**
     * Initialize the fares from the Hang Hau MTR station
     * Assume that we only have 4 MTR stations:
     *    HangHau(0), ChoiHung(1), Mongkok(2) and Central(3)
     */
    public void initalizeFareFromHangHau() {        
        // Assume that we only have 4 MTR stations
        fareFromHangHau = new double[4];        
        fareFromHangHau[0] = 4.0; // HangHau => HangHau
        fareFromHangHau[1] = 7.5; // HangHau => ChoiHung
        fareFromHangHau[2] = 8.5; // HangHau => Mongkok
        fareFromHangHau[3] = 12.0; // HangHau => Central        
    }
    
    /**
     * Get the fare of the MTR based on the index
     * Return -1.0 if the index is invalid
     */
    public double getFareByIndex(int index) {
        
        // invalid index
        if ( index < 0 ) 
            return -1.0; 
        // invalid index    
        if ( index >= fareFromHangHau.length )
            return -1.0;
            
        return fareFromHangHau[index];
    }
    
    
    /**
     * An example of traversing an array
     * Each fare is reduced by an half,
     * A for loop is used in this example
     */    
    public void reduceFareByHalf() {
                
        for (int i=0; i< fareFromHangHau.length; i++) {
                        
            fareFromHangHau[i] = fareFromHangHau[i]/2.0;
        }
    }
    
    
    /**
     * An example of traversing an array
     * Shifting elements to left by 1 position except
     * the first element becomes the last element
     */
    public void shiftingElementsToLeft() {
        // Retain the first element
        double firstFare = fareFromHangHau[0];
        // Shift elements left
        for (int i=0; i< fareFromHangHau.length-1; i++ ) {            
            fareFromHangHau[i] = fareFromHangHau[i+1];
        }
        // Fill in the last position with the first fare
        fareFromHangHau[fareFromHangHau.length-1] = firstFare;
    }
    
    
   /**
    * An example of traversing an array
    *  and find the largest element
    */
   public double findMaxFare(){           
       double max =  fareFromHangHau[0];
       for (int i=1; i< fareFromHangHau.length; i++) {
          
          if( fareFromHangHau[i] > max)
              max = fareFromHangHau[i] ;
       }
       return max;
   }
   
   /**
    * An example of traversing an array
    *  and find the smallest element
    */
   public double findMinFare(){

       int minIndex =  0;
       for (int i=1; i< fareFromHangHau.length; i++) {

          if( fareFromHangHau[i] <  fareFromHangHau[minIndex])
              minIndex = i;
       }
       return  fareFromHangHau[minIndex];
   }
    
    /**
    * An example of traversing an array
    *  and find the average
    * Return 0.0 if the length of an array is zero
    */
   public double computeAverageFare(){
       // Sum up all the numbers
       double sum =  0;
       for (int i=0; i< fareFromHangHau.length; i++) {
            sum += fareFromHangHau[i];
       }
       // Avoid division by zero
       if (fareFromHangHau.length != 0)
          return  sum/fareFromHangHau.length;
       else
          return 0.0;
   }
   
   /**
    * An example of traversing an array
    *  and looking for a first occurrence of 
    *  a certain element.
    *  if found return its index
    *  not found, return -1;
    */
   public int findAnElement(double num){
       final double EPSILON = 0.00001 ; // A small floating value       
       for (int i=0; i< fareFromHangHau.length; i++) {
           double diff = fareFromHangHau[i] - num ;
           // Convert the diff to a non-negative number
           if ( diff < 0.0 )
            diff = -diff ;
            // Return the index if the diff is less than ESPILON
            if (diff < EPSILON)
                 return i;
       }
       return  -1;
   }
   
   /**
    * returns an array of boolean indicating which stations 
    * one can travel with a given amount of money
    */
   private boolean[] findStations(double inputAmount) {
       // get the length of the "fareFromHangHau"
       int size = fareFromHangHau.length;
       // create a new array of boolean 
       boolean[] result = new boolean[size];
       // A for loop is used to compute the result
       for (int i=0; i<size; i++)
        if ( inputAmount >= fareFromHangHau[i] )
            result[i] = true;
        else 
            result[i] = false;          
       return result; // returns an array of boolean
   }
   
   /**
    * Prints out the indices of the stations one can  
    * travel with a given amount of money
    */
   public void printFindStations(double inputAmount) {
       // Using a method with an array as a return type
       boolean[] stations = findStations(inputAmount);
       System.out.println("The indices of stations are: ");
       for ( int i=0; i<stations.length; i++) {
        if ( stations[i] )
            System.out.print(i + ", ");
       } // end of the for loop
       System.out.println(); // move to the next line 
       // print all the fares from HangHau 
       printFaresFromHangHau(); 
   }
   
   
    /**
     * An advanced example:
    *  Create 6 random numbers for Mark6.
    */
   public void mark6(){
       int[] numbers = new int[6];
       int randomNumber;
       boolean repeat;
       System.out.println("Random Mark 6 numbers:");
       for (int i = 0; i < numbers.length; i++){
           randomNumber = Greenfoot.getRandomNumber(48) + 1;
           repeat = false;
           for (int j = 0; j<i; j++){
               if (randomNumber == numbers[j]){
                  repeat = true;
                  break;
               }
           }
           if (repeat)
               i--;
           else
               numbers[i] = randomNumber;
           }
           for (int i = 0; i < numbers.length; i++)
              System.out.println(numbers[i]);
   } // end of mark6()
   
    /**
     * An example of traversing an array
     * Print all the fares from Hang Hau station
     */
    public void printFaresFromHangHau() {        
        // Print the subtitle
        System.out.print("Fare from Hang Hau: ");
        for (int i=0; i< fareFromHangHau.length; i++ ) {
            // Print the ith fare, separated by a comma
            System.out.print(fareFromHangHau[i] + ", ");            
        }
        System.out.println(); // move to a new line        
    }

    

    /**
     * Act - do whatever the MTRTrainee wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
