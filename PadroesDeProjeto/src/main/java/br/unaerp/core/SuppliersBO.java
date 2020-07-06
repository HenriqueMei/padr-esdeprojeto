package br.unaerp.core;

import br.unaerp.dao.DAOFactory;
import br.unaerp.dto.SuppliersDTO;
import br.unaerp.entity.Suppliers;

import java.sql.SQLException;
import java.util.List;

public class SuppliersBO {
    private final DAOFactory daoFactory;

    public SuppliersBO(int option) {
        daoFactory = DAOFactory.getDAOFactory(option);
    }

    public void insert(SuppliersDTO suppliersDTO) throws SQLException {
        System.out.println("Inserindo novo fornecedor");
        daoFactory.getSuppliersDAO().insert(suppliersDTO);
        System.out.println("Fornecedor inserido");
    }

    public void update(SuppliersDTO suppliersDTO) throws SQLException {
        System.out.println("Atualizando fornecedor");
        daoFactory.getSuppliersDAO().update(suppliersDTO);
        System.out.println("Fornecedor atualizada");
    }

    public List<Suppliers> getSuppliers() throws SQLException {
        System.out.println("Listando fornecedores");
        return daoFactory.getSuppliersDAO().getSuppliers();
    }

    public void delete(int id) throws SQLException{
        System.out.println("Apagando fornecedor com id " + id);
        daoFactory.getSuppliersDAO().delete(id);
        System.out.println("Apagado!");
    }

    public Suppliers getSupplier(int id) throws SQLException {
        System.out.println("Buscando fornecedor com o id " + id);
        return daoFactory.getSuppliersDAO().getSuppllier(id);
    }
}
