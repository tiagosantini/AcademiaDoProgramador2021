package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dao.EquipamentoDao;
import model.entities.Equipamento;

public class EquipamentoDaoJDBC implements EquipamentoDao {
	
	private Connection conn;
	
	public EquipamentoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Equipamento obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Equipamento obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Equipamento findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM estoque WHERE id = ?");
			st.setInt(1, id);
			
			rs = st.executeQuery();
			if (rs.next()) {;
				Equipamento obj = new Equipamento();
				obj.setId(rs.getInt("Id"));;
				obj.setNomeProduto(rs.getString("nomeProduto"));
				obj.setPrecoAquisicao(rs.getDouble("precoAquisicao"));
				obj.setNumeroSerie(rs.getString("numeroSerie"));
				obj.setDataFabricacao(rs.getDate("BirthDate"));
				obj.setFabricante(rs.getString("fabricante"));
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Equipamento> findAll() {
		
		Connection conn = DB.getConnection();
		ResultSet rs = null;
		
		ObservableList<Equipamento> oblist = FXCollections.observableArrayList();
		
		try {
			rs = conn.createStatement().executeQuery("SELECT * FROM estoque");
			
			while(rs.next()) {
				oblist.add(new Equipamento(rs.getInt("id"),
						rs.getString("nomeProduto"), rs.getString("numeroSerie"), rs.getString("fabricante")));
			}
			return oblist;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
		}
	}
	
}
