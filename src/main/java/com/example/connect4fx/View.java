package com.example.connect4fx;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Application;
import java.util.Scanner;

public class View extends Application{
    public View(){
        this.controller = new Controller(new Model(), this);
    }

    private Controller controller;
    private GridPane gameBoard;
    private GridPane createGameBoard() {
        GridPane grid = new GridPane();
        //grid.setGridLinesVisible(true);
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                Button cell = createCell(col);
                grid.add(cell, col, row);
            }
        }
        return grid;
    }

    private Button createCell(int column) {
        Button cell = new Button();
        cell.setMinSize(50, 50);

        cell.getStyleClass().addAll("button", "cell");
        cell.setOnAction(e -> controller.handleMove(column));
        return cell;
    }

    public void updateView(int[][] board) {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                int player = board[row][col];
                Button cell = (Button) gameBoard.getChildren().get(row * 7 + col);
                cell.setStyle("-fx-background-color: " + (player == 1 ? "RED" : (player == 2 ? "YELLOW" : "WHITE")) + ";");
            }
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void start(Stage primaryStage) {
        Model model = new Model();
        Controller controller = new Controller(model, this);
        gameBoard = createGameBoard(); // Call the method here

        // Set up the scene
        Scene scene = new Scene(gameBoard, 350, 300);
        scene.getStylesheets().add(getClass().getResource("/styles/grid-style.css").toExternalForm());
        primaryStage.setTitle("Connect 4");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
