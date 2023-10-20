package com.example.connect4fx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void handleMove(int column) {
        if (model.makeMove(column)) {
            view.updateView(model.getBoard());

            if (model.isWin()) {
                view.displayMessage("Player " + model.getCurrentPlayer() + " wins!");
            } else if (model.isDraw()) {
                view.displayMessage("It's a draw!");
            } else {
                model.switchPlayer();
            }
        } else {
            view.displayMessage("Column is full. Try again.");
        }

    }
}