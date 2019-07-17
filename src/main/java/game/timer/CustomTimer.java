package game.timer;

import javafx.animation.AnimationTimer;

abstract public class CustomTimer extends AnimationTimer {

    private long previousNow;

    public long getPreviousNow() {
        return previousNow;
    }

    public void setPreviousNow(long previousNow) {
        this.previousNow = previousNow;
    }
}
