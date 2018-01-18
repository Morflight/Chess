package business;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class MainActivity {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		PrintStream out = new PrintStream(System.out, true, "UTF-8");
		int currentPlayer = 0;
		Game game = new Game();
		
		game.initializePlay();
		
		out.println(game.getChessboard());
		while (game.isInProgress()) {
			if (currentPlayer == 0) {
				game.turn(game.getPlayer1());
			} else {
				game.turn(game.getPlayer2());
			}
			
			out.flush();
			out.println(game.getChessboard());
			currentPlayer = (currentPlayer + 1) % Game.getNumberofplayers();
		
		
		
		
		}
		
	}
}
