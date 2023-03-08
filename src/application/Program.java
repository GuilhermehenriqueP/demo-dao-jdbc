package application;


import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		
		
		Department obj = new Department(1, "Books");
		
		System.out.println(obj);
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller find by Id ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("=== TEST 1: seller find by Id ===");
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj1 : list) {
			System.out.println(obj1);
			
		}
		System.out.println("=== TEST 3: seller find all ===");
		list = sellerDao.findAll();
		for(Seller obj1 : list) {
			System.out.println(obj1);
			
		}
		
		System.out.println("=== TEST 4: insert new seller  ===");
		Seller newSeller = new Seller(null,"Greg", "greg@gmail.com", new Date(), 400.0,department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("=== TEST 5: Update a seller  ===");
		seller = sellerDao.findById(1);
		seller.setName("Marta Waine");
		sellerDao.update(seller);
		System.out.println("Seller update complete");
	}
}
