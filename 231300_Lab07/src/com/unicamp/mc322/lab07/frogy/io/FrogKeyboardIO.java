package com.unicamp.mc322.lab07.frogy.io;

import com.unicamp.mc322.lab07.frogy.command.Command;
import java.util.Scanner;

public class FrogKeyboardIO extends FrogIO {
    private final Scanner scanner;

    public FrogKeyboardIO() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showMessage(String message, boolean newLine) {
        if (newLine) {
            showMessage(message);
        } else {
            System.out.print(message);
        }
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        System.err.println(errorMessage);
    }

    @Override
    public String getInfo() {
        return scanner.next().trim();
    }

    @Override
    public Command getCommand() {
        String command = getInfo();

        switch (command.toUpperCase()) {
            case "W": return Command.UP;
            case "A": return Command.LEFT;
            case "S": return Command.RIGHT;
            case "D": return Command.DOWN;
            case "Q": return Command.QUIT;
            default: return Command.UNKNOWN;
        }
    }

    @Override
    public void banner() {
        showMessage(
                "    ______                          ______                   \n" +
                "   / ____/________  ____ ___  __   / ____/___ _____ ___  ___ \n" +
                "  / /_  / ___/ __ \\/ __ `/ / / /  / / __/ __ `/ __ `__ \\/ _ \\\n" +
                " / __/ / /  / /_/ / /_/ / /_/ /  / /_/ / /_/ / / / / / /  __/\n" +
                "/_/   /_/   \\____/\\__, /\\__, /   \\____/\\__,_/_/ /_/ /_/\\___/ \n" +
                "                 /____//____/                                ");

        //     ______                          ______
        //   / ____/________  ____ ___  __   / ____/___ _____ ___  ___
        //  / /_  / ___/ __ \/ __ `/ / / /  / / __/ __ `/ __ `__ \/ _ \
        // / __/ / /  / /_/ / /_/ / /_/ /  / /_/ / /_/ / / / / / /  __/
        ///_/   /_/   \____/\__, /\__, /   \____/\__,_/_/ /_/ /_/\___/
        //                 /____//____/
    }

    @Override
    public void welcomeMessage(String playerName) {
        showMessage("Welcome, " + playerName + "!");
    }

    @Override
    public String getPlayerName() {
        String playerName;
        do {
            showMessage("Please, type your name: ", false);
            playerName = getInfo();
        } while (playerName.isBlank());

        return playerName;
    }
}
