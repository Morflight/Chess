package business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
	private Player player1;
	private Player player2;
	private Chessboard chessboard;
	private List<Move> moves = new ArrayList<>();
	
	private boolean isInProgress;
	private final static int numberOfPlayers = 2;
	
	
	public Game() {
		player1 = new PlayerHuman(Color.WHITE);
		player2 = new PlayerIA(Color.BLACK);
		chessboard = new Chessboard();
		setInProgress(true);	
	}
	
	public void initializePlay() {
		registerPlayer();
		placePlayerPieces(player1, chessboard.getChessboard()[1][0]);
		placePlayerPieces(player2, chessboard.getChessboard()[7][6]);
		
	}
	
	public Player getCurrentPlayer(int id) {
		return (id == 0) ? player1 : player2; 
	}
	
	private Box askPlayer(String ask) {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		String userInput;
		
		System.out.println(ask);
		
		while (true) {
			try {
				userInput = buff.readLine();
				verifyUserInputFormat(userInput);
				break;
			} catch (IOException | IndexOutOfBoundsException | InvalidBoxFormatException e) {
				e.printStackTrace();
			}
		}
		
		return chessboard.getChessboard()[userInput.toUpperCase().charAt(0) - 'A']
				[userInput.substring(1, 2).charAt(0) - '1'];
	}
	
	private void verifyUserInputFormat(String userInput) throws InvalidBoxFormatException {
		Pattern p = Pattern.compile("[A-Ha-h][0-8]");
		Matcher m = p.matcher(userInput);
		
		if (!m.matches()) {
			throw new InvalidBoxFormatException(String.format("%s is not a valid box format", userInput));
		}
		
	}

	public void turn(Player player) {
		Box begin;
		Box end;
		Move currentMove;
		
		do {
			begin = askPlayer("Choisissez votre pièce :");
		} while (!player.getPieces().contains(begin.getPiece()));
		
		do {
			end = askPlayer("Où voulez-vous la déplacer ?");
			currentMove = new Move(begin, end);
		} while (!currentMove.isPossible());
		
		moves.add(currentMove);
		movePieceToBox(begin.getPiece(), begin, end);
	}

	private void movePieceToBox(Piece piece, Box startBox, Box endBox) {
		if (startBox != null) {
			startBox.setPiece(null);
		}
		
		endBox.setPiece(piece);
	}
	
	private void placePlayerPieces(Player player, Box initialBox) {
		List<Piece> pieces = player.getPieces();
		
		for (Piece p : pieces) {
			movePieceToBox(p, null, chessboard.getChessboard()
					[pieces.indexOf(p) % 8][initialBox.getY() + (pieces.indexOf(p) / 8)]);
		}
	}
	
	private void registerPlayer() {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Entrez le nom du joueur 1 :");
		
		while (true) {
			try {
				player1.setName(buff.readLine());
				break;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public Player getPlayer1() {
		return player1;
	}
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	public Chessboard getChessboard() {
		return chessboard;
	}
	public void setChessboard(Chessboard chessboard) {
		this.chessboard = chessboard;
	}
	public List<Move> getMoves() {
		return moves;
	}
	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}
	public boolean isInProgress() {
		return isInProgress;
	}
	public void setInProgress(boolean isInProgress) {
		this.isInProgress = isInProgress;
	}
	public static int getNumberofplayers() {
		return numberOfPlayers;
	}
}
