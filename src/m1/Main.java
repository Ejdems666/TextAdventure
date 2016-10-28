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

        //Run the game
        Game game = new Game(start);
        game.run();
        
    }
}
