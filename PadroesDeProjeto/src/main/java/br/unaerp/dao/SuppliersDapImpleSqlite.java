package br.unaerp.dao;

import br.unaerp.dto.SuppliersDTO;
import br.unaerp.entity.Suppliers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuppliersDapImpleSqlite implements SuppliersDAO {

    public List<Suppliers> getSuppliers() throws SQLException {
        String query = "select * from suppliers";
        List<Suppliers> suppliers = new ArrayList<Suppliers>();


        PreparedStatement preparedStatement = SQLITEDAOFactory.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();


        while (resultSet.next()) {
            suppliers.add(new Suppliers(resultSet.getInt("supplier_id"),
                    resultSet.getString("company_name"),
                    resultSet.getString("contact_name"),
                    resultSet.getString("contact_title"),
                    resultSet.getString("address"),
                    resultSet.getString("city"),
                    resultSet.getString("region"),
                    resultSet.getString("postal_code"),
                    resultSet.getString("country"),
                    resultSet.getString("phone"),
                    resultSet.getString("fax"),
                    resultSet.getString("homepage")));

        }

        return suppliers;
    }

    public void insert(SuppliersDTO suppliers) throws SQLException {
        String query = "insert into suppliers " +
                "(supplier_id , company_name , contact_name , contact_title " +
                ", address , city , region , postal_code , country , phone " +
                ", fax , homepage) value (? , ?  ,? , ? , ? , ?, ? , ? , ? , ? , ? , ? )";

        PreparedStatement preparedStatement = SQLITEDAOFactory.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, suppliers.getSupplierId());
        preparedStatement.setString(2, suppliers.getCompanyName());
        preparedStatement.setString(3, suppliers.getContactName());
        preparedStatement.setString(4, suppliers.getContactTitle());
        preparedStatement.setString(5, suppliers.getAddress());
        preparedStatement.setString(6, suppliers.getCity());
        preparedStatement.setString(7, suppliers.getRegion());
        preparedStatement.setString(8, suppliers.getPostalCode());
        preparedStatement.setString(9, suppliers.getCountry());
        preparedStatement.setString(10, suppliers.getPhone());
        preparedStatement.setString(11, suppliers.getFax());
        preparedStatement.setString(12, suppliers.getHomePage());


        preparedStatement.execute();
    }

    public void update(SuppliersDTO suppliers) throws SQLException {
        String query = "update suppliers set" +
                "(company_name = ? , contact_name = ?, contact_title = ?" +
                ", address = ?, city = ?, region = ?, postal_code = ?, country = ?, phone = ?" +
                ", fax = ?, homepage = ?) where supplier_id = ?";

        PreparedStatement preparedStatement = MYSQLDAOFactory.getConnection().prepareStatement(query);

        preparedStatement.setString(1, suppliers.getCompanyName());
        preparedStatement.setString(2, suppliers.getContactName());
        preparedStatement.setString(3, suppliers.getContactTitle());
        preparedStatement.setString(4, suppliers.getAddress());
        preparedStatement.setString(5, suppliers.getCity());
        preparedStatement.setString(6, suppliers.getRegion());
        preparedStatement.setString(7, suppliers.getPostalCode());
        preparedStatement.setString(8, suppliers.getCountry());
        preparedStatement.setString(9, suppliers.getPhone());
        preparedStatement.setString(10, suppliers.getFax());
        preparedStatement.setString(11, suppliers.getHomePage());
        preparedStatement.setInt(12, suppliers.getSupplierId());


        preparedStatement.execute();
    }

    public void delete(int id) throws SQLException {
        String query = "delete from suppliers where supplier_id = '" + id + "'";

        PreparedStatement preparedStatement = SQLITEDAOFactory.getConnection().prepareStatement(query);
        preparedStatement.execute();
    }

    public Suppliers getSuppllier(int id) throws SQLException {
        String query = "select * from suppliers where supplier_id = '" + id + "'";
        Suppliers suppliers = null;


        PreparedStatement preparedStatement = SQLITEDAOFactory.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();


        while (resultSet.next()) {
            suppliers = new Suppliers(resultSet.getInt("supplier_id"),
                    resultSet.getString("company_name"),
                    resultSet.getString("contact_name"),
                    resultSet.getString("contact_title"),
                    resultSet.getString("address"),
                    resultSet.getString("city"),
                    resultSet.getString("region"),
                    resultSet.getString("postal_code"),
                    resultSet.getString("country"),
                    resultSet.getString("phone"),
                    resultSet.getString("fax"),
                    resultSet.getString("homepage"));

        }

        return suppliers;
    }
}
