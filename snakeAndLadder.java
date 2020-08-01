import java.util.Random;
class snakeAndLadder{
	Random rand = new Random();

	//variable declaration
	int currentPosition=0;
	int diceResult=0;
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
		//checkOptionsForPlay will tell that player got snake, ladder or No play
		int checkOptionsForPlay = (rand.nextInt(3)); 
		if(checkOptionsForPlay==0){
			System.out.println("No play");

		}else if(checkOptionsForPlay==1){
			System.out.println("You got Snake");
			diceResult=dieRoll();

			//Check if position is less or equal then position=0
			if(currentPosition<=diceResult){
				return currentPosition=0;
			}else{
				currentPosition-=diceResult;
			}
		}else{
			System.out.println("You got Ladder");
			diceResult=dieRoll();
			currentPosition+=diceResult;
		}
		return currentPosition;
	}
}

