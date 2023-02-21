import Controller.GameFrameController;
import Model.GameFrameModel;
import View.GameFrame;

public class Main {
    private static final int DEFAULT_ROUND_NUMBER = 5;

    public static void main(String[] args) {
        int nrOfRounds = getNrOfRounds(args);

        if (nrOfRounds <= 0) {
            System.out.println("The number of rounds must be a positive integer!");
        }

        GameFrameModel model = new GameFrameModel(nrOfRounds);
        GameFrame gameFrame = new GameFrame(model);

        new GameFrameController(gameFrame, model);
    }

    private static int getNrOfRounds(String[] args) {
        try {
            return Integer.parseInt(args[1]);
        } catch (Exception e) {
            return DEFAULT_ROUND_NUMBER;
        }
    }
}