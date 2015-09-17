package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameBoard extends JFrame {
  
  private JButton[][] button = new JButton[3][3];

  TicTacToe matchBoard = new TicTacToe();

  public GameBoard() {
    setupBoard();
  }

  public static void main(String[] args) {
    GameBoard gameBoard = new GameBoard();
  }

  private void setupBoard() {
    JFrame mainBoard = new JFrame("Tic-Tac-Toe");
    mainBoard.setSize(400,400);
    mainBoard.setLayout(new GridLayout(3, 3));
    mainBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    int place = 1;
    for (int row = 0; row < 3; row++) {
      for (int column = 0; column < 3; column++) {
        button[row][column] = new JButton("");
        button[row][column].setName(Integer.toString(place));
        button[row][column].addActionListener(new ButtonListener(row, column));
        button[row][column].setFont(new Font("", Font.PLAIN, 72));
        button[row][column].setBorderPainted(false);
        mainBoard.add(button[row][column]);
        place+= 1;
      }
    }
    mainBoard.setVisible(true);
  }

  private class ButtonListener implements ActionListener {
    private int row;
    private int col;

    public ButtonListener(int r, int c) {
      row = r;
      col = c;
    }

    public void actionPerformed(ActionEvent e) {
      buttonPress(row, col);
    }
  }

  public void buttonPress (int row, int col){
    matchBoard.setMark(row, col);
      if (matchBoard.getMark(row, col) == TicTacToe.mark.XMARK){
        button[row][col].setLabel("X");
      }
      else if (matchBoard.getMark(row, col) == TicTacToe.mark.OMARK){
        button[row][col].setLabel("O");
      }
    if (matchBoard.checkForWin() == TicTacToe.mark.XMARK){
        ActionListener taskPerformer = new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "X is winner!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
          }
        };
    }
    else if (matchBoard.checkForWin() == TicTacToe.mark.OMARK){
        ActionListener taskPerformer = new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "O is winner!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
          }
        };
    }
    if (matchBoard.checkForTie()) {
        ActionListener taskPerformer = new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "It's A Tie!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
          }
        };
    }
  }
}
