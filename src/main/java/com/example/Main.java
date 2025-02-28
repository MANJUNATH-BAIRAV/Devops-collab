package com.example; 
public class Main {
    public String greet() {
         return "Hello, Jenkins!";
    }

    public static void main(String[] args) {
        System.out.println(new Main().greet());
    }
}
