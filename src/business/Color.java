package business;

public enum Color {
	BLACK(0, -1),
	WHITE(6, 1);
	
	int utf8CodeMarker;
	int colorMult;
	
	Color(int utf8CodeMarker, int colorMult) {
		this.utf8CodeMarker = utf8CodeMarker;
		this.colorMult = colorMult;
	}
	
	public int getUtf8CodeMarker() {
		return utf8CodeMarker;
	}
	
	public int getColorMult() {
		return colorMult;
	}
	
	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
}
