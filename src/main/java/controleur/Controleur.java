package controleur;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class Controleur {

    @FXML
    Rectangle rect;

    @FXML
    AnchorPane pane;

    @FXML
    public void initialize() {

    }

    @FXML
    public void keyPressed(KeyEvent key) {
        System.out.println("key pressed");
        if (key.getCode() == KeyCode.W)
            rect.setY(rect.getY() + 1);
    }
}
