package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.xml.transform.Result;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class tableController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    Connection conn =null;
    ResultSet resultSet = null;
    @FXML
    private TableView<reportdata> rtable;

    @FXML
    private TableColumn<reportdata, String> c1;

    @FXML
    private TableColumn<reportdata, String> c2;

    @FXML
    private TableColumn<reportdata, String> c3;

    @FXML
    private TableColumn<reportdata, String> c4;
    public void getdata() {
        conn= dbconnection.dbconnect();

        c1.setCellValueFactory(new PropertyValueFactory<>("Incident"));
        c2.setCellValueFactory(new PropertyValueFactory<> ("Location"));
        c3.setCellValueFactory(new PropertyValueFactory<>("AdditionalInfo"));
        c4.setCellValueFactory(new PropertyValueFactory<>("Contact"));

    }

    String query ;
    Connection connection ;
    PreparedStatement preparedStatement ;

    ObservableList<reportdata> Data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getdata();
        viewdata();
    }


    @FXML
    public void viewdata() {
        try {
            Data.clear();
            query = "SELECT * FROM `formtable`";
            preparedStatement  =conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Data.add(new reportdata (
                        resultSet.getString("Incident"),
                        resultSet.getString("Location"),
                        resultSet.getString("AdditionalInfo"),
                        resultSet.getString("Contact")));
            }
                 rtable.setItems(Data);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    void homebutton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
