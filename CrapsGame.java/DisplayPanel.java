public class DisplayPanel {
    private int totalMoney;
    private int currentBet;
    private int winCount;
    private int lossCount;

    public DisplayPanel(int initialMoney) {
        this.totalMoney = initialMoney;
        this.currentBet = 0;
        this.winCount = 0;
        this.lossCount = 0;
    }

    public void setCurrentBet(int bet) {
        this.currentBet = bet;
    }

    public void updateTotalMoney(int money) {
        this.totalMoney = money;
    }

    public void incrementWinCounter() {
        this.winCount++;
    }

    public void incrementLossCounter() {
        this.lossCount++;
    }

    public void displayStats() {
        System.out.println("Total Money: $" + totalMoney);
        System.out.println("Current Bet: $" + currentBet);
        System.out.println("Wins: " + winCount);
        System.out.println("Losses: " + lossCount);
    }
}