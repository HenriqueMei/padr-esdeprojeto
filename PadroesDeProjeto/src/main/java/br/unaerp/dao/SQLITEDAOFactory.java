package br.unaerp.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLITEDAOFactory extends DAOFactory {


    public static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:database.db");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public CategoriesDAO getCategoriesDAO() {
        return new CategoriesDaoImpleSqlite();
    }

    public ProductsDAO getProductsDAO() {
        return new ProductDaoImpleSqlite();
    }

    public SuppliersDAO getSuppliersDAO() {
        return new SuppliersDapImpleSqlite();
    }
}
