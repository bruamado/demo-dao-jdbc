package application;

import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {

    public static void main(String[] args) {

        Department obj = new Department(1, "Books");
        System.out.println("obj = " + obj);

        Seller seller = new Seller(21, "Bob Brown", "bob@gmail.com", new Date(), 3000.0, obj);
        System.out.println("seller = " + seller);
    }
}