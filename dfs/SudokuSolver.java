package dfs;

public class SudokuSolver {

	public void solveSudoku(char[][] board) {
        solve(board);
    }
	
    public boolean solve(char[][]board){
    	for(int i = 0; i < 9; i++) {
    		for(int j = 0; j < 9; j++) {
    			if(board[i][j] == '.') {
    				for(char num = '1'; num <= '9'; num++) {
    					if(isValid(board, i, j, num)) {
    						board[i][j] = num;
    						if(solve(board)) {
    							return true;
    						}else {
    							board[i][j] = '.';
    						}
    					}
    				}
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char ch) {
    	for(int i = 0; i < 9; i++) {
    		if(board[row][i] == ch) {
    			return false;
    		}
    		if(board[i][col] == ch) {
    			return false;
    		}
    	}
    	int r = row - row % 3;
    	int c = col - col % 3;
    	for(int i = r; i < r + 3; i++) {
    		for(int j = c; j < c + 3; j++) {
    			if(board[i][j] == ch) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
	
}
