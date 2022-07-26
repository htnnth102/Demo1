package edu.mutilcamp.model;

import edu.mutilcamp.daoimplement.EmployeeDAOImplement;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class DemoApachePoi {
    public static void main(String[] args) throws IOException {
        DemoApachePoi demo = new DemoApachePoi();
        demo.addToExcel();
        System.out.println("==============================");
        demo.readFromExcel();

    }

    public void addToExcel() {
        //        create blank workbook
        XSSFWorkbook  wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("Employee");


//        private int id;
//        private String fullName;
//        private String email;
//        private int hoursWorkPerDay;
//        private int long_work;
//        private double fixSalary;
//        private double outsideServiceNumber;
//
//        private double totalSalary;
//        TreeMap kieu du lieu luu tru voi key value - khong trung lap key
        EmployeeDAOImplement eD = new EmployeeDAOImplement();

        List<Employee> lst = eD.getAllEmployees();
        int index = 2;
        lst.stream().forEach(System.out::println);
        Map<Integer, Object[]> data = new TreeMap<Integer, Object[]>();
        data.put(1, new Object[] {"ID", "Fullname", "Email", "Hour_Word", "Long_Work", "Fixed_salary", "Outside_service_number"});
        for (Employee e : lst) {
            data.put(index, new Object[] {e.getId(), e.getFullName(), e.getEmail(), e.getHours_work_per_day(), e.getLong_work(),e.getFixSalary(), e.getOutsideServiceNumber()});
            index++;
        }
//        dong mở ngoặc vuông là bởi mỗi cột là một Object

        Set<Integer> keyset = data.keySet();
//        luu tru mot tap key lay ra tu Treemap ~ mot tap cac rows

        int rownum = 0;
        for (Integer key : keyset)
        {
            Row row = sheet.createRow(rownum++); // chi so cua hang chay trong excel
            Object [] objArr = (Object[]) data.get(key); // thong qua key lay data tuong ung cua tung hang
            int cellnum = 0; // trong 1 hang co nhieu cot, cau lenh nay de chay chi so cot
            for (Object obj : objArr) // Duyet cot de hien thi ra tung o
            {
                Cell cell = row.createCell(cellnum++);
                if(obj instanceof String) // kiểm tra nếu dữ liệu là kiểu chuỗi
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer) // Kiểm tra nếu dữ liệu là kiểu số
                    cell.setCellValue((Integer)obj);
            }
        }

        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("employee.xlsx"));
            wb.write(out);
            out.close();
            System.out.println("employee.xlsx written successfully on disk.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void readFromExcel() throws IOException {
        FileInputStream fis = new FileInputStream(new File("employee.xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        Iterator<Row> i = sheet.iterator();
        while (i.hasNext()) {
            Row r = i.next();
            Iterator<Cell> c = r.cellIterator();
            while (c.hasNext()) {
                Cell cell = c.next();
                if (cell.getCellType() == CellType.STRING) {
                    System.out.print(cell.getStringCellValue()+"\t");
                } else {
                    System.out.print(cell.getNumericCellValue()+"\t");
                }
            }
            System.out.println("\n");
        }
    }
}
