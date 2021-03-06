package org.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Controller {
    protected double mousePositionOnX;
    protected double mousePositionOnY;
    protected Stage stage;

    protected void loadFXMLFile(URL fxmlFile, Object controller) {
        FXMLLoader loader = new FXMLLoader(fxmlFile);
        loader.setController(controller);
        Parent root = null;
        try{
            root = loader.load();
        } catch(IOException ioe) {
            Logger.getLogger( controller.getClass().getName() ).log(Level.SEVERE, null, ioe);
        }
        stage = new Stage();
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
    }

    protected void stageDragged(MouseEvent event) {
        stage.setX( event.getScreenX() - mousePositionOnX );
        stage.setY( event.getScreenY() - mousePositionOnY );
    }

    protected void stagePressed(MouseEvent event) {
        mousePositionOnX = event.getSceneX();
        mousePositionOnY = event.getSceneY();
    }

    protected void setStyleClass(AnchorPane rootStage, String cssPath) {
        rootStage.getStylesheets().clear();
        rootStage.getStylesheets().add(cssPath);
    }

}
