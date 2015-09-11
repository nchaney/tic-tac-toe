import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	private TicTacToe match = new TicTacToe();
	
	public void startNewGame() {
		match = new TicTacToe();
	}
	
	public void markLocation(int row, int col) {
		match.setMark(row,col,marker);
	}
	
	public String getMark(int row, int col) {
		if(match.getMark == TicTacToe.mark.XMARK) return "X";
		else if(match.getMark == TicTacToe.mark.OMARK) return "O";
		else return "";
	}
    
	public String getWinner() {
		if (match.checkForWin() == TicTacToe.mark.XMARK) return "X";
		else if (match.checkForWin() == TicTacToe.mark.OMARK) return "O";
		else if (match.checkForWin() == TicTacToe.mark.EMPTY) return "";
	}
}
