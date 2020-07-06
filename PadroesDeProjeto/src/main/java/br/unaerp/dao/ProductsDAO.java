package br.unaerp.dao;

import br.unaerp.dto.ProductsDTO;
import br.unaerp.entity.Products;

import java.sql.SQLException;
import java.util.List;

public interface ProductsDAO {
    List<Products> getProducts() throws SQLException;

    void update(ProductsDTO products) throws SQLException;

    void insert(ProductsDTO categories) throws SQLException;

    void delete(int id) throws SQLException;

    Products getProduct(int id) throws SQLException;
}
