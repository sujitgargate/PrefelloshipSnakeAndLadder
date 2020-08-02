import java.util.Random;

class SnakeAndLadder{

    //variable declaration and Constants
    int player1CurrentPosition;
    int player2CurrentPosition;
    int diceResult = 0;
    public static final int WINNINGPOSITION = 100; //Made static so that it can be accessible from main()

    public static void main(String args[]){

        SnakeAndLadder obj = new SnakeAndLadder();

        //Player's position should be less than 100
        while (obj.player1Position() < 100 && obj.player2Position() < 100){
            obj.player1Position();
            obj.player2Position();
        }
    }

    //Finding player 1's Position
    public int player1Position(){

        player1CurrentPosition = checkOptions(player1CurrentPosition,1);
        return player1CurrentPosition;
    }

    //Finding player 1's Position
    public int player2Position(){
        player2CurrentPosition = checkOptions(player2CurrentPosition,2);
        return player2CurrentPosition;
    }

    //dieRoll() method will act as Thrown physical dice
    public int dieRoll(int rollLimit){
        Random rand = new Random();
        int diceRoll = (rand.nextInt(rollLimit)) + 1;
        return diceRoll;
    }

    //Check options() will determine whether there is play or no play
    public int checkOptions(int currentPosition, int player) {

            int checkOptionsForPlay = dieRoll(3);

            switch (checkOptionsForPlay) {
                //Case 1 is No Play
                case 1:
                    System.out.println("\nPlayer "+ player + " No play and Current Position is " + currentPosition);
                    break;

                // Case 2 is Snake Bite
                case 2:
                    diceResult = dieRoll(6);

                    //Check if Player's position is less or equal to 0, then position=0
                    if (currentPosition <= diceResult) {
                        currentPosition = 0;
                        System.out.println("\nPlayer "+ player + " got Snake with dice face of " + diceResult + " and Current Position is " + currentPosition);
                    } else {
                        currentPosition -= diceResult;
                        System.out.println("\nPlayer "+ player + " You got Snake with dice face of " + diceResult + " and Current Position is " + currentPosition);
                    }
                    break;

                //Case 3 is Ladder
                case 3:
                    diceResult = dieRoll(6);

                    //current Position + dice should not exceed winning position
                    if (currentPosition + diceResult > WINNINGPOSITION) {

                        //Dice roll Should result into exact number to Winning Position
                        while (currentPosition + diceResult == WINNINGPOSITION) {
                            diceResult = dieRoll(6);
                            currentPosition += diceResult;
                        }
                        break;
                    } else {
                        currentPosition += diceResult;
                        System.out.println("\nPlayer " + player +" got Ladder with dice face of " + diceResult + " and Current Position is " + currentPosition);

                        //Checking Each Player's position which should be below Winning Position
                        if(currentPosition == WINNINGPOSITION){
                            System.out.println("\nPlayer "+ player + " won");
                        }
                        break;
                    }
            }
        return currentPosition;

    }
}
