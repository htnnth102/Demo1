package edu.mutilcamp.daoimplement;

import DBConnection.DBConnection;
import edu.mutilcamp.dao.EmployeeDao;
import edu.mutilcamp.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImplement implements EmployeeDao {
    @Override
    public Employee getEmployeeById(int id) {
        return null;
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return null;
    }

    @Override
    public void getEmployeeByEmail(String email) {

    }

    @Override
    public String getNameById(int id) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>(); //list of all Employees

        try {
            DBConnection dbc = new DBConnection("employeemanage");
            dbc.ConnectionDB();
            String sql = "select * from Employee";
            PreparedStatement preparedStatement = dbc.getConn().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            //Bước 3: Xử lý kết quả trả về
            while (rs.next()){
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setFullName(rs.getString("fullName"));
                employee.setEmail(rs.getString("email"));
                employee.setHoursWorkPerDay(rs.getInt("work_hour"));
                employee.setLong_work(rs.getInt("long_work"));
                employee.setFixSalary(rs.getDouble("fixed_salary"));
                employee.setOutsideServiceNumber(rs.getDouble("outside_service_number"));
                list.add(employee);
            }
            //Buoc 4: dong ket noi
            list.forEach(System.out::println);
            dbc.disConnectDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void saveEmployee(Employee emp) {
        try {
            DBConnection dbc = new DBConnection("employeemanage");
            dbc.ConnectionDB();
            String sql = "insert into employee (fullname, email) values (?, ?)";
            PreparedStatement preparedStatement = dbc.getConn().prepareStatement(sql);
//            tap trung van de insert
//            trong truong hop email co constraint unique thi phai check email truoc khi insert
            preparedStatement.setString(1, emp.getFullName());
            preparedStatement.setString(2, emp.getEmail());
            int numberOfRecords = preparedStatement.executeUpdate();
            //Bước 3: Xử lý kết quả trả về
           if (numberOfRecords != 0 ){
               System.out.println("Ban ghi duoc luu thanh cong");
            } else {
               System.out.println("Ban ghi khong the luu");
           }
            //Buoc 4: dong ket noi
            dbc.disConnectDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateEmployee(Employee emp) {
        try {
            DBConnection dbc = new DBConnection("employeemanage");
            dbc.ConnectionDB();
            String sql = "insert into employee (fullname, email) values (?, ?)";
            PreparedStatement preparedStatement = dbc.getConn().prepareStatement(sql);
//            tap trung van de insert
//            trong truong hop email co constraint unique thi phai check email truoc khi insert
            preparedStatement.setString(1, emp.getFullName());
            preparedStatement.setString(2, emp.getEmail());
            int numberOfRecords = preparedStatement.executeUpdate();
            //Bước 3: Xử lý kết quả trả về
            if (numberOfRecords != 0 ){
                System.out.println("Ban ghi duoc luu thanh cong");
            } else {
                System.out.println("Ban ghi khong the luu");
            }
            //Buoc 4: dong ket noi
            dbc.disConnectDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEmployee(Employee emp) {

    }
}
