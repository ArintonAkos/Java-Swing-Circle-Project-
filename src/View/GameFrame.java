package View;

import Contracts.ColorCircleListener;
import Contracts.GameFrameListener;
import Controller.GamePanelController;
import Model.GameFrameModel;
import Model.GamePanelModel;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame implements ColorCircleListener {
    private final JLabel answerLabel;
    private final JButton redButton, orangeButton, yellowButton;
    private final GameFrameModel model;
    private final GamePanel gamePanel;
    private final GamePanelController gamePanelController;
    private GameFrameListener gameFrameListener;

    public GameFrame(GameFrameModel gameFrameModel) {
        super("Color Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        this.model = gameFrameModel;

        // Answer label at the top
        answerLabel = new JLabel("Correct Answers: 0 / " + model.getNumberOfRounds());
        add(answerLabel, BorderLayout.NORTH);

        // Game panel in the middle
        GamePanelModel gamePanelModel = new GamePanelModel(gameFrameModel.getCircles(), this);
        gamePanel = new GamePanel(gamePanelModel);
        gamePanelController = new GamePanelController(gamePanelModel, gamePanel);
        add(gamePanel, BorderLayout.CENTER);

        // Buttons at the bottom
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));

        redButton = new JButton("Red");
        orangeButton = new JButton("Orange");
        yellowButton = new JButton("Yellow");

        buttonPanel.add(redButton);
        buttonPanel.add(orangeButton);
        buttonPanel.add(yellowButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set window size and make visible
        setSize(300, 300);
        setVisible(true);
        setResizable(false);
    }

    public JLabel getAnswerLabel() {
        return answerLabel;
    }

    public void setButtonsEnabled(boolean enabled) {
        redButton.setEnabled(enabled);
        orangeButton.setEnabled(enabled);
        yellowButton.setEnabled(enabled);
    }

    public void showEndOfGameDialog() {
        JOptionPane.showMessageDialog(GameFrame.this, getCorrectAnswersText(false));
        setButtonsEnabled(false);
    }

    public void onWrongCircle() {
        setButtonsEnabled(false);

        getGamePanel().removeAll();
        getGamePanel().revalidate();
        getGamePanel().repaint();
    }

    public void onNewCircles() {
        getGamePanelController().updateCircles(model.getCircles());
        setButtonsEnabled(true);
    }

    public String getCorrectAnswersText(boolean increment) {
        int correctAnswers = Integer.parseInt(answerLabel.getText().split(" ")[2]);

        if (increment) {
            correctAnswers++;
        }

        return "Correct answers: " +  correctAnswers + " / " + model.getNumberOfRounds();
    }

    public void updateCorrectAnswersTextOnCorrectAnswer() {
        answerLabel.setText(getCorrectAnswersText(true));
    }

    public void showWrongAnswerDialog() {
        JOptionPane.showMessageDialog(this, "Wrong answer try again!");
    }

    public JButton getRedButton() {
        return redButton;
    }

    public JButton getOrangeButton() {
        return orangeButton;
    }

    public JButton getYellowButton() {
        return yellowButton;
    }

    public void setGameFrameListener(GameFrameListener gameFrameListener) {
        this.gameFrameListener = gameFrameListener;
    }

    @Override
    public void onCircleClickListener(String color) {
        if (gameFrameListener != null) {
            gameFrameListener.onCircleClicked(color);
        }
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public GamePanelController getGamePanelController() {
        return gamePanelController;
    }
}