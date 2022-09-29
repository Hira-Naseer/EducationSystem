package sample.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import sample.Main;
import sample.model.StudentModel;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentDbFormController implements Initializable{

    @FXML
    BorderPane borderpane;
    @FXML
    Button insertButton;
    @FXML
    Button viewButton;



    private  Main main;

    private StudentModel model;

    public void setMain(Main main) {
        this.main = main;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        insertButton.setOnAction(event -> {
            try {
                borderpane.setCenter(main.showInsertpane());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        viewButton.setOnAction(event -> {
            try {
                borderpane.setCenter(main.showViewTablePane());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
