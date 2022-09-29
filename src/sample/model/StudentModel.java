package sample.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import sample.DBConector;

import java.sql.SQLException;

public class StudentModel {
    private int id;
    private String name;
    private int rollNo;
    private String phoneNo;
    private String address;
    private double gpa;

    private ObjectProperty<ButtonBar> buttonBarObjectProperty;
    private ButtonBar editDeleteButtonBar;
    private Button editButton;
    private Button deleteButton;

    private DBConector dbConector;

    public StudentModel(int id,String name, int rollNo, String phoneNo, String address, double gpa) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.phoneNo = phoneNo;
        this.address = address;
        this.gpa = gpa;
        this.editDeleteButtonBar = new ButtonBar();
        this.editButton = new Button("Edit");
        this.deleteButton = new Button("Delete");
        editDeleteButtonBar.getButtons().add(editButton);
        editDeleteButtonBar.getButtons().add(deleteButton);

        this.buttonBarObjectProperty = new SimpleObjectProperty<ButtonBar>(editDeleteButtonBar);
        try {
            dbConector = new DBConector();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public StudentModel(String name, int rollNo, String phoneNo, String address, double gpa) {
        this.name = name;
        this.rollNo = rollNo;
        this.phoneNo = phoneNo;
        this.address = address;
        this.gpa = gpa;
        try {
            dbConector = new DBConector();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public ObservableList<StudentModel> getData(){

        return dbConector.getData();
    }
    public ObservableList<StudentModel> getUpdatedData(){

        return dbConector.getUpdatedData();
    }

    public StudentModel(){
        try {
            dbConector = new DBConector();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean deleteData(){
        return dbConector.deleteData(this.id);
    }
    public boolean eidit_data(){
        return dbConector.edit_data(id,name, rollNo, phoneNo, address,  gpa);
    }
    public boolean insert_data(){ return dbConector.insert_data(name, rollNo, phoneNo, address,  gpa);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public ButtonBar getButtonBarObjectProperty() {
        return buttonBarObjectProperty.get();
    }

    public ObjectProperty<ButtonBar> buttonBarObjectPropertyProperty() {
        return buttonBarObjectProperty;
    }

    public void setButtonBarObjectProperty(ButtonBar buttonBarObjectProperty) {
        this.buttonBarObjectProperty.set(buttonBarObjectProperty);
    }
}
