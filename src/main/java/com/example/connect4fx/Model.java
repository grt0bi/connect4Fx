package com.example.connect4fx;

public class Model {
    private int rows= 6;
    private int cols= 7;

    private int[][] board;
    private int currentPlayer;

    public Model() {
        this.rows = 6; // Define the number of rows
        this.cols = 7; // Define the number of columns
        this.board = new int[rows][cols]; // Initialize the game board
        this.currentPlayer = 1; // Initialize the current player
    }

    public boolean makeMove(int column) {
        for (int row = rows - 1; row >= 0; row--) {
            if (board[row][column] == 0) {
                board[row][column] = currentPlayer;
                return true;
            }
        }
        return false; // Column is full
    }

    public boolean isWin() {
        // Check for a win condition (four in a row)
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int player = board[row][col];
                if (player != 0) {
                    // Check horizontally
                    if (col + 3 < cols &&
                            player == board[row][col + 1] &&
                            player == board[row][col + 2] &&
                            player == board[row][col + 3]) {
                        return true;
                    }

                    // Check vertically
                    if (row + 3 < rows &&
                            player == board[row + 1][col] &&
                            player == board[row + 2][col] &&
                            player == board[row + 3][col]) {
                        return true;
                    }

                    // Check diagonally (from top-left to bottom-right)
                    if (row + 3 < rows && col + 3 < cols &&
                            player == board[row + 1][col + 1] &&
                            player == board[row + 2][col + 2] &&
                            player == board[row + 3][col + 3]) {
                        return true;
                    }

                    // Check diagonally (from top-right to bottom-left)
                    if (row + 3 < rows && col - 3 >= 0 &&
                            player == board[row + 1][col - 1] &&
                            player == board[row + 2][col - 2] &&
                            player == board[row + 3][col - 3]) {
                        return true;
                    }
                }
            }
        }

        return false; // No win condition found
    }

    public boolean isDraw() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 0) {
                    return false; // There's an empty cell, the game is not a draw
                }
            }
        }
        return true; // All cells are filled, it's a draw
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 1) ? 2 : 1;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public int[][] getBoard() {
        return board;
    }

}
