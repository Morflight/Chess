package business;

public class King extends Piece {

	private boolean isChecked;
	
	@Override
	public boolean isMovable(Box startBox, Box endBox) {
		int relativeX;
		int relativeY;
		
		
		if (startBox == null) {
			return true;
		}
		
		relativeX = endBox.getX() - startBox.getY();
		relativeY = endBox.getY() - startBox.getY();
		
		if (Math.abs(relativeX) <= 1 || Math.abs(relativeY) <= 1) {
			setHasMoved(true);
			return true;
		}
		
		return false;
	}

	
	public boolean isChecked() {
		return isChecked;
	}
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	
	@Override
	public String toString() {
		return "" + (char) (0x2654 + getColor().getUtf8CodeMarker());
	}

}
