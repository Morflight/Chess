package business;

public class Queen extends Piece {

	@Override
	public boolean isMovable(Box startBox, Box endBox) {
		int relativeX;
		int relativeY;
		
		
		if (startBox == null) {
			return true;
		}
		
		relativeX = endBox.getX() - startBox.getY();
		relativeY = endBox.getY() - startBox.getY();
		
		if (Math.abs(relativeX) == Math.abs(relativeY)) {
			return true;
		}
		
		if (((relativeX == 0) && (relativeY != 0)) || ((relativeX != 0) && (relativeY == 0))) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + (char) (0x2655 + getColor().getUtf8CodeMarker());
	}

}
