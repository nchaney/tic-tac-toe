package edu.jsu.mcis;

public class TicTacToe {
	
	int xOrOCounter = 1;
	mark[][] board = new mark[3][3];
	
	public enum mark{XMARK, OMARK, EMPTY}
	
	public static void main(String[] args) {
		TicTacToe match = new TicTacToe();
	}
	
	
	
	public TicTacToe(){
		
		for(int row = 0; row < 3; row++){
			for(int column = 0; column <3; column++){
				board[row][column] = mark.EMPTY;
			}
		}
	}
	

	public void setMark(int row, int column){
		if(checkMark(row,column) != false){
			if(xOrOCounter %2 == 0){
				board[row][column]= mark.OMARK;
				xOrOCounter = xOrOCounter + 1;
			}
			else{
				board[row][column]= mark.XMARK;
				xOrOCounter = xOrOCounter + 1;
			}
			
		}
		
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
		//match wins across horizontally
		if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] != mark.EMPTY) {
			return board[0][0];
		}
		else if (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] != mark.EMPTY) {
			return board[1][0];
		}
		else if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] != mark.EMPTY) {
			return board[2][0];
		}
		//match wins down vertically
		else if (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] != mark.EMPTY) {
			return board[0][0];
		}
		else if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] != mark.EMPTY) {
			return board[0][1];
		}
		else if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] != mark.EMPTY) {
			return board[0][2];
		}
		//match wins diagnally
		else if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != mark.EMPTY) {
			return board[0][0];
		}
		else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != mark.EMPTY) {
			return board[0][2];
		}
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
		
}
