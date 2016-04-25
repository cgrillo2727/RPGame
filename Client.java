package RPG.Game;
/*
 * @author Cecil College | CSC 218 
 * @date created Fri, Apr 15, 2016  2:36:34 AM
 * @last modified Fri, Apr 23, 2016
 * @description This class facilitates combat.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Client extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml")); //temporary root

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
