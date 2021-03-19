package model.dao;

import java.util.List;

import model.entities.Equipamento;

public interface EquipamentoDao {
	void insert(Equipamento obj);
	void update(Equipamento obj);
	void deleteById(Integer id);
	Equipamento findById(Integer id);
	List<Equipamento> findAll();
}
