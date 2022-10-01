package app.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDao<T> {

    public boolean create(T objeto) throws SQLException;

    public boolean update(T objeto) throws SQLException;

    public boolean drop(int id) throws SQLException;

    public T findById(int id) throws SQLException;

    public ArrayList<T> findAll() throws SQLException;
    
    public boolean activate(int id) throws SQLException;

    public ArrayList<T> findAllLike(String param) throws SQLException;
    
    public int last() throws SQLException;
}
