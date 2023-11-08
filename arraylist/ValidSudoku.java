package arraylist;

public class ValidSudoku {

	public static void main(String[] args) {
	}
	
	public boolean isValidSudoku(char[][] board) {
		//check row
		for(int row = 0; row < 9; row++) {
			if(!isValidRow(board, row)) {
				return false;
			}
		}
		
		//check column
		for(int col = 0; col < 9; col++) {
			if(!isValidCol(board, col)) {
				return false;
			}
		}
		
		//check sub-grid
		for(int row = 0; row < 9; row += 3) {
			for(int col = 0; col < 9; col += 3) {
				if(!isValidSubGrid(board, row, col)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private boolean isValidSubGrid(char[][] board, int startRow, int startCol) {
		boolean[] seen = new boolean[9];
		for(int row = startRow; row < startRow + 3; row++) {
			for(int col = startCol; col < startCol + 3; col++) {
				if(board[row][col] != '.') {
					if(seen[(board[row][col] - '1')]) {
						return false;
					}
					seen[board[row][col] - '1'] = true;
				}
			}
		}
		return true;
	}
	
	private boolean isValidCol(char[][] board, int col) {
		boolean[] seen = new boolean[9];
		for(int row = 0; row < 9; row++) {
			if(board[row][col] != '.') {
				if(seen[(board[row][col] - '1')]) {
					return false;
				}
				seen[(board[row][col] - '1')] = true;
			}
		}
		return true;
	}
	
	private boolean isValidRow(char[][] board, int row) {
		boolean[] seen = new boolean[9];
		for(int col = 0; col < 9; col++) {
			if(board[row][col] != '.') {
				if(seen[(board[row][col] - '1')]) {
					return false;
				}
				seen[(board[row][col] - '1')] = true;
			}
		}
		return true;
	}
	
}
