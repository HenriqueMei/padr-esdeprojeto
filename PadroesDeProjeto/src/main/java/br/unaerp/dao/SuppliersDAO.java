package br.unaerp.dao;

import br.unaerp.dto.SuppliersDTO;
import br.unaerp.entity.Suppliers;

import java.sql.SQLException;
import java.util.List;

public interface SuppliersDAO {
    List<Suppliers> getSuppliers() throws SQLException;

    void insert(SuppliersDTO suppliers) throws SQLException;

    void update(SuppliersDTO suppliers) throws SQLException;

    void delete(int id) throws SQLException;

    Suppliers getSuppllier(int id) throws SQLException;
}
