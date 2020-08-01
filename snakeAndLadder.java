import java.util.Random;
class snakeAndLadder{
	Random rand = new Random();

	//variable declaration and Constants
	int currentPosition=0;
	int diceResult=0;
	int WINNINGPOSITION=100;

	public static void main(String args[]){

		snakeAndLadder obj=new snakeAndLadder();
		System.out.println("Player is at Position : "+obj.checkOptions());
	}

	//dieRoll() method will act as Thrown dice
	public int dieRoll(){
		int diceRoll = (rand.nextInt(6))+1;
		return diceRoll;
	}

	public int checkOptions(){
		//Here Player wont stop untill it's current Position is 100
		while(currentPosition!= WINNINGPOSITION){

			//checkOptionsForPlay will tell that player got snake, ladder or No play
			int checkOptionsForPlay = (rand.nextInt(3)); 
			if(checkOptionsForPlay==0){
				System.out.println("No play and Current Positio is "+currentPosition);

			}else if(checkOptionsForPlay==1){
				System.out.println("You got Snake and Current Positio is "+currentPosition);
				diceResult=dieRoll();

				//Check if Player's position is less or equal to 0, then position=0
				if(currentPosition<=diceResult){
					currentPosition=0;
				}else{
					currentPosition-=diceResult;
				}
			}else{
				System.out.println("You got Ladder and Current Positio is "+currentPosition);
				diceResult=dieRoll();
				currentPosition+=diceResult;
			}
		}
		return currentPosition;
	}
}


