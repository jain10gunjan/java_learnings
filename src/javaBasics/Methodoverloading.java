package javaBasics;

public class Methodoverloading {
    public static void main(String[] args){
        Computer computerObject = new Computer();
        computerObject.playMusic();
        System.out.println(computerObject.getMeAPen());
    }
}

class Calculator{
    // Method Overloading: Same name of method but different parameters.

    public int add(int a , int b){
        return a + b;
    }
    public int add(int a , int b, int c){
        return a + b + c;
    }
    // Same parameters but of different types.
    public double add(double a , double b, double c){
        return a + b + c;
    }
}

class Computer{
    public void playMusic(){
        // Void: Do not want anything in return.
        System.out.println("Playing Music...");
    }

    public String getMeAPen(){
       //String: It is a return type.s
       return "Pen"; // Use of [ " " ] will be there for string.
    }
}
