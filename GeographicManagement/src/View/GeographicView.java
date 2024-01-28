package View;

import Common.Inputter;
import Model.Country;

import java.util.*;

public class GeographicView {
    Scanner scanner = new Scanner(System.in);
    Inputter inputter = new Inputter();
    Country temp;
    ArrayList<Country> countryList = new ArrayList<>();

    public void inputCountry() {
        String code = inputter.getStringData("code of country");
        String name = inputter.getStringData("name of country");
        float area = inputter.getFloatData("total area");

        String terrain = inputter.getStringData("terrain of country");

        temp = new Country(code, name, area, terrain);
        countryList.add(temp);
    }

    public void displayAttribute() {
        System.out.printf("%-25s%-25s%-25s%-25s%n", "ID", "Name", "Total Area", "Terrain");
    }

    public void displayNewestCountry() {
        if (countryList.isEmpty())
            System.out.println("Empty Country !!!!");
        else {
            displayAttribute();
            temp.display();
        }
    }

    public void searchCountry() {
        String countryName = inputter.getStringData("name of the country you wanna search for");
        displayAttribute();
        int flag = 0;
        for (Country country : countryList) {
            if (country.getCountryName().equals(countryName)) {
                country.display();
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("\t\tNot Found !!!");
        }
    }

    public void sortCountryList() {
        if (countryList.isEmpty()) {
            System.out.println("List is Empty !!!");
        } else {
            displayAttribute();
            countryList.sort(Comparator.comparing(Country::getCountryName));
            countryList.forEach(country -> country.display());
        }
    }
}
