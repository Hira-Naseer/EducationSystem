package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.model.StudentModel;

import java.sql.*;

public class DBConector {
    public Connection connection = null;
    public PreparedStatement preStatement = null;
    public ResultSet resultSet = null;

    private String url = "jdbc:mysql://localhost/registration_from?useTimezone=true&serverTimezone=UTC";
    private String user = "root";
    private String password = "";
    public DBConector() throws SQLException{
            connection = DriverManager.getConnection(url,user,password);

    }
    public Boolean isConnect(){
        try {
            return !connection.isClosed();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public boolean insert_data(String name, int rollno, String phoneno, String address, double gpa){
        String query = "INSERT INTO student VALUES(null,?,?,?,?,?)";
        try {
            preStatement = connection.prepareStatement(query);
            preStatement.setString(1,name);
            preStatement.setInt(2,rollno);
            preStatement.setString(4,phoneno);
            preStatement.setString(3,address);
            preStatement.setDouble(5,gpa);

            int row = preStatement.executeUpdate();
            if (row > 0)
                return true;
            else
                return false;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    ObservableList<StudentModel> list = FXCollections.observableArrayList();

    public ObservableList<StudentModel> getData(){
        String query = "select * from student";
        try {
            preStatement = connection.prepareStatement(query);
            resultSet = preStatement.executeQuery(query);
            while (resultSet.next()){
                list.add(new StudentModel(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDouble(6))
                );
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public boolean deleteData(int id){
        String query = "DELETE FROM student WHERE Student_id = "+id;
        try {
            preStatement = connection.prepareStatement(query);
//            preStatement.setInt(1,id);
            int row = preStatement.executeUpdate(query);
            if(row > 0)
                return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }
    public boolean edit_data(int id,String name, int rollno, String phoneno, String address, double gpa){
        String query = "UPDATE student SET Student_name = ?, Student_rollNo = ?, Student_Adress = ?, Student_phoneNo = ?, Student_gpa = ? WHERE Student_id = ?";
        try {
            preStatement = connection.prepareStatement(query);
            preStatement.setString(1,name);
            preStatement.setInt(2,rollno);
            preStatement.setString(3,address);
            preStatement.setString(4,phoneno);
            preStatement.setDouble(5,gpa);
            preStatement.setInt(6,id);
            int row = preStatement.executeUpdate();
            if(row > 0)
                return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public ObservableList<StudentModel> getUpdatedData(){
        String query = "select * from student";
        try {
            preStatement = connection.prepareStatement(query);
            resultSet = preStatement.executeQuery(query);
            while (resultSet.next()){
                list.add(new StudentModel(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDouble(6))
                );
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
