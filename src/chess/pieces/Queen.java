package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

	public Queen(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "Q";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// ↑ Direções verticais, horizontais e diagonais
		int[][] directions = { { -1, 0 }, // acima
				{ 1, 0 }, // abaixo
				{ 0, -1 }, // esquerda
				{ 0, 1 }, // direita
				{ -1, -1 }, // noroeste
				{ -1, 1 }, // nordeste
				{ 1, -1 }, // sudoeste
				{ 1, 1 } // sudeste
		};

		for (int[] dir : directions) {
			p.setValues(position.getRow() + dir[0], position.getColumn() + dir[1]);
			while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
				p.setValues(p.getRow() + dir[0], p.getColumn() + dir[1]);
			}
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}

		return mat;
	}
}
