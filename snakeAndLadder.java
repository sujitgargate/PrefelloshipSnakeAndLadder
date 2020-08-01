import java.util.Random;

class snakeAndLadder{
	Random rand = new Random();

	//variable declaration
	public static void main(String args[]){

		snakeAndLadder obj=new snakeAndLadder();
		System.out.println("Thrown Dice Got : "+obj.dieRoll());
	}

	//dieRoll() method will act as Thrown dice
	public int dieRoll(){
		int diceRoll = (rand.nextInt(6))+1;
		return diceRoll;
	}

}

