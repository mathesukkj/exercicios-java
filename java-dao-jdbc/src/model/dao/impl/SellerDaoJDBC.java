package model.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

    private Connection conn;

    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void deleteById(int id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("delete from seller where Id = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Seller> findAll() {
        List<Seller> list = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        Map<Integer, Department> map = new HashMap<>();

        try {
            st = conn.prepareStatement(
                    "select seller.*, department.Name as "
                            + "depname from seller inner join department on "
                            + "seller.DepartmentId = department.Id order by Name");
            rs = st.executeQuery();

            while (rs.next()) {
                Department dep = map.get(rs.getInt("DepartmentId"));
                if (dep == null) {
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }
                list.add(instantiateSeller(rs, dep));
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public Seller findById(int id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st = conn.prepareStatement(
                    "SELECT seller.*, department.Name AS DepName "
                            + "FROM seller INNER JOIN department "
                            + "ON seller.DepartmentId = department.Id "
                            + "WHERE seller.Id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Department dep = instantiateDepartment(rs);
                Seller seller = instantiateSeller(rs, dep);
                return seller;
            }
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    public Department instantiateDepartment(ResultSet rs) throws Exception {
        Department dep = new Department();
        dep.setId(rs.getInt("DepartmentId"));
        dep.setName(rs.getString("DepName"));
        return dep;
    }

    public Seller instantiateSeller(ResultSet rs, Department dep) throws Exception {
        Seller seller = new Seller();
        seller.setId(rs.getInt("Id"));
        seller.setName(rs.getString("Name"));
        seller.setEmail(rs.getString("Email"));
        seller.setBaseSalary(rs.getDouble("BaseSalary"));
        seller.setBirthDate(rs.getDate("BirthDate").toLocalDate());
        seller.setDepartment(dep);
        return seller;
    }

    @Override
    public List<Seller> findByDepartment(Department dep) {
        List<Seller> list = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st = conn.prepareStatement(
                    "select seller.*, department.Name as "
                            + "depname from seller inner join department on "
                            + "seller.DepartmentId = department.Id "
                            + "where DepartmentId = ? order by Name");
            st.setInt(1, dep.getId());
            rs = st.executeQuery();

            while (rs.next()) {
                list.add(instantiateSeller(rs, dep));
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public void insert(Seller sel) {
        PreparedStatement st = null;

        try {

            st = conn.prepareStatement(
                    "insert into seller "
                            + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                            + "VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setString(1, sel.getName());
            st.setString(2, sel.getEmail());
            st.setDate(3, Date.valueOf(sel.getBirthDate()));
            st.setDouble(4, sel.getBaseSalary());
            st.setInt(5, sel.getDepartment().getId());

            int rows = st.executeUpdate();
            if (rows > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    sel.setId(id);
                }
                DB.closeResultSet(rs);
                System.out.println("Done. Affected: " + rows);
            } else {
                throw new DbException("No rows affected! Weird isnt it? ");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Seller sel) {
        PreparedStatement st = null;

        try {

            st = conn.prepareStatement(
                    "update seller "
                            + "set Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? "
                            + "where Id = ?");
            st.setString(1, sel.getName());
            st.setString(2, sel.getEmail());
            st.setDate(3, Date.valueOf(sel.getBirthDate()));
            st.setDouble(4, sel.getBaseSalary());
            st.setInt(5, sel.getDepartment().getId());
            st.setInt(6, sel.getId());

        } catch (Exception e) {
            e.printStackTrace();
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }

    }

}