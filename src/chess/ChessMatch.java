package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.Rook;
// classe que representa uma partida de xadrez
public class ChessMatch {
	// atributo que representa o tabuleiro de xadrez
	private Board board;
	// construtor que inicializa o tabuleiro de xadrez e configura a posição inicial das peças
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}
	// retorna uma matriz bidimensional com as peças do tabuleiro de xadrez
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	// executa um movimento de xadrez da posição de origem para a posição de destino
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		ChessPiece capturedPiece = makeMove(source, target);
		return capturedPiece; 
	}
	// valida se há uma peça na posição de origem
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}
	}
	// realiza o movimento da peça no tabuleiro de xadrez
	private ChessPiece makeMove(Position source, Position target) {
		ChessPiece p = (ChessPiece) board.removePiece(source);
		ChessPiece capturedPiece = (ChessPiece) board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}
	// coloca uma nova peça no tabuleiro de xadrez na coluna e linha especificadas 
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	// configuração inicial do tabuleiro de xadrez
	private void initialSetup(){
		// White pieces
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
		placeNewPiece('c', 2, new Rook(board, Color.WHITE));
		placeNewPiece('d', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 1, new Rook(board, Color.WHITE));
		placeNewPiece('d', 1, new Rook(board, Color.WHITE));
		
		// Black pieces
		placeNewPiece('c', 7, new Rook(board, Color.BLACK));
		placeNewPiece('c', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 8, new Rook(board, Color.BLACK));
				
}
	
	}
