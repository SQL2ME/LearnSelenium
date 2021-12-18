/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author m2e
 */
public class Calculator {
    public double add(double n1, double n2) {
        return n1 + n2;
    }
 
    public double sub(double n1, double n2) {
        return n1 - n2;
    }
    
    public static void main(String[] args) {
        Calculator c = new Calculator();
        double result = c.add(10,20);
        if(result == 30)
            System.out.println("Pass");
        else
            System.out.println("Fail");
    }
    
}
