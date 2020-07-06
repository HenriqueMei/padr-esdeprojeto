package br.unaerp.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MYSQLDAOFactory extends DAOFactory {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return null;
    }


    public CategoriesDAO getCategoriesDAO() {
        return new CategoriesDaoImpleMySql();
    }

    public ProductsDAO getProductsDAO() {
        return new ProductDaoImpleMySql();
    }

    public SuppliersDAO getSuppliersDAO() {
        return new SuppliersDapImpleMySql();
    }
}
