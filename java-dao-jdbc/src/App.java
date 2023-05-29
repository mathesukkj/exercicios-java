import java.time.LocalDate;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("\n===== FIRST TEST: seller findById =====");
        Seller sellerById = sellerDao.findById(1);
        System.out.println(sellerById);

        System.out.println("\n===== SECOND TEST: seller findByDepartment =====");
        List<Seller> list = sellerDao.findByDepartment(new Department(2, null));
        for (Seller seller : list) {
            System.out.println(seller);
        }

        System.out.println("\n===== THIRD TEST: seller findAll =====");
        list = sellerDao.findAll();
        for (Seller seller : list) {
            System.out.println(seller);
        }

        System.out.println("\n===== FOURTH TEST: seller insert =====");
        sellerDao.insert(new Seller(null, "inserted", "inserted@mail.com",
                LocalDate.now(), 4000.0, new Department(2, null)));

        System.out.println("\n===== FIFTH TEST: seller update =====");
        sellerById.setName("Sidoka");
        sellerDao.update(sellerById);
        System.out.println(sellerById);

        System.out.println("\n===== SIXTH TEST: seller delete =====");
        sellerDao.deleteById(7);
        System.out.println("DELETED!");

        DepartmentDao depDao = DaoFactory.createDepDao();

        System.out.println("\n===== FIRST TEST: dep findAll =====");
        List<Department> list2 = depDao.findAll();
        for (Department dep : list2) {
            System.out.println(dep);
        }

        System.out.println("\n===== SECOND TEST: dep findById =====");
        Department dep = depDao.findById(2);
        System.out.println(dep);

        System.out.println("\n===== THIRD TEST: dep insert =====");
        depDao.insert(new Department(null, "inserted"));

        System.out.println("\n===== FOURTH TEST: seller update =====");
        dep.setName("updated");
        depDao.update(dep);
        System.out.println(dep);

        System.out.println("\n===== FIFTH TEST: department delete =====");
        depDao.deleteById(5);
        System.out.println("DELETED!");
    }
}
