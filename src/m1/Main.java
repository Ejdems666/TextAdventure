/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1;

import m1.map.DungeonMap;

import java.util.ArrayList;

/**
 *
 * @author Tobias Grundtvig
 */
public class Main
{
    public static void main(String[] args)
    {
        //Build the dungeon
        DungeonMap map = new DungeonMap();
        Room[] rooms = map.createDungeonMap();

        Room start = rooms[0];
        start.getInventory().addToInventory(new Weapon ("sword", 10, 0, true));
        rooms[1].getInventory().addToInventory(new HealthBoostItem("potion", 0, 10, true));
        rooms[3].getInventory().addToInventory(new Weapon ("gun",20, 0, true));
        rooms[5].getInventory().addToInventory(new HealthBoostItem("snack",0, 5, false));
        rooms[7].getInventory().addToInventory(new Weapon("pen", 5, 0, false));
        rooms[8].getInventory().addToInventory(new HealthBoostItem("life saver", 0, 20, true));
        
        //Run the game
        Game game = new Game(start);
        game.run();
        
    }
}
