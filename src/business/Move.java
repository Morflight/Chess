package business;

public class Move {
	private Box boxStart;
	private Box boxEnd;
	
	public Move(Box boxStart, Box boxEnd) {
		this.boxStart = boxStart;
		this.boxEnd = boxEnd;
	}
	
	public boolean isPossible() {
		boolean moveVerification = boxStart.getPiece().isMovable(boxStart, boxEnd);
		
		if (boxEnd.getPiece() == null) {
			return moveVerification;
		}
		
		if (boxStart.getPiece().getColor() == boxEnd.getPiece().getColor()) {
			return false;
		}
		
		return moveVerification;
	}
	
	public Box getBoxStart() {
		return boxStart;
	}
	public void setBoxStart(Box boxStart) {
		this.boxStart = boxStart;
	}
	public Box getBoxEnd() {
		return boxEnd;
	}
	public void setBoxEnd(Box boxEnd) {
		this.boxEnd = boxEnd;
	}
	
	@Override
	public String toString() {
		return String.format("%s -> %s", boxStart.toString(), boxEnd.toString());
	}
}
