package com.unicamp.mc322.lab07;

import com.unicamp.mc322.lab07.frogy.FrogGame;
import com.unicamp.mc322.lab07.frogy.io.IOType;

public class App {
    public static void main(String[] args) {
        new FrogGame(IOType.CONSOLE).start();
    }
}
