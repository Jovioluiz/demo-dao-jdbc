package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Departament;

public class Program {

	public static void main(String[] args) {
		
		Departament dep = new Departament(1, "livros");
		System.out.println(dep);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();

	}

}
