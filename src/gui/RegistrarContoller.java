package gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import db.DB;
import db.DbException;
import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.entities.Equipamento;

public class RegistrarContoller implements Initializable{
	
	@FXML
	private Button btnClose;
	
	@FXML
	private Button btnRegistrar;
	
	@FXML
	private TextField txtNomeProduto;
	
	@FXML
	private TextField txtNumeroSerie;
	
	@FXML
	private TextField txtFabricante;
	
	@FXML
	private TextField txtDataFabricacao;
	
	@FXML
	private TextField txtPrecoAquisicao;
	
	@FXML
	private void onBtnCloseAction(){

	    Stage stage = (Stage) btnClose.getScene().getWindow();
	    stage.close();
	}
	
	@FXML
	private void onBtnRegistrarAction() {
		Date formattedDataFabricacao = null;
		System.out.println("Botão acionado");
		
		try {
			formattedDataFabricacao = (Date) new SimpleDateFormat(
					"yyyy/MM/dd", Locale.ENGLISH).parse(txtDataFabricacao.getText().toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (txtNomeProduto.getText().length() < 6) {
			Alerts.showAlert("Erro de inserção de dados", null, "O campo Nome deve ter 6 ou mais caracteres", AlertType.WARNING);
		}
		else {
			Equipamento obj = new Equipamento();
			obj.setNomeProduto(txtNomeProduto.getText());
			obj.setNumeroSerie(txtNumeroSerie.getText());
			obj.setFabricante(txtFabricante.getText());
			obj.setDataFabricacao(formattedDataFabricacao);
			obj.setPrecoAquisicao(Double.parseDouble(txtPrecoAquisicao.getText()));
			
			Connection conn = DB.getConnection();
			PreparedStatement st = null;
			try {
				st = conn.prepareStatement(
						"INSERT INTO equipamentos VALUES"
						+ "(id, ?, ?, ?, ?, ?");
				st.setString(1, obj.getNomeProduto());
				st.setString(2, obj.getNumeroSerie());
				st.setString(3, obj.getFabricante());
				st.setDate(4, (Date) obj.getDataFabricacao());
				st.setDouble(5, obj.getPrecoAquisicao());
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
			finally {
				DB.closeStatement(st);
			}
		}
		System.out.println("Botão acionado fim");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Constraints.setTextFieldDouble(txtPrecoAquisicao);
	}

}
