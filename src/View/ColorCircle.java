package View;

import Contracts.ColorCircleListener;
import Model.ColorCircleModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ColorCircle extends JComponent {
    private final ColorCircleModel model;

    public ColorCircle(ColorCircleModel model) {
        this.model = model;

        setBounds(model.getX(), model.getY(), model.getSize(), model.getSize());
        setPreferredSize(new Dimension(model.getSize(), model.getSize()));
        setMouseListener();
    }

    private void setMouseListener() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (model.getListener() != null) {
                    model.getListener().onCircleClickListener(model.getColor());
                }
            }
        });
    }

    public void setListener(ColorCircleListener listener) {
        model.setListener(listener);
    }

    public Color getColor() {
        return switch (model.getColor()) {
            case "Red" -> Color.RED;
            case "Orange" -> Color.ORANGE;
            default -> Color.YELLOW;
        };
    }

    public String getColorName() {
        return model.getColor();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(getColor());
        g.fillOval(0, 0, model.getSize(), model.getSize());
    }
}