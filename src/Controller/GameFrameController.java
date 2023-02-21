package Controller;

import Contracts.GameFrameListener;
import Model.ColorCircleModel;
import Model.GameFrameModel;
import View.ColorCircle;
import View.GameFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GameFrameController implements GameFrameListener {
    private final GameFrame gameFrame;
    private final GameFrameModel model;

    public GameFrameController(GameFrame gameFrame, GameFrameModel gameFrameModel) {
        this.gameFrame = gameFrame;
        this.model = gameFrameModel;

        setupFrameListener();
        setupButtonListeners();

        startGame();
    }

    public void setupFrameListener() {
        gameFrame.setGameFrameListener(this);
    }

    private void setupButtonListeners() {
        gameFrame.getRedButton().addActionListener(e -> checkAnswer("Red"));
        gameFrame.getOrangeButton().addActionListener(e -> checkAnswer("Orange"));
        gameFrame.getYellowButton().addActionListener(e -> checkAnswer("Yellow"));
    }

    private void startGame() {
        gameFrame.setButtonsEnabled(false);
        gameFrame.getAnswerLabel().setText("Correct answers: 0 / " + model.getNumberOfRounds());

        Timer timer = new Timer(3000, e -> {
            if (model.getCurrentRound() == model.getNumberOfRounds()) {
                ((Timer)e.getSource()).stop();
                gameFrame.showEndOfGameDialog();
                gameFrame.setButtonsEnabled(false);
            }

            model.setNextColorIndex(0);
            model.incrementCurrentRound();
            gameFrame.getGamePanel().clear();

            generateColors();
        });

        timer.setRepeats(true);
        timer.start();
    }

    private void generateColors() {
        int x = 30;
        int y = 80;
        int size = 50;

        model.getCircles().clear();
        model.setColors(new ArrayList<>(Arrays.asList("Red", "Orange", "Yellow")));

        Collections.shuffle(model.getColors());

        for (String color : model.getColors()) {
            model.getCircles().add(new ColorCircle(new ColorCircleModel(color, x, y, size)));
            x += 80;
        }

        gameFrame.onNewCircles();
    }

    private void checkAnswer(String color) {
        if (model.getCurrentRound() > model.getNumberOfRounds()) {
            return;
        }

        if (getNextColor().equals(color)) {
            model.incrementNextColorIndex();

            if (model.getNextColorIndex() < model.getCircles().size()) {
                return;
            }

            gameFrame.updateCorrectAnswersTextOnCorrectAnswer();
        } else {
            // End of round - Wrong answer
            gameFrame.showWrongAnswerDialog();
        }

        gameFrame.onWrongCircle();
    }

    private String getNextColor() {
        if (model.getNextColorIndex() < model.getCircles().size()) {
            return model.getCircles().get(model.getNextColorIndex()).getColorName();
        } else {
            return "";
        }
    }

    @Override
    public void onCircleClicked(String color) {
        checkAnswer(color);
    }
}
