/*
Class created by James
4/18/2016
 */

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml")); //temporary root
        
        //Title
        primaryStage.setTitle("Trogdor the Burninator");
        
        //Size
        primaryStage.setScene(new Scene(root, 750, 650));
        primaryStage.show();
    }

    //This is where we'll call all classes and modules
    public static void main(String[] args) {
        launch(args);
    }
}
