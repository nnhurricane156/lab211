package Controller;

import View.GeographicView;
import View.Menu;


public class GeographicManager extends Menu {
    GeographicView geographicView = new GeographicView();

    public GeographicManager() {
        super("\tGeographic Menu", new String[]{
                "Input the information of 11 countries in East Asia",
                "Display the information of country you've just input",
                "Search the information of country by user-entered name",
                "Display the information of countries sorted name in ascending",
                "Exit"
        });
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                geographicView.inputCountry();
                break;
            case 2:
                geographicView.displayNewestCountry();
                break;
            case 3:
                geographicView.searchCountry();
                break;
            case 4:
                geographicView.sortCountryList();
                break;
            default:
                System.out.println("THANK YOU !!!");
                break;
        }
    }
}
