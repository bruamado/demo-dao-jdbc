package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Program {

    public static void main(String[] args) throws ParseException {

        System.out.println("Seller Table:");
        SellerDao sellerDao = DaoFactory.createSellerDao();
        List<Seller> sellerTable = new ArrayList<>();
        sellerTable = sellerDao.findAll();
        sellerTable.forEach(System.out::println);
        System.out.println();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println("seller = " + seller);
        System.out.println();

        System.out.println("=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        list.forEach(System.out::println);
        System.out.println();

        System.out.println("=== TEST 3: seller findAll ===");
        List<Seller> list2 = sellerDao.findAll();
        list2.forEach(System.out::println);
        System.out.println();

        System.out.println("=== TEST 4: seller deleteById ===");
        Seller deleted = sellerDao.deleteById(7);
        System.out.println("deleted = " + deleted);
        System.out.println();

        System.out.println("=== TEST 5: seller insert ===");
        //Seller to insert:
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date birthDate = sdf.parse("02/02/1995");
        Department dep = new Department(2, null);
        Seller sellerToInsert = new Seller(null, "Bruno Amado", "bru-a@hotmail.com", birthDate, 8000.0, dep);
        sellerDao.insert(sellerToInsert);
        if (!(sellerToInsert.getId() == null)) {
            System.out.println("Seller inserted with success = " + sellerToInsert);
        }
        else{
            System.out.println("Error trying to insert seller.");
        }
        System.out.println();

        System.out.println("=== TEST 6: seller update ===");
        seller = sellerDao.findById(1);
        seller.setName(seller.getName() + " Updated");
        sellerDao.update(seller);
        System.out.println("Update completed!");
        System.out.println();

        System.out.println("Seller Table:");
        sellerTable = sellerDao.findAll();
        sellerTable.forEach(System.out::println);

        DB.closeConnection();
    }
}
