package business;

public class Rook extends Piece {

	@Override
	public boolean isMovable(Box startBox, Box endBox) {
		int relativeX;
		int relativeY;
		
		
		if (startBox == null) {
			return true;
		}
		
		relativeX = endBox.getX() - startBox.getY();
		relativeY = endBox.getY() - startBox.getY();
		
		if (!(((relativeX == 0) && (relativeY != 0)) || ((relativeX != 0) && (relativeY == 0)))) {
			return false;
		}
			
		return true;
	}

	@Override
	public String toString() {
		return "" + (char) (0x2656 + getColor().getUtf8CodeMarker());
	}
}
