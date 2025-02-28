package com.example;

public class Main {
    public String greet() {
        return "Hello, Jenkins!"; // Return the string instead of printing it
    }

    public static void main(String[] args) {
        System.out.println(new Main().greet()); // Print the returned value
    }
}

