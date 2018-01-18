package business;

public class Bishop extends Piece {

	@Override
	public boolean isMovable(Box startBox, Box endBox) {
		int relativeX;
		int relativeY;
		
		
		if (startBox == null) {
			return true;
		}
		
		relativeX = endBox.getX() - startBox.getX();
		relativeY = endBox.getY() - startBox.getY();

		if (Math.abs(relativeX) == Math.abs(relativeY)) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + (char) (0x2657 + getColor().getUtf8CodeMarker());
	}

}
