package edu.mutilcamp.model;

public class Employee {
    private int id;
    private String fullName;
    private String email;
    private int hoursWorkPerDay;
    private int long_work;
    private double fixSalary;
    private double outsideServiceNumber;

    private double totalSalary;

    public Employee(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHours_work_per_day() {
        return hoursWorkPerDay;
    }

    public void setHours_work_per_day(int hours_work_per_day) {
        this.hoursWorkPerDay = hours_work_per_day;
    }

    public int getLong_work() {
        return long_work;
    }

    public void setLong_work(int long_work) {
        this.long_work = long_work;
    }

    public double getFixSalary() {
        return fixSalary;
    }

    public void setFixSalary(double fixSalary) {
        this.fixSalary = fixSalary;
    }

    public double getOutsideServiceNumber() {
        return outsideServiceNumber;
    }

    public void setOutsideServiceNumber(double outsideServiceNumber) {
        this.outsideServiceNumber = outsideServiceNumber;
    }

    public int getHoursWorkPerDay() {
        return hoursWorkPerDay;
    }

    public void setHoursWorkPerDay(int hoursWorkPerDay) {
        this.hoursWorkPerDay = hoursWorkPerDay;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", hours_work_per_day=" + hoursWorkPerDay +
                ", long_work=" + long_work +
                ", fixSalary=" + fixSalary +
                ", outsideServiceNumber=" + outsideServiceNumber +
                '}';
    }
}
