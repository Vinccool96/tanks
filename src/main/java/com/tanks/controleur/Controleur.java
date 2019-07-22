package com.tanks.controleur;

import com.github.strikerx3.jxinput.XInputAxes;
import com.github.strikerx3.jxinput.XInputComponents;
import com.github.strikerx3.jxinput.XInputDevice;
import com.github.strikerx3.jxinput.exceptions.XInputNotLoadedException;
import com.tanks.events.MoveTank;
import com.tanks.models.physics.PhysicsVector;
import com.tanks.models.physics.RelativeCoordinates;
import com.tanks.models.game.Tank;
import com.tanks.utils.Angles;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Controleur {

    @FXML
    AnchorPane pane;

    @FXML
    Rectangle tankBody;

    private boolean running;

    private Tank tank;

    private RelativeCoordinates relativeCoordinates = new RelativeCoordinates();

    private PhysicsVector gunnerLeftAxisVector = new PhysicsVector();

    private PhysicsVector gunnerRightAxisVector = new PhysicsVector();

    public Controleur() {
    }

    @FXML
    public void initialize() {
        tankBody.setStrokeWidth(0.0);
        tankBody.setStroke(Color.TRANSPARENT);
        Image imageTankBody = new Image("/images/tank_body.png");
        tankBody.setFill(new ImagePattern(imageTankBody));
    }

    public void startRunning() {
        initializeTank(tankBody);
        // Retrieve all
        XInputDevice[] devices = new XInputDevice[0];
        try {
            devices = XInputDevice.getAllDevices();
        } catch (XInputNotLoadedException e) {
            e.printStackTrace();
        }

        // Retrieve the device for player 1
        XInputDevice driverDevice = devices[0]; // or XInputDevice.getDeviceFor(0)

        // Retrieve the device for player 2
        XInputDevice gunnerDevice = devices[1]; // or XInputDevice.getDeviceFor(1)

        launch(driverDevice, gunnerDevice);
    }

    public void stopRunning() {
        this.running = false;
    }

    private void launch(XInputDevice driverDevice, XInputDevice gunnerDevice) {
        this.running = true;
        Runnable r = () -> {
            while (driverDevice.poll() && gunnerDevice.poll() && running) {
                driverActions(driverDevice);
                gunnerActions(gunnerDevice);
                try {
                    Thread.sleep((long) (MoveTank.TIME_OF_STEP * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(r).start();
    }

    private void driverActions(XInputDevice driverDevice){
        XInputComponents components = driverDevice.getComponents();
        XInputAxes axes = components.getAxes();
        float leftAxisY = axes.ly;
        float rightAxisY = axes.ry;
        System.out.println("leftAxisY: " + leftAxisY);
        System.out.println("rightAxisY: " + rightAxisY);
        relativeCoordinates.reset();
        MoveTank.move(tank, leftAxisY, rightAxisY, relativeCoordinates);
        toRectangle();
    }

    private void gunnerActions(XInputDevice gunnerDevice){
        XInputComponents components = gunnerDevice.getComponents();
        XInputAxes axes = components.getAxes();
        double previousLeftOrientation = gunnerLeftAxisVector.getOrientation();
        double previousRightOrientation = gunnerRightAxisVector.getOrientation();
        float leftAxisX = axes.lx;
        float leftAxisY = axes.ly;
        float rightAxisX = axes.rx;
        float rightAxisY = axes.ry;
        gunnerLeftAxisVector.setVectorXY(leftAxisX, leftAxisY);
        gunnerRightAxisVector.setVectorXY(rightAxisX, rightAxisY);
        double currentLeftOrientation = gunnerLeftAxisVector.getOrientation();
        double currentRightOrientation = gunnerRightAxisVector.getOrientation();
        double leftAxisOrientationDelta = Angles.angularDelta(previousLeftOrientation, currentLeftOrientation);
        double rightAxisOrientationDelta = Angles.angularDelta(previousRightOrientation, currentRightOrientation);
    }

    private void initializeTank(Rectangle tankBody) {
        tank = new Tank(tankBody.getRotate(), tankBody.getWidth(), tankBody.getHeight());
        tank.setLeftSpeed(1.0f);
    }

    private void toRectangle() {
        tankBody.setRotate(Angles.angle(-tank.getOrientation()));
        tankBody.setX(relativeCoordinates.getFxX() + tankBody.getX());
        tankBody.setY(relativeCoordinates.getFxY() + tankBody.getY());
    }
}
