package View;

import Common.Input;
import Model.Element;

public class SolvingEquation_View {
    Input input = new Input();
    public boolean isNumber(String number)
    {
        try
        {
            Double.parseDouble(number);
            return true;
        }catch(NumberFormatException ex)
        {
            System.out.println("Please Input Number:");
            return false;
        }
    }

    public double inputNumber(String str)
    {
        double haha = 0;
        while(true)
        {
            String number = input.inputString(str);
            if(isNumber(number))
            {
                haha = Double.parseDouble(number);
                break;
            }
        }
        return haha;
    }

    public void superlativeEquation() //ax + b = 0
    {
        System.out.println("----- Calculate Equation -----");
        double a = inputNumber("Enter A");
        double b = inputNumber("Enter B");
        double x = 0;
        Element e = new Element(a,b);
        if(a == 0 && b == 0)
            System.out.println("The equation has infinitely many solutions");
        else if(a == 0 && b != 0)
            System.out.println("The equation has no solution");
        else
        {
            e.superlativeEquation(a,b);
            System.out.println("Solution: "+ e.getX());
        }
        e.oddNumber();
        e.evenNumber();
        e.perfectSquareNumber();
    }

    public void quadraticEquation() //ax^2 + bx + c = 0
    {
        System.out.println("----- Calculate Quadratic Equation -----");
        double a = inputNumber("Enter A");
        double b = inputNumber("Enter B");
        double c = inputNumber("Enter C");
        Element element = new Element(a,b,c);
        double delta = b*b - 4*a*c;
        if(delta < 0)
        {

            System.out.println("The equation has no solution");
        }

        else if(delta == 0)
        {
            element.quadraticEquation(a,b);
            System.out.println("Solution: x1 = x2 = " + element.getX());
        }
        else
        {
            element.quadraticEquation(a,b,delta);
            System.out.println("Soulution: x1 = " + element.getX() + " and x2 = " + element.getY());
        }
        element.oddNumber();
        element.evenNumber();
        element.perfectSquareNumber();
    }

}
