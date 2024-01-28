package View;

import Common.Inputter;
import Common.Validation;
import Model.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentView {
    public void loadData(ArrayList<Student> sList) {
        try {
            Validation vd = new Validation();
            BufferedReader br = new BufferedReader(new FileReader("Input.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split("\\|");
                if (arr.length == 4) {
                    boolean isId = vd.isValid(arr[0], "[0-9]{1,}"),
                            isName = vd.isName(arr[1]),
                            isSemester = vd.isSemester(arr[2]),
                            isCourse = vd.isCourse(arr[3]);

                    if (isId && isName && isSemester && isCourse) {
                        String code = arr[0],
                                name = arr[1],
                                semester = arr[2],
                                course = arr[3];
                        Student st = new Student(code, name, semester, course);
                        sList.add(st);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        display(sList);
    }
    public void createStudent(ArrayList<Student> sList) {
        Inputter input = new Inputter();
        String code = input.inputPatter("student's id", "[0-9]{1,}"),
                name = input.getName("student's name"),
                semester = input.getSemester("semester"),
                course = getCourse();
        Student st = new Student(code, name, semester, course);
        sList.add(st);

    }
    private String getCourse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("==============SELECT COURSE=================");
        System.out.println("1 - Java");
        System.out.println("2 - .Net");
        System.out.println("3 - C/C++");
        System.out.print("Choice: ");
        int choice;
        String s = null;
        do {
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    s= "Java";
                case 2:
                    s= ".Net";
                case 3:
                    s= "C/C++";
            }
        } while (choice < 1 || choice > 3);
        return s;
    }
    public void  doUpdateDelete(ArrayList<Student> sList) {
        Inputter input = new Inputter();
        String id = input.inputPatter("student's id", "[0-9]{1,}");
        Predicate<Student> sPre = s -> (s.getId().equals(id));
        for (Student st : sList) {
            if (sPre.test(st)) {
                menuForUandD(sList, st,sPre);
            }
        }
    }
    private void update(ArrayList<Student> sList,Student st) {
        Inputter input = new Inputter();
        String  name = input.getName("student's name"),
                semester = input.getSemester("semester"),
                course = getCourse();
        st.setsName(name);
        st.setSemester(semester);
        st.setcName(course);
        display(sList);
    }
    private void menuForUandD(ArrayList<Student> sList, Student st, Predicate<Student> sPre) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to update (U) or delete (D) student");
        System.out.print("Your choice: ");
        String choice;
        do {
            choice = sc.next();
            switch (choice) {
                case "U":
                    update(sList,st);
                    break;
                case "D":
                    sList.removeIf(sPre);
                    display(sList);
                    break;
            }
        } while (!choice.equalsIgnoreCase("U") && !choice.equalsIgnoreCase("U"));
    }
    public void display(ArrayList<Student> sList) {
        System.out.println("=========STUDENT'S LIST===========");
        for (Student st : sList) {
            System.out.println(st.toString());
        }
    }

    public void reportData(ArrayList<Student> studentsList){
        Map<Student,Integer> studentMap = new HashMap<>();
        studentsList.forEach(student ->{
            if(!studentMap.containsKey(student)){
                studentMap.put(student,1);
            }else {
                int value = studentMap.get(student);
                studentMap.put(student,value+1);
            }
        });

        List <Map.Entry<Student,Integer>> newList = new ArrayList<>(studentMap.entrySet());
        newList.forEach(entry ->{
            System.out.println(entry.getKey().reportFormat() + "|" + entry.getValue());
        });
    }

    public void find(ArrayList<Student> studentArrayList) {
        String name = new Inputter().getName("Student's name");

        Predicate<Student> byLastCharacter = student -> {
            String sName = student.getsName();
            if (!sName.isEmpty()) {
                String[] arr = sName.split(" ");
                 return name.equalsIgnoreCase(arr[arr.length -1]);
            }
            return false;
        };

        ArrayList<Student> students = (ArrayList<Student>) studentArrayList.stream()
                .filter(byLastCharacter)
                .collect(Collectors.toList());
        display(students);
    }

    public ArrayList<Student> sort(ArrayList<Student> studentArrayList) {
        Collections.sort(studentArrayList, Comparator.comparing(Student::getsName));
        return studentArrayList;
    }

    public void menuForFndS(ArrayList<Student> sList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to find (F) or sort (S) student");
        System.out.print("Your choice: ");
        String choice;
        do {
            choice = sc.next();
            switch (choice) {
                case "F":
                    find(sList);
                    break;
                case "S":
                    sort(sList);
                    display(sList);
                    break;
            }
        } while (!choice.equalsIgnoreCase("F") && !choice.equalsIgnoreCase("S"));
    }
}
