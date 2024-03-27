package dao;

import java.util.ArrayList;

public interface ICrud<T> {
    public String create(T Obj);
    public T readByID(String ID);
    public ArrayList<T> readAllData();
    public boolean update(String ID, T Obj);
    public boolean delete(T Obj);
}