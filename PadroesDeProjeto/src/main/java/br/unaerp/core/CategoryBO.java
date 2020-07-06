package br.unaerp.core;

import br.unaerp.dao.DAOFactory;
import br.unaerp.dto.CategoriesDTO;
import br.unaerp.entity.Categories;

import java.sql.SQLException;
import java.util.List;

public class CategoryBO {
    private final DAOFactory daoFactory;

    public CategoryBO(int option) {
        daoFactory = DAOFactory.getDAOFactory(option);
    }

    public void insert(CategoriesDTO categoriesDTO) throws SQLException {
        System.out.println("Inserindo nova categoria");
        daoFactory.getCategoriesDAO().insert(categoriesDTO);
        System.out.println("Categoria inserida");
    }

    public void update(CategoriesDTO categoriesDTO) throws SQLException {
        System.out.println("Atualizando nova categoria");
        daoFactory.getCategoriesDAO().update(categoriesDTO);
        System.out.println("Categoria atualizada");
    }

    public List<Categories> getCategories() throws SQLException {
        System.out.println("Listando categorias");
        return daoFactory.getCategoriesDAO().getCategories();
    }

    public void delete(int id) throws SQLException{
        System.out.println("Apagando categoria com id " + id);
        daoFactory.getCategoriesDAO().delete(id);
        System.out.println("Apagado!");
    }

    public Categories getCategorie(int id) throws SQLException {
        System.out.println("Buscando categoria com o id " + id);
        return daoFactory.getCategoriesDAO().show(id);
    }
}
