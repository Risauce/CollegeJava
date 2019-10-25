package bowling;
import java.util.Random;

/* 
* Authors: Riley Roberts & Anna Jinneman 
*/

public class Frame {
      Random rand = new Random();
      int weighted[] = {0, 1, 2, 3, 4, 5, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10 , 10};
      int addition[] = new int[10];
      
      int result[]; //This holds all the roll values
      boolean frame11;
      
      int frameEleven[] = new int[2];
    
    public void Frame(int[] input)
    {
        weighted = input;
    }
 
    // --------------------------------------------------------------------------------------------
    
    public void play()
    {
        int every2 = 0; //We could use i%2 == 0 instead, but this worked better
        
        
        
        this.getRoll();
        
        int arrayTotal[] = addition; //Just make this one equal to other instead of changing all the arrayTotals to addition
        
        if (result[18] + result[19] == 10) {
            frame11 = true;
        }
        
        if (frame11) {
            System.out.println("+----Frame 1----+----Frame 2----+----Frame 3----+----Frame 4----+----Frame 5----+----Frame 6----+----Frame 7----+----Frame 8----+----Frame 9----+----Frame 10---+----Frame 11---+");
            System.out.print("+   ");
        }
        
        else{
            System.out.println("+----Frame 1----+----Frame 2----+----Frame 3----+----Frame 4----+----Frame 5----+----Frame 6----+----Frame 7----+----Frame 8----+----Frame 9----+----Frame 10---+---------------+");
            System.out.print("+   ");
        }
        
        
        
        for(int i=0; i<result.length; i++){
            every2 += 1;

            
            if (every2 == 2) {  //If it is the second number in a frame, it will print "+" instead of "|". This also is where we check for strikes
                if (result[i-1] == 10) {
                    System.out.print("    +   ");
                    every2 = 0;
                    continue;
                }
                
                if (result[i-1] + result[i] == 10) { //check for spares
                    System.out.print("S   +   ");
                    every2 = 0;
                    continue;
                }
                if (result[i] == 10) { // Will cause "10" to be printed as "X" instead.
                    System.out.print("X   +   ");
                }
                else{
                    System.out.print(result[i] + "   +   ");
                }
                every2 = 0;
            }
            else{
                if (result[i] == 10) { // Will cause "10" to be printed as "X" instead.
                    System.out.print("X   |   "); 
                }
                else{
                    System.out.print(result[i] + "   |   ");
                }
            }
        }
        
        //This is where to call frame11
        if (frame11) {
            frame11Method();
        }
        else
            System.out.print("            +");
        
        System.out.println("\n+---------------+---------------+---------------+---------------+---------------+---------------+---------------+---------------+---------------+---------------+---------------+");
        System.out.print("+       ");
        
        //Print the over-arching total by accessing an array that has each score. 
        for (int i = 0; i < arrayTotal.length; i++) {
            
            
            if (arrayTotal[i]<10) {
                System.out.print(arrayTotal[i]+ "       +       ");
            }
            else if(arrayTotal[i] > 99)
            {
                System.out.print(arrayTotal[i]+ "     +       ");
            }
            else{
                System.out.print(arrayTotal[i]+ "      +       ");
            }
            
        }
        System.out.print("        +");
        System.out.println("\n+---------------+---------------+---------------+---------------+---------------+---------------+---------------+---------------+---------------+---------------+---------------+\n\n");
    }
    
    // --------------------------------------------------------------------------------------------
    
