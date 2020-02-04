/**
 * @Author: Panagiotis Dimitropoulos
 * @Purpose: Creating Dice class
 * @Date: 28/10/19
 */

import java.util.Random;

public class Dice
{
     private Random generator;
     private int sides;
     private int value;

     //param noSides integer of the number of faces on the new dice
      
     public Dice(int noSides)
     {
         generator = new Random();
		   sides = noSides;
         value = 1 + generator.nextInt(sides);
     }

     	//return an integer value of the new die face
      
     public int throwDice()
     {        
         value = 1 + generator.nextInt(sides);
			return value;
     }
     
     
      //return an integer value of dice
      
     public int getValue()
     {
          return value;
     }
     
	  // Use for program testing
	  public void setValue(int v)
	  {
		  value = v;
	  }	

}
