package RPG.Game;
/*
Class created by James
4/18/2016
*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Client extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml")); //temporary root

        //Title
        primaryStage.setTitle("Trogdor the Burninator");

        // lets separate the scene so we can grab it later
        Scene scene = new Scene(root, 750, 650);
        //Size
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //This is where we'll call all classes and modules
  public static void main(String[] args) {
        launch(args);
   }
}
