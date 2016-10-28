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
public class Room
{
    private final String description; 
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    private int gold;
    private Inventory inventory;
    
    public Room(String description)
    {
        if(description == null)
        {
            throw new NullPointerException("description may not be null");
        }
        this.description = description;
        north = null;
        east = null;
        south = null;
        west = null;
        gold = 0;
        inventory = new Inventory();
    }
    
    public int exitCount()
    {
        int res = 0;
        if(north != null) ++res;
        if(east != null) ++res;
        if(south != null) ++res;
        if(west != null) ++res;
        return res;
    }
    
    public String getDescription()
    {
        return description;
    }

    public Room getNorth()
    {
        return north;
    }

    public Room getEast()
    {
        return east;
    }

    public Room getSouth()
    {
        return south;
    }

    public Room getWest()
    {
        return west;
    }

    public int getGold()
    {
        return gold;
    }

    public void setGold(int gold)
    {
        this.gold = gold;
    }
    
    public void connectNorth(Room other)
    {
        other.south = this;
        this.north = other;
    }
    
    public void connectEast(Room other)
    {
        other.west = this;
        this.east = other;
    }
    
    public void connectSouth(Room other)
    {
        other.north = this;
        this.south = other;
    }
    
    public void connectWest(Room other)
    {
        other.east = this;
        this.west = other;
    }
    
    public Inventory getInventory() { // want to print the inventory
        return inventory;
    }
    
 
}
