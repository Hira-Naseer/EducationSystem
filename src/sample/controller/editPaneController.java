package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Main;
import sample.model.StudentModel;

import java.net.URL;
import java.util.ResourceBundle;

public class editPaneController implements Initializable {
    @FXML
    TextField eidtNameTextfield;
    @FXML
    TextField eidtRollnoTextfield;
    @FXML
    TextField eidtPhonenoTextfield;
    @FXML
    TextField eidtAddressTextfield;
    @FXML
    TextField eidtGpaTextfield;
    @FXML
    Button UpdateButton;

    private StudentModel studentModel;
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    private ViewTablePaneController viewTablePaneController;

    public void setViewTablePaneController(ViewTablePaneController viewTablePaneController) {
        this.viewTablePaneController = viewTablePaneController;
    }

    public void setStudentModel(StudentModel studentModel) {
        this.studentModel = studentModel;
    }
    public void updateTableCells(){
        UpdateButton.setOnAction(event -> {

            String name = eidtNameTextfield.getText();
            int rollno = Integer.parseInt(eidtRollnoTextfield.getText());
            String phoneno = eidtPhonenoTextfield.getText();
            String address = eidtAddressTextfield.getText();
            double gpa = Double.parseDouble(eidtGpaTextfield.getText());

            studentModel = new StudentModel(name, rollno, phoneno, address, gpa);
            boolean flag = studentModel.eidit_data();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            if(flag){
                alert.setContentText("Data Updated");
                alert.show();
                viewTablePaneController.updatedTable();
            }else if(!flag){
                alert.setContentText("DATA IS NOT Updated");
                alert.show();
            }

        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
