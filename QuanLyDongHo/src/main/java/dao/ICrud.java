package dao;

import java.util.ArrayList;

public interface ICrud<T> {
    public boolean create(T Obj);
    public T readByID(int ID);
    public ArrayList<T> readAllData();
    public boolean update(int ID, T Obj);
    public boolean delete(int id);
    public boolean recovery(int id);
}