public class Die {
	private int numDots;
	
	public void roll() {
		numDots = 1 + (int)(6 * Math.random());
	}
	
	public int getNumDots() {
		return numDots;
	}
}