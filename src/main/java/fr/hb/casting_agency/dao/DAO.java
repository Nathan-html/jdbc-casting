package fr.hb.casting_agency.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T, ID> {
    // Read all
    List<T> get() throws SQLException;

    // Read one
    T getById(ID id) throws SQLException;

    // Create
    void save(T t) throws SQLException;

    // update all
    Integer update(T t) throws SQLException;

    // update one
    void updateById(ID id);

    // delete one
    void deleteById(ID id) throws SQLException;
}
