package chess;

import boardgame.Piece;

public abstract class ChessPiece  extends Piece {

	private Color color;
	
	public ChessPiece(boardgame.Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

}
