/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2.cmd;

import m2.Player;

/**
 * @author Tobias Grundtvig
 */
public class CommandInterpretor {
    private final String QUIT = "quit";
    private String[] commands;
    private final Player player;
    StringBuilder res = new StringBuilder();

    public CommandInterpretor(Player player) {
        this.player = player;
    }

    public String interpret(String command) {
        commands = command.toLowerCase().split(" ");
        if (commands[0].equals(QUIT)) {
            return null;
        }
        res = new StringBuilder();
        try {
            parseCmd();
        } catch (CmdException e) {
            res.append(e.getMessage()).append(".\n");
        }
        res.append(player.describe());// return the description of the describe method in the player class
        return res.toString();
    }

    private void parseCmd() throws CmdException {
        switch (commands[0]) {
            case "north":
                if (player.goNorth()) {
                    res.append("You walk to the north.\n");
                } else {
                    res.append("There is no path to the north!\n");
                }
                break;
            case "east":
                if (player.goEast()) {
                    res.append("You walk to the east.\n");
                } else {
                    res.append("There is no path to the east!\n");
                }
                break;
            case "south":
                if (player.goSouth()) {
                    res.append("You walk to the south.\n");
                } else {
                    res.append("There is no path to the south!\n");
                }
                break;
            case "west":
                if (player.goWest()) {
                    res.append("You walk to the west.\n");
                } else {
                    res.append("There is no path to the west!\n");
                }
                break;
            case "pickup":
                pickupCmd();
                break;
            case "inv":
                invCmd();
                break;
            default:
                throw new CmdException(commands[0]);
        }
    }
    private void pickupCmd() throws CmdException {
        handleLevelTwoCmd();
        switch (commands[1]) {
            case "gold":
                int gold = player.takeGold();
                res.append("You picked up ").append(Player.asGold(gold)).append(".\n");
                break;
            case "item":
                if (commands.length != 3) {
                    throw new CmdException(
                            "Command error. Insert pick up <itemIndex> to pick up an item.",
                            CmdException.LITERAL
                    );
                }
                try {
                    int itemIndex = Integer.parseInt(commands[2]);
                    player.getInventory().addToInventory(
                            player.getCurrentRoom()
                                    .getInventory()
                                    .PickUp(itemIndex)
                    );
                } catch (NumberFormatException e) {
                    throw new CmdException(
                            "No item with this index.",
                            CmdException.LITERAL
                    );
                }
                break;
            default:
                throw new CmdException(commands[1]);
        }
    }

    private void handleLevelTwoCmd() throws CmdException {
        if (commands.length < 2) {
            throw new CmdException(commands[0]);
        }
    }

    private void invCmd() throws CmdException {
        handleLevelTwoCmd();
        switch (commands[1]) {
            case "me":
                res.append(player.getInventory().toString());
                break;
            case "room":
                res.append(player.getCurrentRoom().getInventory().toString());
                break;
            default:
                throw new CmdException(commands[1]);
        }
    }
}
