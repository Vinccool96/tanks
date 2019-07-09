package controleur;

import com.github.strikerx3.jxinput.XInputAxes;
import com.github.strikerx3.jxinput.XInputComponents;
import com.github.strikerx3.jxinput.XInputDevice;
import com.github.strikerx3.jxinput.exceptions.XInputNotLoadedException;
import game.MoveTank;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import models.Tank;

public class Controleur {

    @FXML
    Rectangle rect;

    @FXML
    AnchorPane pane;

    private Tank tank;

    @FXML
    public void initialize() {
        // Retrieve all devices
        XInputDevice[] devices = new XInputDevice[0];
        try {
            devices = XInputDevice.getAllDevices();
        } catch (XInputNotLoadedException e) {
            e.printStackTrace();
        }
        initializeTank(rect);
        // Retrieve the device for player 1
        XInputDevice device = devices[0]; // or XInputDevice.getDeviceFor(0)

        launch(device);

    }

    private void launch(XInputDevice device) {
        Runnable r = () -> {
            while (device.poll()) {
                XInputComponents components = device.getComponents();
                XInputAxes axes = components.getAxes();
                float leftAxisXDelta = axes.ly;
                float rightAxisXDelta = axes.ry;
                System.out.println("leftAxisXDelta: " + leftAxisXDelta);
                System.out.println("rightAxisXDelta: " + rightAxisXDelta);
                MoveTank.move(tank, rect, leftAxisXDelta, rightAxisXDelta);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(r).start();
    }

    @FXML
    public void keyPressed(KeyEvent key) {
        System.out.println("key pressed");
        if (key.getCode() == KeyCode.W) {
            rect.setY(rect.getY() - 1);
        }
    }

    private void initializeTank(Rectangle rect) {
        tank = new Tank(rect.getRotate(), rect.getLayoutX(), rect.getLayoutY());
    }
}
