package Controller;

import View.Menu;
import View.ValidateProgramView;

public class ValidateProgramController extends Menu {
    ValidateProgramView validateProgramView = new ValidateProgramView();

    public ValidateProgramController() {
        super("====== Validate Progaram ======", new String[]{
                "Run", "Show Data", "Exit"
        });
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                validateProgramView.addContact();
                break;
            case 2:
                validateProgramView.showData();
                break;
            default:
                System.out.println("Thank You !!!");
        }
    }
}
