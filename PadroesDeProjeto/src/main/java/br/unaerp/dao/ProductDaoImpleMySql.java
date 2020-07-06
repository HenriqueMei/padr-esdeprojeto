package br.unaerp.dao;

import br.unaerp.dto.ProductsDTO;
import br.unaerp.entity.Products;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpleMySql implements ProductsDAO {
    public List<Products> getProducts() throws SQLException {
        String query = "select * from products";
        List<Products> products = new ArrayList<Products>();

        PreparedStatement preparedStatement = MYSQLDAOFactory.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            products.add(new Products(resultSet.getInt("product_id"), resultSet.getString("product_name")
                    , resultSet.getInt("supplier_id"), resultSet.getInt("category_id")
                    , resultSet.getInt("quantity_per_unit"), resultSet.getDouble("unit_price")
                    , resultSet.getInt("unit_in_stock"), resultSet.getInt("units_in_order")
                    , resultSet.getInt("reorder_level"), resultSet.getInt("discontinued")));
        }


        return products;
    }

    public void update(ProductsDTO products) throws SQLException {
        String query =
                "update products set(product_name = ?" +
                        ", supplier_id = ?, category_id = ?, quantity_per_unit = ?" +
                        ", unit_price = ?, units_in_stock = ?, units_on_order = ?" +
                        ", reorder_level = ?, discontinued = ?) where product_id = ?";

        PreparedStatement preparedStatement = MYSQLDAOFactory.getConnection().prepareStatement(query);

        preparedStatement.setString(1, products.getProductName());
        preparedStatement.setInt(2, products.getSupplierId());
        preparedStatement.setInt(3, products.getCategoryId());
        preparedStatement.setInt(4, products.getQuantityPerUnit());
        preparedStatement.setDouble(5, products.getUnitPrice());
        preparedStatement.setInt(6, products.getUnitsInStock());
        preparedStatement.setInt(7, products.getUnitsOnOrder());
        preparedStatement.setInt(8, products.getReorderLevel());
        preparedStatement.setInt(9, products.getDiscontinued());
        preparedStatement.setInt(10, products.getPruductId());


        preparedStatement.execute();
    }

    public void insert(ProductsDTO products) throws SQLException {
        String query =
                "insert into products (product_id , product_name " +
                        ", supplier_id , category_id , quantity_per_unit " +
                        ", unit_price , units_in_stock , units_on_order " +
                        ", reorder_level , discontinued) value (? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";

        PreparedStatement preparedStatement = MYSQLDAOFactory.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, products.getPruductId());
        preparedStatement.setString(2, products.getProductName());
        preparedStatement.setInt(3, products.getSupplierId());
        preparedStatement.setInt(4, products.getCategoryId());
        preparedStatement.setInt(5, products.getQuantityPerUnit());
        preparedStatement.setDouble(6, products.getUnitPrice());
        preparedStatement.setInt(7, products.getUnitsInStock());
        preparedStatement.setInt(8, products.getUnitsOnOrder());
        preparedStatement.setInt(9, products.getReorderLevel());
        preparedStatement.setInt(10, products.getDiscontinued());


        preparedStatement.execute();
    }

    public void delete(int id) throws SQLException {
        String query = "delete from products where id = '" + id + "'";

        PreparedStatement preparedStatement = MYSQLDAOFactory.getConnection().prepareStatement(query);
        preparedStatement.execute();
    }

    public Products getProduct(int id) throws SQLException {
        String query = "select * from products where product_id = '" + id + "'";
        Products products = null;

        PreparedStatement preparedStatement = MYSQLDAOFactory.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            products = new Products(resultSet.getInt("product_id"), resultSet.getString("product_name")
                    , resultSet.getInt("supplier_id"), resultSet.getInt("category_id")
                    , resultSet.getInt("quantity_per_unit"), resultSet.getDouble("unit_price")
                    , resultSet.getInt("unit_in_stock"), resultSet.getInt("units_in_order")
                    , resultSet.getInt("reorder_level"), resultSet.getInt("discontinued"));
        }

        return products;
    }
}
