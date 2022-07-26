package edu.mutilcamp.dao;

import DBConnection.DBConnection;
import edu.mutilcamp.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface UserDao {
    public User getUserByEmailAndPassword(String email, String password);
    public void getAllUsers(); //Dùng cho TRUY VẤN (SELECT)
    public void insertUsers(); //Dùng cho TRUY VẤN (SELECT)
    public User getUserByEmail(String email); //Dùng cho TRUY VẤN (SELECT)
    public String getNameById(int id); //Dùng cho TRUY VẤN (SELECT)
    public List<User> getAllEmployees(); //Dùng cho TRUY VẤN (SELECT)
    public void saveUser(User user); //Dùng cho THÊM dữ liệu (INSERT INTO)
    public void updateUser(User user); //Dùng cho SỬA dữ liệu (UPDATE)
    public void deleteUser(int id); //Dùng cho XÓA dữ liệu (DELETE FROM)

    public List<User> getAllUserById(int id);
}
