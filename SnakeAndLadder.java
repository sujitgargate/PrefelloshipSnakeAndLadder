import java.util.Random;

class UC4{

   //variable declaration and Constants
   int currentPosition = 0;
   int diceResult = 0;
   int WINNINGPOSITION = 100;

   public static void main(String args[]){

      UC4 obj = new UC4();
      System.out.println("Player is at Position : " + obj.checkOptions());
   }

   //dieRoll() method will act as Thrown physical dice

   public int dieRoll(int rollLimit){
      Random rand = new Random();
      int diceRoll = (rand.nextInt(rollLimit)) + 1;
      return diceRoll;
   }

   public int checkOptions(){

      //Here Player wont stop untill it's current Position is 100

      while(currentPosition < WINNINGPOSITION){
         int checkOptionsForPlay = dieRoll(3);

         switch(checkOptionsForPlay){
            case 1:
               System.out.println("\nNo play and Current Position is " + currentPosition);
            break;

            case 2:
               diceResult = dieRoll(6);

               //Check if Player's position is less or equal to 0, then position=0
               if(currentPosition <= diceResult){
                  currentPosition = 0;
                  System.out.println("\nYou got Snake with dice face of " + diceResult + " and Current Position is " + currentPosition);
               }
               else{
                  currentPosition -= diceResult;
                  System.out.println("\nYou got Snake with dice face of " + diceResult + " and Current Position is " + currentPosition);
               }
            break;

            case 3:
               diceResult = dieRoll(6);
               currentPosition += diceResult;
               System.out.println("\nYou got Ladder with dice face of " + diceResult + " and Current Position is " + currentPosition);
            break;
         }
      }
      return currentPosition;
   }
}


