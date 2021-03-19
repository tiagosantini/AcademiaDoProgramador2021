package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import db.DB;
import db.DbException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Equipamento;

public class ViewController implements Initializable{

	@FXML
	private MenuItem menuRegistrar;
	
	public void onMenuRegistrarAction(ActionEvent event) throws Exception {               
	    try {
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/Registrar.fxml"));
	        Parent root1 = (Parent) fxmlLoader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root1));  
	        stage.show();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@FXML
	private TableView<Equipamento> table;
	
	@FXML
	private TableColumn<Equipamento, Integer> col_id;
	@FXML
	private TableColumn<Equipamento, String> col_nome;
	@FXML
	private TableColumn<Equipamento, String> col_num;
	@FXML
	private TableColumn<Equipamento, String> col_fabricante;
	
	ObservableList<Equipamento> oblist = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		Connection conn = DB.getConnection();
		ResultSet rs = null;
		try {
			rs = conn.createStatement().executeQuery("SELECT * FROM equipamentos");
			
			while(rs.next()) {
				oblist.add(new Equipamento(rs.getInt("id"),
						rs.getString("nomeProduto"), rs.getString("numeroSerie"), rs.getString("fabricante")));
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
		}
		
		
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_nome.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
		col_num.setCellValueFactory(new PropertyValueFactory<>("numeroSerie"));
		col_fabricante.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
		
		table.setItems(oblist);
	}
	
//	private void loadView(String absoluteName) {
//		FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
//	}

}
