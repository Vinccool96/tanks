package controleur;

import com.github.strikerx3.jxinput.XInputAxes;
import com.github.strikerx3.jxinput.XInputComponents;
import com.github.strikerx3.jxinput.XInputDevice;
import com.github.strikerx3.jxinput.exceptions.XInputNotLoadedException;
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
        // Retrieve all devices
        XInputDevice[] devices = new XInputDevice[0];
        try {
            devices = XInputDevice.getAllDevices();
        } catch (XInputNotLoadedException e) {
            e.printStackTrace();
        }

        // Retrieve the device for player 1
        XInputDevice device = devices[0]; // or XInputDevice.getDeviceFor(0)

        launch(device);

    }

    private void launch(XInputDevice device) {
        Runnable r = () -> {
            while (device.poll()) {
                XInputComponents components = device.getComponents();
                XInputAxes axes = components.getAxes();
                float rightAxisXDelta = axes.ry;
                float leftAxisXDelta = axes.ly;
                System.out.println("rightAxisXDelta: " + rightAxisXDelta);
                System.out.println("leftAxisXDelta: " + leftAxisXDelta);
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
}
