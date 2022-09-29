package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import sample.controller.InsertpaneController;
import sample.controller.StudentDbFormController;
import sample.controller.ViewTablePaneController;
import sample.controller.editPaneController;
import sample.model.StudentModel;

import java.net.URL;

public class Main extends Application {
    private Stage primaryStage = null;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
            showStudebtDbForm();

    }
    public void  showStudebtDbForm() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/StudentDbForm.fxml"));

        BorderPane bpane = loader.load();

        StudentDbFormController ctrlObj = loader.getController();
        ctrlObj.setMain(this);

        Scene bScene = new Scene(bpane,600,500);
        primaryStage.setScene(bScene);
        primaryStage.show();

    }
    public FlowPane showInsertpane() throws Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/Insertpane.fxml"));

        FlowPane fInsertPane = loader.load();

        InsertpaneController ctrlObj = loader.getController();
        ctrlObj.setMain(this);


        return fInsertPane;
    }

    public FlowPane showViewTablePane() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/ViewTablePane.fxml"));

        FlowPane flowPane = loader.load();

        ViewTablePaneController ctrlObj = loader.getController();
        ctrlObj.setMain(this);
        ctrlObj.setStudentModel(new StudentModel());
        ctrlObj.initTable();


        return flowPane;
    }
    public void editPane() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/editpane.fxml"));

        FlowPane flowPane = loader.load();
        Scene scene = new Scene(flowPane,600,500);
        primaryStage.setScene(scene);
        primaryStage.show();

        editPaneController ctrlObj = loader.getController();
        ctrlObj.setMain(this);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
