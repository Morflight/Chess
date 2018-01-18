package business;

import java.util.Collections;

public class PlayerHuman extends Player {
	
	public PlayerHuman(Color c) {
		setName("");
		setWins(0);
		
		initializePieces(c);

		Collections.reverse(getPieces());
	}
	
}
