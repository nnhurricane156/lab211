package VIew;

import Common.Validation;
import Model.Doctor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class DoctorView {
    Validation validation = new Validation();
    private HashMap<String, Doctor> doctorHashMap;

    public DoctorView() {
        doctorHashMap = new HashMap<>();
    }

    public void loadData(String filePath) {
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null){
                String[] data = line.split("\\|");
                if(data.length == 4){
                    String code = data[0];
                    String name = data[1];
                    String specialization  = data[2];

                }
            }
        } catch (IOException e){
            System.out.println("Couldn't access database !!!");
        }
    }

    public void titleMethod(String name) {
        System.out.println("---------" + name + "---------");
    }

    public boolean addDoctor(Doctor doctor) throws Exception {
        if (validation.checkValid(doctor, doctorHashMap)) {
            doctorHashMap.put(doctor.getCode(), doctor);
        }
        ;
        return true;
    }

    public boolean updateDoctor(Doctor doctor) throws Exception {
        if (validation.checkValid(doctor, doctorHashMap)) {
            doctorHashMap.put(doctor.getCode(), doctor);
        }
        ;
        return true;
    }

    public boolean deleteDoctor(Doctor doctor) throws Exception {
        if (validation.checkValid(doctor, doctorHashMap)) {
            doctorHashMap.remove(doctor.getCode());
        }
        return true;
    }

    public HashMap<String, Doctor> searchDoctor(String input) throws Exception {
        HashMap<String, Doctor> result = new HashMap<>();

        doctorHashMap.forEach((code, doctor) -> {
            if (code.contains(input) || doctor.getAvailability() == Integer.parseInt(input) ||
                    doctor.getSpecialization().contains(input) ||
                    doctor.getName().contains(input)) {
                result.put(code, doctor);
            }
        });
        return result;
    }
}
