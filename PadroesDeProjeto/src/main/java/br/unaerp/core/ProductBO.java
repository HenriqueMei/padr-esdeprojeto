package br.unaerp.core;

import br.unaerp.dao.DAOFactory;
import br.unaerp.dto.CategoriesDTO;
import br.unaerp.dto.ProductsDTO;
import br.unaerp.entity.Categories;
import br.unaerp.entity.Products;

import java.sql.SQLException;
import java.util.List;

public class ProductBO {
    private final DAOFactory daoFactory;

    public ProductBO(int option) {
        daoFactory = DAOFactory.getDAOFactory(option);
    }

    public void insert(ProductsDTO categoriesDTO) throws SQLException {
        System.out.println("Inserindo nova categoria");
        daoFactory.getProductsDAO().insert(categoriesDTO);
        System.out.println("Categoria inserida");
    }

    public void update(ProductsDTO categoriesDTO) throws SQLException {
        System.out.println("Atualizando nova categoria");
        daoFactory.getProductsDAO().update(categoriesDTO);
        System.out.println("Categoria atualizada");
    }

    public List<Products> getProducts() throws SQLException {
        System.out.println("Listando categorias");
        return daoFactory.getProductsDAO().getProducts();
    }

    public void delete(int id) throws SQLException{
        System.out.println("Apagando produto com id " + id);
        daoFactory.getProductsDAO().delete(id);
        System.out.println("Apagado!");
    }

    public Products getProduct(int id) throws SQLException {
        System.out.println("Buscando categoria com o id " + id);
        return daoFactory.getProductsDAO().getProduct(id);
    }
}
