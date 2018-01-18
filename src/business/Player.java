package business;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
	private String name;
	private int wins;
	private List<Piece> pieces = new ArrayList<>();
	
	
	protected void initializePieces(Color c) {
		for (int i=0; i < 8; i++) pieces.add(new Pawn());
		pieces.add(new Rook());
		pieces.add(new Knight());
		pieces.add(new Bishop());

		pieces.add(new Queen());
		pieces.add(new King());
		
		pieces.add(new Bishop());
		pieces.add(new Knight());
		pieces.add(new Rook());
		
		for (Piece p : pieces) p.setColor(c);
	}
	
	public Box selectBox(int xAxis, int yAxis) {
		return new Box(xAxis, yAxis);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public List<Piece> getPieces() {
		return pieces;
	}
	public void setPieces(List<Piece> pieces) {
		this.pieces = pieces;
	}
}
