import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	private TicTacToe match = new TicTacToe();
	
	public void startNewGame() {
		match = new TicTacToe();
	}
	
	public void markLocation(int row, int col) {
		match.setMark(row,col,marker);
	}
	
	public String checkLocation(int row, int column, String token){
		return (match.getMark(row, col).toString());
	}
	
	public String getMark(int row, int col) {
		if(match.getMark(row, col) == TicTacToe.mark.XMARK) return "X";
		else if(match.getMark(row, col) == TicTacToe.mark.OMARK) return "O";
		else return "";
	}
    
	public String getWinner() {
		if (match.checkForWin() == TicTacToe.mark.XMARK) 
			return "X wins!";
		else if (match.checkForWin() == TicTacToe.mark.OMARK) 
			return "O wins!";
		else if (match.checkForWin() == TicTacToe.mark.EMPTY) 
			return "The Game Tied!";
		else
			return"Something went wrong....";
	}
}
