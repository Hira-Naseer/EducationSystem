package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import sample.Main;
import sample.model.StudentModel;

import javax.security.auth.login.Configuration;
import java.net.URL;
import java.util.ResourceBundle;

public class InsertpaneController implements Initializable {
    @FXML
    FlowPane insertFlowpane;
    @FXML
    TextField nameTextField;
    @FXML
    TextField rollnoTextField;
    @FXML
    TextField phonenoTextField;
    @FXML
    TextField addressTextField;
    @FXML
    TextField gpaTextField;
    @FXML
    Button resetButton;
    @FXML
    Button saveButton;

    private Main main;

    private StudentModel studentModel;


    public void setStudentModel(StudentModel studentModel) {
        this.studentModel = studentModel;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        resetButton.setOnAction(event -> {
            nameTextField.setText("");
            rollnoTextField.setText("");
            phonenoTextField.setText("");
            addressTextField.setText("");
            gpaTextField.setText("");
        });

        saveButton.setOnAction(event -> {
                String name = nameTextField.getText();
                int rollno = Integer.parseInt(rollnoTextField.getText());
                String phoneno = phonenoTextField.getText();
                String address = addressTextField.getText();
                double gpa = Double.parseDouble(gpaTextField.getText());

                studentModel = new StudentModel(name, rollno, phoneno, address, gpa);
                boolean flag = studentModel.insert_data();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                if(flag){
                    alert.setContentText("DATA INSERTED");
                    alert.show();
                }else if(!flag){
                    alert.setContentText("DATA IS NOT INSERTED");
                    alert.show();
                }

        });

    }
}
