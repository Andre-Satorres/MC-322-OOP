package com.unicamp.mc322.lab07.frogy.io;

import com.unicamp.mc322.lab07.frogy.command.Command;
import com.unicamp.mc322.lab07.frogy.entity.map.Map;
import com.unicamp.mc322.lab07.frogy.entity.map.item.MapItem;
import com.unicamp.mc322.lab07.frogy.entity.map.item.icon.Icon;
import com.unicamp.mc322.lab07.frogy.entity.map.item.icon.TextIcon;
import com.unicamp.mc322.lab07.frogy.position.Position;

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
    public boolean getYes(String message) {
        showMessage(message + " (Y/N): ", false);
        return getInfo().trim().equalsIgnoreCase("Y");
    }

    @Override
    public Command getCommand() {
        String command = getInfo();

        switch (command.toUpperCase()) {
            case "W": return Command.UP;
            case "A": return Command.LEFT;
            case "S": return Command.DOWN;
            case "D": return Command.RIGHT;
            case "Q": return Command.QUIT;
            default: return Command.UNKNOWN;
        }
    }

    @Override
    public void banner() {
        showMessage(
                "    ______                          ______\n" +
                "   / ____/________  ____ ___  __   / ____/___ _____ ___  ___\n" +
                "  / /_  / ___/ __ \\/ __ `/ / / /  / / __/ __ `/ __ `__ \\/ _ \\\n" +
                " / __/ / /  / /_/ / /_/ / /_/ /  / /_/ / /_/ / / / / / /  __/\n" +
                "/_/   /_/   \\____/\\__, /\\__, /   \\____/\\__,_/_/ /_/ /_/\\___/\n" +
                "                 /____//____/"
        );

        showMessage("");
        showMessage("");
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

    @Override
    public int getInt(String message) {
        int x;
        for(;;) {
            showMessage(message, false);
            try {
                x = Integer.parseInt(getInfo());
                break;
            } catch (Exception e) {
                showErrorMessage("Invalid input! Please retype a valid integer value...");
            }
        }

        return x;
    }

    @Override
    public Icon getIcon() {
        showMessage("Please insert the icon for it (max 2 chars): ", false);
        String input = getInfo();
        String textIcon = input.length() > 2 ? input.substring(0, 2) : input.length() < 2 ? input + " " : input;
        return new TextIcon(textIcon);
    }

    @Override
    public int getFrogType() {
        int x = 0;

        do {
            x = getInt("With which frog type would you like to play? (1- Green, 2-Tomato, 3-Poisonous): ");
        } while (x < 1 || x > 3);

        return x;
    }

    @Override
    public void showLagoon(Map lagoon) {
        for (int y=0; y<lagoon.getHeight(); y++) { // following the Cartesian Orientation [(0,0), (1,0), (2,0), ...]
            for (int x=0; x<lagoon.getWidth(); x++) {
                String textIcon = lagoon.getItem(Position.of(x, y)).getMapItemRepresentation().toString();
                showMessage(textIcon, false);

                if (x != lagoon.getWidth() - 1) {
                    showMessage(" ", false);
                }
            }

            showMessage("");
        }
    }
}