    public void getRoll() //This method calculates the first and secondRoll values. 
    {
        
        
        int firstRoll;
        int secondRoll = 0;
        int every2 = 0;       
        int index;
        
        
        
        int total = 0;
        
        if (!frame11) {
             result = new int[20]; //The array to hold every score value for each frame. We will return this. 
        }
        else{
            result = new int[22];
        }
        
        
        for (int i = 0; i < result.length; i++) { //For each frame, there are two scores. 
            
            index = rand.nextInt(weighted.length); //Randomly chose, with weight, how many pins was knocked down on the first roll.
            
            every2+= 1; 
            firstRoll = weighted[index];
   
            int tester = ((10-firstRoll) + 1 ); //This +1 makes it so spares can be made.

            if (tester >0) { //Cant have a random number of 0 to 0...
                int secondIndex = rand.nextInt(tester);
                secondRoll = secondIndex;         
            }
            //else
                //secondRoll = 0;
            
        
            
            if (every2 == 2) { // This puts both the first and SecondRoll into the result arra at the same time. 
                result[i-1] = firstRoll; 
                result[i] = secondRoll;
                every2 = 0;
            }

        }
        boolean Strike = false;
        for (int i = 0; i < result.length; i++) { //In a totally separate for loop, calculate the running total and put each specific frames score in. 
        
        
            if (result[i] == 10) { //Test for strike
                    Strike = true;
                    try //Try blocks allow us to work around IndexOutOfRangeException-s. So we can get strikes/spares to work easier.
                    {
                        
                        if (result[i+2] == 10) { //This runs when we have two strikes in a row. 
                            try
                            {
                                total += 10 + 10 + result[i+4];
                            }
                            catch(ArrayIndexOutOfBoundsException asdfjf)
                            {
                                total += 10 + 10;
                            }
                            
                        }
                        else{
                            
                            total +=  (  result[i+2] + result[i+3]); //This is the most simple case, just one strike.
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e) //This is all simpler exceptions, usually only called when its frame 9 +
                    {
                        
                        try
                        {  
                            total += 10 + result[i+2]; 
                        }
                        catch(ArrayIndexOutOfBoundsException h)
                        {
                            total += 10;
                        }
                    }
                }
            
            

            else if (i%2 != 0) {
                
                 if((result[i] + result[i-1] == 10) && Strike != true){ // test for spare
                    try{
                        
                        total += 10 + result[i+1]; //Simple case, a spare is 10 + the next roll. 
                    }
                    catch(ArrayIndexOutOfBoundsException ieieie){ //This happens when spare is the last frame. 
                        total += 10;
                    }
                }
                else{
                    total += result[i] + result[i-1]; //Open Frame
            }
              
        }
            
            addition[i/2] = total;
            
        }
    }
    
// --------------------------------------------------------------------------------------------
    
    public void frame11Method() //This method only happens when an 11th frame occurs. It uses a whole new array and manipulates the addition array. 
    {
        int firstRoll;
        int secondRoll;
        
        int index;
        
        
        index = rand.nextInt(weighted.length);
        for (int i = 0; i < frameEleven.length; i++) { //Go through the two scores that can be in frame 11
            firstRoll = weighted[index];
            secondRoll = rand.nextInt((10-firstRoll) + 1);
            
            if (i%2 != 0) {
                frameEleven[i-1] = firstRoll;
                frameEleven[i] = secondRoll;
                
            }
            if (result[18] == 10) {
                addition[9] = ( addition[8] + 10 +firstRoll + secondRoll); //This happens if the last roll in frame 10 is a strike.
            }
            else if(result[18] + result[19] == 10){ //This happens if frame 10 was a spare. 
                addition[9] = ( addition[8] + 10 + firstRoll);
            }
        }
        
        for (int i = 0; i < frameEleven.length; i++) { //PRINT STUFF FOR FRAME 11
            
            if(i%2 != 0){
                
                if (frameEleven[i-1] == 10) {
                    System.out.print("    +   ");
                    continue;
                }
                
                if (frameEleven[i-1] + frameEleven[i] == 10) { //check for spares
                    System.out.print("S   +   ");
                    continue;
                }
            
                if (frameEleven[i] == 10) { // Will cause "10" to be printed as "X" instead.
                        System.out.print("X   +   ");
                }
                else{
                    System.out.print(frameEleven[i] + "   +   ");
                }
            }
            else{
                if (frameEleven[i] == 10) { // Will cause "10" to be printed as "X" instead.
                        System.out.print("X   |   ");
                }
                else{
                    System.out.print(frameEleven[i] + "   |   ");
                }
            }
            
        }
        
    }
    
}


