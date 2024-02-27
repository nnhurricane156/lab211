package Model;

import java.time.LocalDate;
import java.util.Date;

public class Worker {
    private String code;
    private String name;
    private int yearBirth;
    private long salary;
    private String workLocation;

    public Worker(String code, String name, int yearBirth, long salary, String workLocation) {
        this.code = code;
        this.name = name;
        this.yearBirth = yearBirth;
        this.salary = salary;
        this.workLocation = workLocation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    @Override
    public String toString() {
        LocalDate today = LocalDate.now();
        int age = today.getYear() - yearBirth;
        return String.format("%-15s %-15s %-15d %-15d", code, name, age, salary);
    }
}
