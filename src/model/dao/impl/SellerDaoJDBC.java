package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Departament;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection con;
	
	public SellerDaoJDBC(Connection con) {
		this.con = con;
	}
	
	
	@Override
	public void insert(Seller dep) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller sel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer Id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = con.prepareStatement("select seller.*, department.name as depname" +
									  "from seller " +
									  "join department on seller.departmentid = department.id " +
									  "where seller.id = ?");
			st.setInt(1, Id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				Departament dep = new Departament();
				
				dep.setId(rs.getInt("DepartmentId"));
				dep.setName(rs.getString("depname"));
				
				Seller sel = new Seller();
				
				sel.setId(rs.getInt("Id"));
				sel.setName(rs.getString("Name"));
				sel.setEmail(rs.getString("Email"));
				sel.setBaseSalary(rs.getDouble("BaseSalary"));
				sel.setBirthDate(rs.getDate("BirthDate"));
				sel.setDepartament(dep);
				
				return sel;
				
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
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
