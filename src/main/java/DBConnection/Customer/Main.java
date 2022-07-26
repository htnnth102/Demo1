package DBConnection.Customer;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Customer> lstCust = new ArrayList<>();
    static boolean exit = false;


    public static void main(String[] args) throws ParseException {
        boolean check = false;
        do {
            menu();
        }
        while (!check);
    }

    public static void menu() throws ParseException {
        do {
            System.out.println("----------MENU-----------");
            System.out.println("1. Nhap thong tin khach hang");
            System.out.println("2. Hien thi thong tin khach hang");
            System.out.println("3. Luu vao file");
            System.out.println("4. Doc danh sach hang tu o cung");
            System.out.println("5. Thoat");
            int choice = sc.nextInt(); sc.nextLine();
            switch (choice) {
                case 1:
                    input();
                    break;
                case 2:
                    display(lstCust);
                    break;
                case 3:
                    System.out.println("Vi tri tep ma ban muon luu");
                    String pathToWrite = sc.nextLine();
                    writeToFileSerial(pathToWrite);
                    break;
                case 4:
                    System.out.println("Vi tri tep ma ban muon doc");
                    String pathToRead = sc.nextLine();
                    ReadFromFile(pathToRead);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Vui long chon tu 1-3");
                    continue;
            }
        } while (!exit);
    }
    public static void input() throws ParseException {
        System.out.println("Ban muon nhap bao nhieu khach hang?");
        int i = sc.nextInt(); sc.nextLine();
        for(int j = 0; j < i; j++) {
            System.out.println("Nhap ID");
            int id = sc.nextInt(); sc.nextLine();
            System.out.println("Nhap ten");
            String name = sc.nextLine();
            System.out.println("Nhap nam sinh");
            Date yob = new SimpleDateFormat("yyyy").parse(sc.nextLine());
            Customer c = new Customer(id, name, yob);
            lstCust.add(c);
        }
    }

    public static void display(List<Customer> list) {
        list.stream().forEach(System.out::println);
    }
// Luu danh sach khach hang vao o cung
    public static void writeToFile(String path) {
        System.out.println("Luu du lieu vao file");

        File file = new File(path);
        try (FileWriter fw = new FileWriter(file)) {

            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            // get the content in bytes
            for (Customer ct : lstCust) {
                fw.write(ct.toString());
                fw.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ReadFromFile(String path) {
        File file = new File(path);
        try (FileReader fr = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    Serializable
// FileOutputStream co the ghi hang loat cac object tu danh sach vao File
    public static void writeToFileSerial(String path) {
        System.out.println("Luu du lieu vao file");
        File file = new File(path);
        try (FileOutputStream fos = new FileOutputStream(file)) {
                ObjectOutputStream oos = new ObjectOutputStream(fos);
            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            // get the content in bytes
            oos.writeObject(lstCust);
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

