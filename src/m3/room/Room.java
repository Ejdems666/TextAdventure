/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m3.room;


import m3.Inventory;
import m3.character.ICharacter;

import java.util.ArrayList;

/**
 *
 * @author Tobias Grundtvig
 */
public class Room implements IRoom,IRoomPassages
{
    private ArrayList<ICharacter> monsters = new ArrayList<>();
    private String description = "";
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    private int gold = 0;
    private Inventory inventory = new Inventory();

    public void addMonster(ICharacter monster) {
        this.monsters.add(monster);
    }

    public void removeMonster(ICharacter monster) {
        this.monsters.remove(monster);
    }

    public void setDescription(String description) {
        this.description = description;
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
    
    public Inventory getInventory() { // want to print the inventory
        return inventory;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setWest(Room west) {
        this.west = west;
    }
}
