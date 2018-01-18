package business;

public class Box {
	private int x;
	private int y;
	private Piece piece;
	private Color color;
	
	public Box(int x, int y) {
		this.x = x;
		this.y = y;
		if ((x + y) % 2 == 0) {
			color = Color.BLACK;
		} else {
			color = Color.WHITE;
		}
	}
	
	public Box(char x, int y) {
		this(x - 'A', y);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Piece getPiece() {
		return piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color c) {
		this.color = c;
	}
	
	@Override
	public String toString() {
		if(piece == null) {
			return ".";
		} else {
			return piece.toString() + " ";
		}
	}

}
