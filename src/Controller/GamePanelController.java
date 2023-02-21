package Controller;

import Model.GamePanelModel;
import View.ColorCircle;
import View.GamePanel;

import java.util.ArrayList;

public class GamePanelController {
    private final GamePanelModel gamePanelModel;
    private final GamePanel gamePanel;

    public GamePanelController(GamePanelModel gamePanelModel, GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.gamePanelModel = gamePanelModel;
    }

    public void updateCircles(ArrayList<ColorCircle> circles) {
        gamePanelModel.setCircles(circles);

        for (ColorCircle circle : gamePanelModel.getCircles()) {
            circle.setListener(gamePanelModel.getListener());
        }

        gamePanel.updateCircles();
    }
}
