package io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeyboardIO {
    private BufferedReader bufferedReader;

    public KeyboardIO() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void welcomeMessage() {
        println("---------------------------");
        println("Welcome to Vatrigo Booking!");
        println("---------------------------");
        println("");
    }

    public void exit() {
        println("Goodbye!");
    }

    public void errorMessage(Exception ex) {
        System.out.println("Error: " + ex.getMessage());
        newLine();
    }

    public void display(Object object) {
        System.out.println(object);
        newLine();
    }

    public void newLine() {
        System.out.println();
    }

    private void print(String message) {
        System.out.print(message);
    }

    private void println(String message) {
        System.out.println(message);
    }
}
