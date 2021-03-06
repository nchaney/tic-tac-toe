package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	
	private TicTacToe match;
	
	@Test
	public void testInitialBoardIsEmpty() {
		TicTacToe match = new TicTacToe();
		boolean isEmpty = true;
		for (int row = 0; row < 3; row++){
			for (int column = 0; column < 3; column++){
				if (match.board[row][column] != TicTacToe.mark.EMPTY){
					isEmpty = false;
				}
			}
		}
		assertTrue(isEmpty);
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		TicTacToe match = new TicTacToe();
		match.setMark(0, 2);
		assertEquals(TicTacToe.mark.XMARK, match.getMark(0,2));
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		TicTacToe match = new TicTacToe();
		//x plays frist matchset
		match.setMark(0,0);
		match.setMark(2, 0);
		assertEquals(TicTacToe.mark.OMARK, match.getMark(2, 0));
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		TicTacToe match = new TicTacToe();
		match.setMark(0,1);
		assertFalse(match.checkMark(0, 1));
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		TicTacToe match = new TicTacToe();
		boolean gameIsOver = true;
			if (!match.checkForTie() && match.checkForWin() == TicTacToe.mark.EMPTY){
				gameIsOver = false;
			}
		assertFalse(gameIsOver);
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		TicTacToe match = new TicTacToe();
		match.setMark(0,0);
		match.setMark(1,0);
		match.setMark(0,1);
		match.setMark(1,2);
		match.setMark(0,2);
		assertEquals(TicTacToe.mark.XMARK, match.checkForWin());
	}
	
	//@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		TicTacToe match = new TicTacToe();
		match.setMark(0,0);
		match.setMark(0,1);
		match.setMark(0,2);
		match.setMark(1,0);
		match.setMark(1,1);
		match.setMark(1,2);
		match.setMark(2,0);
		match.setMark(2,1);
		match.setMark(2,2);
		assertTrue(match.checkForTie());
	}	
}
