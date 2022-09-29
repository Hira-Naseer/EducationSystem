package sample.controller;

import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.layout.FlowPane;
import sample.Main;
import sample.model.StudentModel;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewTablePaneController implements Initializable
{
    @FXML
    FlowPane viewFlowpane;
    @FXML
    TableView<StudentModel> tableV;
    @FXML
    TableColumn<StudentModel,Integer> id;
    @FXML
    TableColumn<StudentModel,String> name;
    @FXML
    TableColumn<StudentModel,Integer> rollNo;
    @FXML
    TableColumn<StudentModel,String> phoneNo;
    @FXML
    TableColumn<StudentModel,String> address;
    @FXML
    TableColumn<StudentModel,Double> gpa;
    @FXML
    Button editButton, deleteButton;
    @FXML
    TableColumn actionColumn;


    private Main main;
    private  StudentModel studentModel;
    private editPaneController editPaneController;

    public void setViewTablePaneController(ViewTablePaneController viewTablePaneController) {
        this.editPaneController = editPaneController;
    }

    public void setStudentModel(StudentModel studentModel) {
        this.studentModel = studentModel;
    }

    public void setMain(Main main) {
        this.main=main;
    }
    public void initTable(){

        id.setCellValueFactory(new PropertyValueFactory<StudentModel,Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<StudentModel,String>("name"));
        rollNo.setCellValueFactory(new PropertyValueFactory<StudentModel,Integer>("rollNo"));
        phoneNo.setCellValueFactory(new PropertyValueFactory<StudentModel,String>("phoneNo"));
        address.setCellValueFactory(new PropertyValueFactory<StudentModel,String>("address"));
        gpa.setCellValueFactory(new PropertyValueFactory<StudentModel,Double>("gpa"));
        actionColumn.setCellValueFactory(new PropertyValueFactory<StudentModel, ObjectProperty>("buttonBarObjectProperty"));

        ObservableList<StudentModel> list = this.studentModel.getData();
        tableV.getItems().addAll(list);
        tableV.refresh();

    }
    public void updatedTable(){
        id.setCellValueFactory(new PropertyValueFactory<StudentModel,Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<StudentModel,String>("name"));
        rollNo.setCellValueFactory(new PropertyValueFactory<StudentModel,Integer>("rollNo"));
        phoneNo.setCellValueFactory(new PropertyValueFactory<StudentModel,String>("phoneNo"));
        address.setCellValueFactory(new PropertyValueFactory<StudentModel,String>("address"));
        gpa.setCellValueFactory(new PropertyValueFactory<StudentModel,Double>("gpa"));

        ObservableList<StudentModel> list = this.studentModel.getUpdatedData();
        tableV.getItems().addAll(list);
        tableV.refresh();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        deleteButton.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            StudentModel selectedItem = tableV.getSelectionModel().getSelectedItem();

            if(selectedItem != null){
                selectedItem.deleteData();
                tableV.refresh();
            }
            else {
                alert.setContentText("Please select a cell to delete.");
                alert.show();
            }

        });
        editButton.setOnAction(event -> {
            try {
                this.main.editPane();
                editPaneController.updateTableCells();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        tableV.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<StudentModel>() {
                    @Override
                    public void changed(ObservableValue<? extends StudentModel> observable, StudentModel oldValue, StudentModel newValue) {
                        System.out.println(observable);
                        System.out.println(oldValue);
                        System.out.println(newValue.getData());
                    }
                }
        );
    }


}
