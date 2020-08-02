import java.util.Random;

public class SnakeAndLadder{

   //variable declaration
   int currentPosition = 0;
   int diceResult = 0;

   public static void main(String args[]){
      SnakeAndLadder obj = new SnakeAndLadder();
      System.out.println("Player is at Position : "+ obj.checkOptions());
   }

   //dieRoll() method will act as Thrown physical dice
   public int dieRoll(int rollLimit){
      Random r = new Random();
      int diceRoll = (r.nextInt(rollLimit)) + 1;
      return diceRoll;
   }

   //checkOptionsForPlay will tell that player got snake, ladder or No play
   public int checkOptions(){

      int checkOptionsForPlay = dieRoll(3);

      switch(checkOptionsForPlay){

         case 1:
            System.out.println("No play");
         break;

         case 2:
            System.out.println("You got Snake");
            diceResult=dieRoll(6);
            currentPosition -= diceResult;
         break;

         case 3:
            System.out.println("You got Ladder");
            diceResult = dieRoll(6);
            currentPosition += diceResult;
         break;

      }
      return currentPosition;
   }
}
