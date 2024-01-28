package Model;

import java.util.ArrayList;

public class Element {
    private double a, b, c, x, y;

    public Element(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Element(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean superlativeEquation(double a, double b)
    {
        this.x = -b/a;
        return true;
    }

    public boolean quadraticEquation(double a, double b)
    {
        this.x = this.y = (-b)/(2*a);
        return true;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean quadraticEquation(double a, double b, double delta)
    {
        this.x = (-b + Math.sqrt(delta)) / ( 2*a);
        this.y = (-b - Math.sqrt(delta)) / (2*a);
        return true;
    }

    public boolean checkEven(double number)
    {
        return (number % 2 == 0);
    }

    public boolean checkOdd(double number)
    {
        return (number % 2 != 0);
    }

    public boolean checkPerfectSquare(double number)
    {
        if(number <= 0)
            return false;
        int sqrt = (int)Math.sqrt(number);
        return(sqrt*sqrt == number);
    }

    public void oddNumber()
    {
        double[] oddnumber = {a,b,c,x,y};
        ArrayList<Double> oddNumber = new ArrayList<>();
        for(Double d : oddnumber)
        {
            if(checkOdd(d))
                oddNumber.add(d);
        }
        System.out.println("Number is Odd: ");

        for(int i = 0; i < oddNumber.size(); i++)
        {
            if(i < oddNumber.size() - 1)
                System.out.print(oddNumber.get(i) + ", ");
            else if(i == oddNumber.size()  - 1)
                System.out.println(oddNumber.get(i));
        }

    }

    public void evenNumber()
    {
        double[] hehe = {a,b,c,x,y};
        ArrayList<Double> evenNumber = new ArrayList<>();
        for(Double d : hehe)
        {
            if(checkEven(d) && d != 0)
                evenNumber.add(d);
        }
        System.out.println("Number is Even: ");
        for(int i = 0; i < evenNumber.size(); i++)
        {
            if(i < evenNumber.size() - 1)
                System.out.print(evenNumber.get(i) + ", ");
            else if(i == evenNumber.size()  - 1)
                System.out.println(evenNumber.get(i));
        }

    }

    public void perfectSquareNumber()
    {
        double[] hihi = {a,b,c,x,y};
        ArrayList<Double> perfectSquareNumber = new ArrayList<>();
        for(Double d : hihi)
        {
            if(checkPerfectSquare(d))
                perfectSquareNumber.add(d);
        }
        System.out.println("Number is Perfect Square: ");

        for(int i = 0; i < perfectSquareNumber.size(); i++)
        {
            if(i < perfectSquareNumber.size() - 1)
                System.out.print(perfectSquareNumber.get(i) + ", ");
            else if(i == perfectSquareNumber.size()  - 1)
                System.out.print(perfectSquareNumber.get(i));
        }

    }
}
