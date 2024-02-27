package View;

import Common.Inputter;
import Common.Validation;
import Model.Worker;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class WorkerView {
    Inputter inputter = new Inputter();
    ArrayList<Worker> workerArrayList;
    LocalDate today = LocalDate.now();

    public WorkerView() {
        workerArrayList = new ArrayList<>();
        loadData("src/input.txt");
    }

    public void loadData(String fileName) {
        try {
            Validation validation = new Validation();
            BufferedReader bf = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = bf.readLine()) != null) {
                String[] arr = line.split("\\|");
                if (arr.length == 5) {
                    boolean isId = validation.isValid(arr[0].trim(), "[A-Z]\\s?\\d+"),
                            isName = validation.isString(arr[1].trim()),
                            isSuitedAge = validation.isSuited(arr[2].trim()),
                            isValidSalary = validation.isValid(arr[3].trim(), "\\d+");
                    if (isId && isName && isSuitedAge && isValidSalary) {
                        String code = arr[0].trim(),
                                name = arr[1].trim(),
                                workLocation = arr[4].trim();
                        int yearBirth = Integer.parseInt(arr[2].trim());
                        long salary = Long.parseLong(arr[3].trim());
                        workerArrayList.add(new Worker(code, name, yearBirth, salary, workLocation));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error !!!");
        }
    }

    public void updateData(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Worker worker : workerArrayList) {
                bw.write(worker.getCode() + "|" +
                        worker.getName() + "|" +
                        worker.getYearBirth() + "|" +
                        worker.getSalary() + "|" +
                        worker.getWorkLocation());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeDataIntoFileResult(String fileName, String status, LocalDate today, Worker worker) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            String formattedDate = today.toString();
            bw.write(worker.getCode() + "|" +
                    worker.getName() + "|" +
                    (today.getYear() - worker.getYearBirth()) + "|" +
                    worker.getSalary() + "|" +
                    status + "|" +
                    formattedDate);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String checkDuplicate() {
        while (true) {
            String code = inputter.getCode("code");
            for (Worker worker : workerArrayList) {
                if (worker.getCode().equals(code)) {
                    System.out.println("Code is Duplicated !!!");
                    break;
                }
            }
            return code;
        }
    }

    public void addWorker() {
        String code = checkDuplicate();
        String name = inputter.getString("name");
        long salary = inputter.getLong("salary");
        int age = inputter.getAge("Age");
        String workLocation = inputter.getString("WorkLocation");

        workerArrayList.add(new Worker(code, name, today.getYear() - age, salary, workLocation));
        updateData("src/input.txt");
    }

    public void display() {
        for (Worker worker : workerArrayList) {
            System.out.println(worker.toString());
        }
    }

    public void upAndDownSalary(String choice) {
        switch (choice) {
            case "UP": {
                String code = inputter.getCode("Code");
                boolean flag = false;
                for(Worker workerr : workerArrayList){
                    if(workerr.getCode().equals(code)){
                        flag = true;
                        Long salary = inputter.getLong("Salary");
                        workerArrayList.forEach(worker -> {
                            if (worker.getCode().equals(code)) {
                                if (worker.getSalary() < salary) {
                                    worker.setSalary(salary);
                                    writeDataIntoFileResult("src/output.txt", "UP", today, worker);
                                } else {
                                    System.out.println("Fuck You Bitch !!!");
                                }
                            }
                        });
                    }
                }
                if(!flag){
                    System.out.println("Can't Find !!!");
                }
                break;
            }
            case "DOWN": {
                String code = inputter.getCode("Code");
                boolean flag = false;
                for(Worker workerr : workerArrayList){
                    if(workerr.getCode().equals(code)){
                        flag = true;
                        Long salary = inputter.getLong("Salary");
                        workerArrayList.forEach(worker -> {
                            if (worker.getCode().equals(code)) {
                                if (worker.getSalary() > salary) {
                                    worker.setSalary(salary);
                                    writeDataIntoFileResult("src/output.txt", "DOWN", today, worker);
                                } else {
                                    System.out.println("Poor You Bro !!!");
                                }
                            }
                        });
                    }
                }
                if(!flag){
                    System.out.println("Can't Find !!!");
                }
                break;
            }
        }
    }

}
