package br.unaerp.dao;

import br.unaerp.dto.CategoriesDTO;
import br.unaerp.entity.Categories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDaoImpleMySql implements CategoriesDAO {

    public List<Categories> getCategories() throws SQLException {

        List<Categories> listaCategoria = new ArrayList<Categories>();
        String query = "select * from categoria";

        PreparedStatement preparedStatement = MYSQLDAOFactory.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            listaCategoria.add(new Categories(resultSet.getInt("category_id"), resultSet.getString("category_name"), resultSet.getString("description"), resultSet.getString("picture")));
        }

        return listaCategoria;
    }

    public void insert(CategoriesDTO categories) throws SQLException {
        String query = "insert into categories (categories_id , category_name , description , piscture) value (? , ? , ? , ?)";

        PreparedStatement preparedStatement = MYSQLDAOFactory.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, categories.getCategoryId());
        preparedStatement.setString(2, categories.getCategoryName());
        preparedStatement.setString(3, categories.getDescription());
        preparedStatement.setString(4, categories.getPicture());

        preparedStatement.execute();

    }

    public void update(CategoriesDTO categories) throws SQLException {
        String updateCategoria = "update categories (categories_id = ?, category_name = ?, description = ?, piscture = ?) where categories_id = ?";

        PreparedStatement preparedStatement = MYSQLDAOFactory.getConnection().prepareStatement(updateCategoria);
        preparedStatement.setInt(1, categories.getCategoryId());
        preparedStatement.setString(2, categories.getCategoryName());
        preparedStatement.setString(3, categories.getDescription());
        preparedStatement.setString(4, categories.getPicture());
        preparedStatement.setInt(5, categories.getCategoryId());
        preparedStatement.execute();
    }

    public void delete(int id) throws SQLException {
        String delCategoria = "delete from categories where category_id = '" + id + "'";

        PreparedStatement preparedStatement = MYSQLDAOFactory.getConnection().prepareStatement(delCategoria);
        preparedStatement.execute();
    }

    public Categories show(int id) throws SQLException {
        Categories categories = null;
        String query = "select * from categories where category_id = '" + id + "'";

        PreparedStatement preparedStatement = MYSQLDAOFactory.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            categories = new Categories(resultSet.getInt("category_id")
                    , resultSet.getString("category_name"), resultSet.getString("description"), resultSet.getString("picture"));
        }
        return categories;
    }
}