package model.dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public interface SellerDao {
    void insert(Seller sel);

    void update(Seller sel);

    void deleteById(int id);

    Seller findById(int id);

    List<Seller> findByDepartment(Department department);

    List<Seller> findAll();
}
