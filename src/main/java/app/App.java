package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(App.class.getResource("/View.fxml"));
			Parent root = loader.load();
			Scene s = new Scene(root);
			s.getRoot().requestFocus();
			primaryStage.setScene(s);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
