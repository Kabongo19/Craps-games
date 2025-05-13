public class BettingSystem {
    private int totalMoney;

    public BettingSystem(int startingMoney) {
        this.totalMoney = startingMoney;
    }

    public boolean placeBet(int betAmount) {
        if (betAmount > totalMoney) {
            System.out.println("Insufficient funds!");
            return false;
        }
        totalMoney -= betAmount;
        return true;
    }

    public void payout(boolean win, int betAmount) {
        if (win) {
            totalMoney += betAmount * 2; // Double the bet amount on win
        }
    }

    public int getTotalMoney() {
        return totalMoney;
    }
}