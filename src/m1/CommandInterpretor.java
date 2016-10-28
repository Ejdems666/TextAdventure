/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1;

/**
 *
 * @author Tobias Grundtvig
 */
public class CommandInterpretor
{
    private final Player player;

    public CommandInterpretor(Player player)
    {
        this.player = player;
    }
    
    public String interpret(String cmd)
    {
        StringBuilder res = new StringBuilder();
        String command = cmd.toLowerCase();
        switch(command)
        {
            case "north":
                if(player.goNorth())
                {
                    res.append("You walk to the north.\n");
                }
                else
                {
                    res.append("There is no path to the north!\n");
                }
                break;
            case "east":
                if(player.goEast())
                {
                    res.append("You walk to the east.\n");
                }
                else
                {
                    res.append("There is no path to the east!\n");
                }
                break;
            case "south":
                if(player.goSouth())
                {
                    res.append("You walk to the south.\n");
                }
                else
                {
                    res.append("There is no path to the south!\n");
                }
                break;
            case "west":
                if(player.goWest())
                {
                    res.append("You walk to the west.\n");
                }
                else
                {
                    res.append("There is no path to the west!\n");
                }
                break;
            case "pickup gold":
                int gold = player.takeGold();
                res.append("You picked up ").append(Player.asGold(gold)).append(".\n");
                break;
            case "pick up item":
                player.getInventory().addToInventory(player.getCurrentRoom().getInventory().PickUp(0));
                break;
            case "pick up gold":
                player.takeGold();
                break;
            case "my inv":    
                res.append(player.getInventory().toString());
                break;
            case "room inv":   
                res.append(player.getCurrentRoom().getInventory().toString());
                break;
            case "quit":
                return null;
            default:
                res.append("Unknown command: ").append(cmd).append(".\n");
        }
        res.append(player.describe());// return the description of the describe method in the player class
        return res.toString();
    }
    
}
