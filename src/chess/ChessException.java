package chess;

import boardgame.BoardExeception;

public class ChessException  extends BoardExeception {

	private static final long serialVersionUID = 1L; 
	
	public ChessException(String msg) {
		super(msg);
	}

}
