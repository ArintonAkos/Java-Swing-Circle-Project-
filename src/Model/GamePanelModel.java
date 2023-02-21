package Model;

import Contracts.ColorCircleListener;
import View.ColorCircle;

import java.util.ArrayList;

public class GamePanelModel {
    private ArrayList<ColorCircle> circles;
    private final ColorCircleListener listener;

    public GamePanelModel(ArrayList<ColorCircle> circles, ColorCircleListener listener) {
        this.circles = circles;
        this.listener = listener;
    }

    public void setCircles(ArrayList<ColorCircle> circles) {
        this.circles = circles;
    }

    public ArrayList<ColorCircle> getCircles() {
        return this.circles;
    }

    public ColorCircleListener getListener() {
        return this.listener;
    }
}
