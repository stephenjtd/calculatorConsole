/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatortest;
import java.util.Scanner;

/**
 *
 * @author DoyleS
 */
public class CalculatorTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //get sum from user
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter calculation: ");
        String calc = keyboard.next();
        
        parseString(calc);
        //split string into values
        //add 1st 2 values
        //if more values, add to answer
    }//main
    
    public static void parseString(String calc){
        double num1 = 0;
        double num2 = 0;
        char operator = 0;
        int opcount = 1;
        int numcount = 0;
        String n = "";
        boolean num1set = false;
        double ans = 0;
        
        for (int i = 0; i < calc.length(); ++i){
            //if number or decimal point is found set to num1
            if ((calc.charAt(i) > '/')&&(calc.charAt(i) < ';')){
                n+= calc.charAt(i);//char is a number
            }
            else if ((calc.charAt(i)=='.'))
                n+=calc.charAt(i);//decimal point 
            //if nextchar is 1st operator, set to operator, opcount++, numcount++
            else if ((calc.charAt(i)=='+')||(calc.charAt(i)=='-')||(calc.charAt(i)=='*')||(calc.charAt(i)=='/')){
                //System.out.println("operator is: " + operator);              
                if (num1set == false){
                    num1 = Double.parseDouble(n);
                    num1set=true;
                   //System.out.println("parsed num1");
                    n = "";
                }
                
                if(opcount>1){
                    num2 = Double.parseDouble(n);//1st value is already parsed, so do next
                    //System.out.println("parsed num2");
                    n="";
                    //if nextchar is 2nd operator (if opcount=2) perform calculation on 2 values
                    //perform calculation on the 2 values set answer to num1
                    num1 = calculator(num1,num2, operator);
                    System.out.println(num1);
                }
                operator = calc.charAt(i);
                opcount++;
            }
            else{
                System.out.println("Invalid input");
                break;
            }
            
            if(i==calc.length()-1){
                //end of string
                num2 = Double.parseDouble(n);
                System.out.println("parsed num2");
                ans = calculator(num1,num2, operator);
            }
        }//for
        

        System.out.println("The answer is: ");
        //if answer is whole no
        int rounded = (int)ans;
        if (ans%rounded == 0){
            System.out.print(rounded + "\n");
        }
        else
            System.out.print(ans + "\n");
    }
    
    public static double calculator(double n1, double n2, char op){
        double ans = 0;
        switch (op){
            case '+':{
                ans = n1 + n2;
                break;
            }
            case '-':{
                ans = n1 - n2;
                break;
            }
            case '*':{
                ans = n1 * n2;
                break;
            }
            case '/':{
                ans = n1 / n2;
                break;
            }
            default:{
                System.out.println("Invalid operator.");
            }
        }//switch
        
        return ans;
            
    }//calculator    
    
}//class
