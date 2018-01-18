package business;

public class PlayerIA extends Player {

	public PlayerIA(Color c) {
		setName("IA");
		setWins(0);
		
		initializePieces(c);
	}
}
