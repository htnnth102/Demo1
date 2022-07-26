package edu.mutilcamp.daoimplement;

import DBConnection.DBConnection;
import edu.mutilcamp.dao.UserDao;
import edu.mutilcamp.model.Employee;
import edu.mutilcamp.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class UserDAOImplement implements UserDao {

    @Override
    public User getUserByEmailAndPassword(String email, String firstname) {

        try {
            DBConnection dbc = new DBConnection("employeemanage");
            dbc.ConnectionDB();
            String sql = "select * from User where email = ? and firstname = ?";
            PreparedStatement ps = dbc.getConn().prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, firstname);
            ResultSet rs = ps.executeQuery();
            //Bước 3: Xử lý kết quả trả về
            if (rs.next()) {
                User u = new User();
                u.setEmail(rs.getString("email"));
                u.setFirstName(rs.getString("firstname"));
                dbc.disConnectDB();
                return u;
            }
            //Buoc 4: dong ket noi
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  null;
    }

    @Override
    public void getAllUsers() {

    }

    @Override
    public void insertUsers() {

    }

    @Override
    public User getUserByEmail(String email) {

        return null;
    }

    @Override
    public String getNameById(int id) {
        return null;
    }

    @Override
    public List<User> getAllEmployees() {
        return null;
    }

    @Override
    public void saveUser(User user) {
        try {
            DBConnection dbc = new DBConnection("employeemanage");
            dbc.ConnectionDB();
            String sql = "insert into employee (fullname, email) values (?, ?)";
            PreparedStatement preparedStatement = dbc.getConn().prepareStatement(sql);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getFirstName());
            int numberOfRecords = preparedStatement.executeUpdate();
            //Bước 3: Xử lý kết quả trả về
            if (numberOfRecords != 0){
                System.out.println("Ban ghi da duoc luu thanh cong");
            } else {
                System.out.println("Khong the luu ban ghi");
            }
            //Buoc 4: dong ket noi
            dbc.disConnectDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUser(User user) {
            try {
                DBConnection dbc = new DBConnection("employeemanage");
                dbc.ConnectionDB();

                String sql = "update user set firstname = ?, lastname =? where id = ?";
                PreparedStatement preparedStatement = dbc.getConn().prepareStatement(sql);
                System.out.println("new Firstname: ");
                String firstName = new Scanner(System.in).nextLine();
                System.out.println("New Lastname: ");
                String lastName = new Scanner(System.in).nextLine();
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setInt(3, user.getId());
                int numberOfRecords = preparedStatement.executeUpdate();
                //Bước 3: Xử lý kết quả trả về
                if (numberOfRecords != 0 ){
                    System.out.println("Update thanh cong");
                } else {
                    System.out.println("Update that bai");
                }
                //Buoc 4: dong ket noi
                dbc.disConnectDB();


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

    }

    @Override
    public void deleteUser(int id) {
        try {
            DBConnection dbc = new DBConnection("employeemanage");
            dbc.ConnectionDB();
            String sql = "delete from user where id = ?";
            PreparedStatement preparedStatement = dbc.getConn().prepareStatement(sql);
            preparedStatement.setInt(1, id);
//            xac nhan tu nguoi dung xem co xoa hay khong
            int confirm = JOptionPane.showConfirmDialog(null, "Xoa thong tin nhan vien", "Warning!" + id, JOptionPane.YES_NO_OPTION);
            if (confirm ==0) {
                int numberOfRecords = preparedStatement.executeUpdate();
                if (numberOfRecords != 0 ){
                    System.out.println("Xoa thanh cong");
                } else {
                    System.out.println("User khong ton tai");
                }
            }
            //Bước 3: Xử lý kết quả trả về

            //Buoc 4: dong ket noi
            dbc.disConnectDB();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<User> getAllUserById(int id) {
        List<User> list = new ArrayList<>(); //list of all Employees

        try {
            DBConnection dbc = new DBConnection("employeemanage");
            dbc.ConnectionDB();
            String sql = "select * from User where id = ?";
            PreparedStatement preparedStatement = dbc.getConn().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            //Bước 3: Xử lý kết quả trả về
            while (rs.next()){
                User employee = new User();
                employee.setId(rs.getInt("id"));
                list.add(employee);
            }
            //Buoc 4: dong ket noi
            dbc.disConnectDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
