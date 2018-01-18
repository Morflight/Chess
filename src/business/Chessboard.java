package business;

public class Chessboard {
	private static final int sizeX = 8;
	private static final int sizeY = 8;
	private Box[][] chessboard = new Box[sizeX][sizeY];

	
	public Chessboard() {
		initializeChessboard();
	}
	
	private void initializeChessboard() {
		for (int i=0; i < sizeY; i++) {
			for (int j = 0; j < sizeX; j++) {
				chessboard[i][j] = new Box(i, j);
			}
		}
	}
	
	public Box[][] getChessboard() {
		return chessboard;
	}
	public void setChessboard(Box[][] chessboard) {
		this.chessboard = chessboard;
	}
	
	@Override
	public String toString() {
		String display = "";
		
		char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
		
		display += "   ";
		for (int i=0; i < sizeX; i++) {
			display += " " + letters[i];
		}
		display += "\n\n";
		
		for (int i=sizeY; i > 0; i--) {
			display += i + "  ";
			for (int j=0; j < sizeX; j++) {
				display += " " + chessboard[j][i-1].toString();
			}
			display += "\n";
		}
		
		return display;
	}
}
