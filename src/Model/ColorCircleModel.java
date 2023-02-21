package Model;

import Contracts.ColorCircleListener;

public class ColorCircleModel {
    private final String color;
    private final int x;
    private final int y;
    private final int size;
    private ColorCircleListener listener;

    public ColorCircleModel(String color, int x, int y, int size) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public ColorCircleListener getListener() {
        return listener;
    }

    public void setListener(ColorCircleListener listener) {
        this.listener = listener;
    }
}
