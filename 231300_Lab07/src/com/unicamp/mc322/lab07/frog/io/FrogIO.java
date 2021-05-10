package com.unicamp.mc322.lab07.frog.io;

import com.unicamp.mc322.lab07.frog.command.Command;

public abstract class FrogIO {

    public abstract void showMessage(String message);

    public abstract void showErrorMessage(String errorMessage);

    public abstract String getInfo();

    public abstract Command getCommand();

    public abstract void banner();

    public abstract void welcomeMessage(String playerName);

    public abstract String getPlayerName();
}
