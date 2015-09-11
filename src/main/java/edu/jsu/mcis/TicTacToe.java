package edu.jsu.mcis;

public class TicTacToe {
	
	mark[][] board = new mark[3][3];
	
	public static void main(String[] args) {
		
	}
	public enum mark{XMARK, OMARK, EMPTY}
	
	
	public TicTacToe(){
		
		for(int row = 0; row < 3; row++){
			for(int column = 0; column <3; column++){
				board[row][column] = mark.EMPTY;
			}
		}
	}
	

	public void setMark(int row, int column, mark token){
		board[row][column] = token;
	}
	
	public mark getMark(int row, int column){
		return board[row][column];
	}
	
	public boolean checkMark (int row, int column){
		if(board[row][column] != mark.EMPTY){
			return false;
		}
		else
			return true;
	}
	
	public boolean isFull(){
		for (int row=0; row<3; row++){
			for(int column = 0; column <3; column++){
				if (board[row][column] == mark.EMPTY){
					return false;
					
				}
				
					
			}
		}
		return true;
	}
	public mark checkForWin () {
		//check to see if won horizontally
		if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] != mark.EMPTY) {
			return board[0][0];
		}
		else if (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] != mark.EMPTY) {
			return board[1][0];
		}
		else if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] != mark.EMPTY) {
			return board[2][0];
		}
		//check to see if won vertically
		else if (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] != mark.EMPTY) {
			return board[0][0];
		}
		else if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] != mark.EMPTY) {
			return board[0][1];
		}
		else if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] != mark.EMPTY) {
			return board[0][2];
		}
		//check to see if won diagnally
		else if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != mark.EMPTY) {
			return board[0][0];
		}
		else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != mark.EMPTY) {
			return board[0][2];
		}
		//return empty, game has not been won yet
		else {
			return mark.EMPTY;
		}
	}
	public boolean checkForTie(){
		if (isFull() == true && checkForWin() == mark.EMPTY){
			return true;
		}
		return false;
	}
	public void resetBoard(){
		for(int row = 0; row<3; row++){
			for (int column = 0; column <3; column++){
				board[row][column] = mark.EMPTY;
				
			}
		}
		
	}	
}
