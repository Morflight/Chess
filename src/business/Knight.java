package business;

public class Knight extends Piece {

	@Override
	public boolean isMovable(Box startBox, Box endBox) {
		int relativeX;
		int relativeY;
		
		
		if (startBox == null) {
			return true;
		}
		
		relativeX = endBox.getX() - startBox.getX();
		relativeY = endBox.getY() - startBox.getY();

		if ((Math.abs(relativeX) == 2 && Math.abs(relativeY) == 1)
				|| Math.abs(relativeX) == 1 && Math.abs(relativeY) == 2) {
			return true;
		}
		
		return false;
	}
	
	public String toString() {
		return "" + (char) (0x2658 + getColor().getUtf8CodeMarker());
	}
	
}
