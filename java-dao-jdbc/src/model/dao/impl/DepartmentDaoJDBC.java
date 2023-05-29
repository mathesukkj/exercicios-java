package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void deleteById(int id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("delete from department where Id = ?");
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
    public List<Department> findAll() {
        List<Department> list = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("select * from department");
            rs = st.executeQuery();

            while (rs.next()) {
                list.add(instantiateDepartment(rs));
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    @Override
    public Department findById(int id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st = conn.prepareStatement("SELECT * from department WHERE Id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Department dep = instantiateDepartment(rs);
                return dep;
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

    @Override
    public void insert(Department dep) {
        PreparedStatement st = null;

        try {

            st = conn.prepareStatement("insert into department (Name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, dep.getName());

            int rows = st.executeUpdate();
            if (rows > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    dep.setId(id);
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
    public void update(Department dep) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("update department set Name = ? where Id = ?");
            st.setString(1, dep.getName());
            st.setInt(2, dep.getId());
        } catch (Exception e) {
            e.printStackTrace();
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    public Department instantiateDepartment(ResultSet rs) throws Exception {
        Department dep = new Department();
        dep.setId(rs.getInt("Id"));
        dep.setName(rs.getString("Name"));
        return dep;
    }

}