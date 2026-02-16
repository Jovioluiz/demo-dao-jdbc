package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SellerDao {

	void insert(Seller dep);
	void update(Seller sel);
	void deleteById(Integer id);
	Seller findById(Integer Id);
	List<Seller> findAll();
	
}
