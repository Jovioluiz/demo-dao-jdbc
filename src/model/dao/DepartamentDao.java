package model.dao;

import java.util.List;

import model.entities.Departament;

public interface DepartamentDao {
	
	void insert(Departament dep);
	void update(Departament dep);
	void deleteById(Integer id);
	Departament findById(Integer Id);
	List<Departament> findAll();

}
