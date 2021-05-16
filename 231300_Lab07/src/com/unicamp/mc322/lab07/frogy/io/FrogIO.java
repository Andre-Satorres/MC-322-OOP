package com.unicamp.mc322.lab07.frogy.io;

import com.unicamp.mc322.lab07.frogy.command.Command;
import com.unicamp.mc322.lab07.frogy.entity.map.item.icon.Icon;
import com.unicamp.mc322.lab07.frogy.position.Position;

public abstract class FrogIO {

    public abstract void showMessage(String message);

    public abstract void showErrorMessage(String errorMessage);

    public abstract String getInfo();

    public abstract Command getCommand();

    public abstract void banner();

    public abstract void welcomeMessage(String playerName);

    public abstract String getPlayerName();

    public abstract int getInt(String message);

    public abstract Icon getIcon();

    public abstract int getFrogType();
}
