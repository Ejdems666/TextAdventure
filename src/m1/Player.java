/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1;

import java.util.ArrayList;

/**
 *
 * @author Tobias Grundtvig
 */
public class Player
{
    private Room currentRoom;
    private int gold;
    private Inventory inventory;

    public Player(Room startRoom)
    {
        this.currentRoom = startRoom;
        this.gold = 0;
        inventory = new Inventory();
    }

public Room getCurrentRoom() {
    return currentRoom;
}
    
    public String describe()
    {
        StringBuilder res = new StringBuilder();
        res.append(currentRoom.getDescription());
        res.append("\nYou have ").append(asGold(gold)).append(".\n");
        res.append("This room contains ").append(asGold(currentRoom.getGold())).append(".\n");
        String inventoryRoomPrint = currentRoom.getInventory().toString();
        if (!inventoryRoomPrint.isEmpty())
        {
                res.append("This room contains a ").append(currentRoom.getInventory().toString()).append(".\n");
        }
        String inventoryPlayerPrint = this.getInventory().toString();
        if (!inventoryPlayerPrint.isEmpty())
        {
            res.append("You have ").append(this.getInventory().toString()).append(".\n");
        }
        
        int exits = currentRoom.exitCount();
        switch(exits)
        {
            case 0:
                res.append("This room has no exits");
                break;
            case 1:
                res.append("This room has an exit to the ");
                break;
            default:
                res.append("This room has exits to the ");
                break;
        }
        if(currentRoom.getNorth()!=null)
        {
            --exits;
            res.append("north");
            if(exits == 1) res.append(" and ");
            if(exits > 1) res.append(", ");
        }
        if(currentRoom.getEast()!=null)
        {
            --exits;
            res.append("east");
            if(exits == 1) res.append(" and ");
            if(exits > 1) res.append(", ");
        }
        if(currentRoom.getSouth()!=null)
        {
            --exits;
            res.append("south");
            if(exits == 1) res.append(" and ");
            if(exits > 1) res.append(", ");
        }
        if(currentRoom.getWest()!=null)
        {
            --exits;
            res.append("west");
            if(exits == 1) res.append(" and ");
            if(exits > 1) res.append(", ");
        }
        res.append(".\n");
        return res.toString();
    }
    
    public int takeGold()
    {
        int amount = currentRoom.getGold();
        currentRoom.setGold(0);
        gold += amount;
        return amount;
    }
    
    public boolean goNorth()
    {
        if(currentRoom.getNorth() == null) return false;
        currentRoom = currentRoom.getNorth();
        return true;
    }
    
    public boolean goEast()
    {
        if(currentRoom.getEast() == null) return false;
        currentRoom = currentRoom.getEast();
        return true;
    }
    
    public boolean goSouth()
    {
        if(currentRoom.getSouth() == null) return false;
        currentRoom = currentRoom.getSouth();
        return true;
    }
    
    public boolean goWest()
    {
        if(currentRoom.getWest() == null) return false;
        currentRoom = currentRoom.getWest();
        return true;
    }
    
    public static String asGold(int n)
    {
        switch(n)
        {
            case 0:
                return "no gold";
            case 1:
                return "one piece of gold";
            default:
                return n + " pieces of gold";
        }
    }

    public Inventory getInventory() { // want to print the inventory
        return inventory;
    }

    
    
}
