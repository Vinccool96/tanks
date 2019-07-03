package app;

import controleur.Controleur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/VueInterface.fxml"));
			BorderPane root = loader.load();
			Scene s = new Scene(root);
			primaryStage.setScene(s);
			primaryStage.show();
			Controleur c = new Controleur();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
