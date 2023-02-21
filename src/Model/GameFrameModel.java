package Model;

import View.ColorCircle;

import java.util.ArrayList;

public class GameFrameModel {
    private int nextColorIndex = 0;
    private final int numberOfRounds;
    private int currentRound = 0;

    private final ArrayList<ColorCircle> circles = new ArrayList<>();
    private ArrayList<String> colors = new ArrayList<>();

    public GameFrameModel(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public int getNextColorIndex() {
        return nextColorIndex;
    }

    public void incrementNextColorIndex() {
        nextColorIndex++;
    }

    public void setNextColorIndex(int nextColorIndex) {
        this.nextColorIndex = nextColorIndex;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void incrementCurrentRound() {
        currentRound++;
    }

    public ArrayList<ColorCircle> getCircles() {
        return circles;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }
}
