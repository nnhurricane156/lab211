package Controller;

import Model.Worker;
import View.Menu;
import View.WorkerView;

public class WorkerController extends Menu {
    WorkerView workerView = new WorkerView();
    public WorkerController(){
        super("======== Worker Management =========", new String[] {
                "\tAdd Worker", "\tUp salary", "\tDown salary",
                "\tDisplay Information salary", "\tExit"
        });
    }
    @Override
    public void execute(int choice) {
        switch (choice){

        }
    }
}
