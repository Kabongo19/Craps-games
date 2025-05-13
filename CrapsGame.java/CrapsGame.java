// Implements the game of Craps logic
public class CrapsGame
{
 private int point = 0;
 /**
  *  Calculates the result of the next dice roll in the Craps game.
  *  The parameter total is the sum of dots on two dice.
  *  point is set to the saved total, if the game continues,
  *  or 0, if the game has ended.
  *  Returns 1 if player won, -1 if player lost,
  *  0 if player continues rolling.
  */
 public int processRoll(int total){
	  int result;
	 
	  if (point == 0) {
		  if(total == 7 || total == 11)
			  result = 1;
		  	else if (total == 2 || total == 3 || total == 12)
			  result = -1;
		  	else {
			  result = 0;
			  point = total;
		  	}
	  	}
	  else
	  {
		  if (total == point) {
			  result = 1;
			  point = 0;
		  }
		  else if (total == 7) {
			result = -1;
			point = 0;
		  }
		  else
			  result = 0;
	  }
	return result;
 }
 /**
  *  Returns the saved point
  */
 public int getPoint()
 {
   return point;
 }


    private BettingSystem bettingSystem;
    private DisplayPanel displayPanel;

    public CrapsGame(int startingMoney) {
        bettingSystem = new BettingSystem(startingMoney);
        displayPanel = new DisplayPanel(startingMoney);
    }

    public void playRound(int betAmount) {
        // Place the bet
        if (!bettingSystem.placeBet(betAmount)) {
            System.out.println("Unable to place bet.");
            return;
        }
        displayPanel.setCurrentBet(betAmount);

        boolean win = rollDiceAndCheckWin(); // Determine the win/loss of the round

        // Payout based on result
        bettingSystem.payout(win, betAmount);
        displayPanel.updateTotalMoney(bettingSystem.getTotalMoney());
        
        if (win) {
            displayPanel.incrementWinCounter();
        } else {
            displayPanel.incrementLossCounter();
        }

        displayPanel.displayStats();
    }
}