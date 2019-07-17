package app;

import controleur.Controleur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    Controleur controleur;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/View.fxml"));
            Parent root = loader.load();
            controleur = loader.getController();
            Scene s = new Scene(root);
            s.getRoot().requestFocus();
            primaryStage.setScene(s);
            primaryStage.show();
            controleur.startRunning();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() throws Exception {
        controleur.stopRunning();
        super.stop();
    }
}
