package com.unicamp.mc322.lab07;

import com.unicamp.mc322.lab07.frog.FrogGame;
import com.unicamp.mc322.lab07.frog.io.IOType;

public class App {
    public static void main(String[] args) {
        new FrogGame(IOType.CONSOLE).start();
    }
}
