package Controller;

import View.Menu;
import View.SolvingEquation_View;

public class SolvingEquation_Controller extends Menu {
    SolvingEquation_View sv = new SolvingEquation_View();
    public SolvingEquation_Controller() {
        super("========= Equation Program =========", new String[]{
               "Calculate Superlative Equation","Calculate Quadratic Equation","Exit"
        });
    }

    @Override
    public void execute(int choice) {
        switch (choice)
        {
            case 1:
                sv.superlativeEquation();
                break;
            case 2:
                sv.quadraticEquation();
                break;
            case 3:
                System.exit(0);
        }
    }
}
