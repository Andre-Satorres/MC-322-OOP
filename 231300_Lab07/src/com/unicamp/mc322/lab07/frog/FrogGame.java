package com.unicamp.mc322.lab07.frog;

import com.unicamp.mc322.lab07.frog.io.FrogIO;
import com.unicamp.mc322.lab07.frog.io.FrogKeyboardIO;
import com.unicamp.mc322.lab07.frog.io.IOType;

public class FrogGame {
    private FrogIO frogIO;
    private String playerName;

    public FrogGame(IOType ioType) {
        if (ioType == IOType.CONSOLE) {
            frogIO = new FrogKeyboardIO();
        }
    }

    public void start() {
        initialize();
    }

    private void initialize() {
        frogIO.banner();
        playerName = frogIO.getPlayerName();
        frogIO.welcomeMessage(playerName);
    }
}
