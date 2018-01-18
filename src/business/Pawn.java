package business;

public class Pawn extends Piece {

	@Override
	public boolean isMovable(Box startBox, Box endBox) {
		int relativeX;
		int relativeY;
		boolean hasEndBoxPiece;
		
		if (startBox == null) {
			return true;
		}
		
		relativeX = endBox.getX() - startBox.getX();
		relativeY = (endBox.getY() - startBox.getY()) * startBox.getPiece().getColor().getColorMult();
		hasEndBoxPiece = !(endBox.getPiece() == null);
		
		// Déplacement typique du pion et attaque
		if (relativeY == 1) {
			if (relativeX == 0 && !hasEndBoxPiece) {
				setHasMoved(true);
				return true;
			}
			if (relativeX == Math.abs(1) && hasEndBoxPiece) {
				setHasMoved(true);
				return true;
			}
		}
		// Premier déplacement du pion
		if (relativeY == 2 && relativeX == 0 && !hasMoved() && !hasEndBoxPiece) {
			setHasMoved(true);
			return true;
		}
		
		return false;
	}
	
	public void promote() {
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + (char) (0x2659 + getColor().getUtf8CodeMarker());
	}
}
