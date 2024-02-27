package Controller;

import Common.Inputter;
import View.HandleFilesView;
import View.Menu;

public class HandleFilesController extends Menu {
    HandleFilesView handleFilesView = new HandleFilesView();
    Inputter inputter = new Inputter();
    public HandleFilesController(){
        super("========== File Processing =========", new String[] {
                "Find Person Info","Copy Text to New File","Exit"
        });
    }
    @Override
    public void execute(int choice) {
        switch (choice){
            case 1:handleFilesView.loadData(inputter.getString("Path"));
                handleFilesView.getPerson(inputter.getDouble("Money"));
                handleFilesView.clear();
                break;
            case 2:
                handleFilesView.loadData(inputter.getString("Source"));
                handleFilesView.writeData(inputter.getString("new file Name"));
                handleFilesView.clear();
                break;
            default:
                System.out.println("Thank You");
                break;
        }
    }
}
