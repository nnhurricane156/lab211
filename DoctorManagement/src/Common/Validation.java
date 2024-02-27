package Common;

import Model.Doctor;

import java.util.HashMap;
import java.util.Map;

public class Validation {
    public boolean checkValid(Doctor doctor,HashMap<String,Doctor> doctorHashMap) throws Exception{
        if (doctorHashMap.isEmpty()) {
            throw new Exception("Database does not exist !!!");
        }
        if (doctorHashMap.containsKey(doctor.getCode())) {
            throw new Exception(String.format("Doctor code [%s] is duplicate", doctor.getCode()));
        }
        if (doctor == null) {
            throw new Exception("Data was not exist !!!");
        }
        return true;
    }


}
