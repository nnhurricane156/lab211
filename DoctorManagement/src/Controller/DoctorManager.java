package Controller;

import VIew.Menu;

public class DoctorManager extends Menu {
    public DoctorManager(){
        super("--------DOCTOR MANAGEMENT--------", new String[]{
                "\tAdd Doctor" +
                        "\tUpdate Doctor" +
                        "\tDelete Doctor" +
                        "\tSearch Doctor" +
                        "\ttExit"
        });
    }
    @Override
    public void execute(int choice) {

    }
}
