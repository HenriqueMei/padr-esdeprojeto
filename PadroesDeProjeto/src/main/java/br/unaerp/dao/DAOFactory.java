package br.unaerp.dao;

public abstract class DAOFactory {
    public static final int MYSQL = 1;
    public static final int SQLITE = 2;

    public static DAOFactory getDAOFactory(int option) {
        switch (option) {
            case MYSQL:
                return new MYSQLDAOFactory();
            case SQLITE:
                return new SQLITEDAOFactory();
            default:
                return null;
        }
    }

    public abstract CategoriesDAO getCategoriesDAO();

    public abstract ProductsDAO getProductsDAO();

    public abstract SuppliersDAO getSuppliersDAO();
}
