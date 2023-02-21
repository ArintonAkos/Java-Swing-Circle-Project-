package View;

import Model.GamePanelModel;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final GamePanelModel gamePanelModel;

    public GamePanel(GamePanelModel gamePanelModel) {
        super();
        setBackground(Color.WHITE);
        setLayout(null);

        this.gamePanelModel = gamePanelModel;
    }

    public void updateCircles() {
        removeAll();

        for (ColorCircle circle : gamePanelModel.getCircles()) {
            add(circle);
        }

        revalidate();
        repaint();
    }

    public void clear() {
        removeAll();
        revalidate();
        repaint();
    }
}
