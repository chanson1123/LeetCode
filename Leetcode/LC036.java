package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC036 {
	public boolean isValidSudoku(char[][] board) {
		//row & column
		for(int i=0; i<9; i++) {
			Set<Character> rowSet = new HashSet<>();
			Set<Character> columnSet = new HashSet<>();
			for(int j=0; j<9; j++) {
				if(rowSet.contains(board[i][j])) {
					return false;
				}
				if(columnSet.contains(board[j][i])) {
					return false;
				}
				if(board[i][j] != '.') {
					rowSet.add(board[i][j]);
				}
				if(board[j][i] != '.') {
					columnSet.add(board[j][i]);
				}
			}
		}
		//grid
		for(int x=0; x<9; x+=3) {
			for(int y=0; y<9; y+=3) {
				Set<Character> gridSet = new HashSet<>();
				for(int i=x; i<x+3; i++) {
					for(int j=y; j<y+3; j++) {
						if(gridSet.contains(board[i][j])) {
							return false;
						}
						if(board[i][j] != '.') {
							gridSet.add(board[i][j]);
						}
					}
				}
			}
		}
		return true;
	}
}
