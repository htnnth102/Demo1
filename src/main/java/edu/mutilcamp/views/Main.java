package edu.mutilcamp.views;

import edu.mutilcamp.dao.EmployeeDao;
import edu.mutilcamp.dao.UserDao;
import edu.mutilcamp.daoimplement.EmployeeDAOImplement;
import edu.mutilcamp.daoimplement.UserDAOImplement;
import edu.mutilcamp.model.Employee;
import edu.mutilcamp.model.User;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static boolean exit = false;
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        showLogin();
    }

    private static void showLogin() {
        User  u = new User();
        boolean check = false ;
        do {
            System.out.println("Vui long nhap thong tin dang nhap");
            Scanner sc = new Scanner(System.in);
            System.out.println("UserName: ");
            String email = sc.nextLine();
            System.out.println("Firstname: ");
            String firstname = sc.nextLine();
            UserDao userDao = new UserDAOImplement();
            if (userDao.getUserByEmailAndPassword(email, firstname) != null) {
                check = true;
                u = userDao.getUserByEmailAndPassword(email, firstname);
                System.out.println("Dang nhap thanh cong");
                menu();
            } else {
                System.out.println("Dang nhap that bai");
            }
        }
        while (!check);

    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("------MENU------");
            System.out.println("1. Hien thi thong tin theo id");
            System.out.println("2. Hien thi thong tin theo ten");
            System.out.println("3. Hien thi thong tin theo email");
            System.out.println("4. Hien thi danh sach nhan vien");
            System.out.println("5. Sua thong tin nhan vien");
            System.out.println("6. Them nhan vien moi");
            System.out.println("7. Xoa nhan vien");
            System.out.println("8. Thoat");
            System.out.println("Your choice?");
            int choice = sc.nextInt(); sc.nextLine();
            switch (choice) {
                case 1:
                    displayUserById(2);
                    break;
                case 2:
                    displayUserByName("Ngan");
                    break;
                case 3:

                    displayUserByEmail("htnnthhtn@gmail.com");
//                    System.out.println("Nhap email user");
//                    String email = sc.nextLine();
//                    displayUserByEmail(email);
                    break;
                case 4:
                    break;
                case 5:
                    updateUser();
                    break;
                case 6:
                    addNewUser();
                    break;
                case 7:
                    deleteUser();
                    break;
                case 8:
                    exit = true;
                    System.out.println("Exiting....");
                    break;
                default:
                    System.out.println("Vui long chon lai 1-8");
                    continue;
            }
        }
         while (!exit);
    }
    static UserDao ud = new UserDAOImplement();

    static void displayUserByEmail(String email) {
//        UserDAOImplement userD = new UserDAOImplement();
//        User u = userD.getUserByEmail(email);
        System.out.println("Thong tin nhan vien co email = " + email);
//        System.out.println(u.toString());
    }

    static  void displayUserById(int id) {
        System.out.println("Nhap ID");
        id = input.nextInt(); input.nextLine();
        System.out.println("Id = " + id)  ;
        System.out.println("Ban co muon tiep tuc khong");
        int anwser = new Scanner(System.in).nextInt();
        if ( anwser == 0) {
            exit = true;
        }
    }

    static  void displayUserByName(String name) {
        System.out.println("Name = " + name);
    }

    static void addNewUser() {
        System.out.println("Them mot nguoi dung moi");
        System.out.println("Nhap email");
        String email = input.nextLine();
        System.out.println("Nhap firstname");
        String firstname = input.nextLine();
        User u = new User();
        u.setEmail(email); u.setFirstName(firstname);
        ud.saveUser(u);
    }

    static void updateUser() {
        System.out.println("Nhap ID de sua: ");
        int id = input.nextInt(); input.nextLine();
        User u = new User(id);
        ud.updateUser(u);
    }

    static void deleteUser() {
        System.out.println("Nhap ID de xoa: ");
        int id = input.nextInt(); input.nextLine();
        if (ud.getAllUserById(id) != null) {
            ud.deleteUser(id);
        }
        else {
            JOptionPane.showConfirmDialog(null, "Ma NV: " + id + "khong ton ta i trong CSDL");
        }
    }

}
