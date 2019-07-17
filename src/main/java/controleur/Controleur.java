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
import models.RelativeCoordinates;
import models.Tank;
import utils.Angles;

public class Controleur {

    private boolean running;

    @FXML
    Rectangle rect;

    @FXML
    AnchorPane pane;

    private Tank tank;

    private RelativeCoordinates relativeCoordinates = new RelativeCoordinates();

    public Controleur() {
    }

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
        this.running = true;
        Runnable r = () -> {
            while (this.running) { // while (device.poll() && running) {
                XInputComponents components = device.getComponents();
                XInputAxes axes = components.getAxes();
                float leftAxisXDelta = 1.0f; //float leftAxisXDelta = axes.ly;
                float rightAxisXDelta = 0.0f; //float rightAxisXDelta = axes.ry;
                System.out.println("leftAxisXDelta: " + leftAxisXDelta);
                System.out.println("rightAxisXDelta: " + rightAxisXDelta);
                relativeCoordinates.reset();
                MoveTank.move(tank, leftAxisXDelta, rightAxisXDelta, relativeCoordinates);
                toRectangle();
                try {
                    Thread.sleep((long) (MoveTank.TIME_OF_STEP * 1000));
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
        double x = rect.getLayoutX() + (rect.getWidth() / 2);
        double y = rect.getLayoutY() + (rect.getHeight() / 2);
        tank = new Tank(rect.getRotate(), rect.getWidth(), rect.getHeight());
        tank.setLeftSpeed(1.0f);
    }

    private void toRectangle() {
        rect.setRotate(Angles.angle(-tank.getOrientation()));
        rect.setLayoutX(relativeCoordinates.getFxX() + rect.getLayoutX());
        rect.setLayoutX(relativeCoordinates.getFxY() + rect.getLayoutY());
    }

    public void stopRunning() {
        this.running = false;
    }
}
