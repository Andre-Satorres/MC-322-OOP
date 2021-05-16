package com.unicamp.mc322.lab07.frogy;

import com.unicamp.mc322.lab07.frogy.io.FrogIO;
import com.unicamp.mc322.lab07.frogy.io.FrogKeyboardIO;
import com.unicamp.mc322.lab07.frogy.io.IOType;

public class FrogGame {
    private FrogIO frogIO;
    private String playerName;
    private FrogController frogController;

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
