/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2;

import m2.map.MapGenerator;

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
        MapGenerator map = new MapGenerator();
        ArrayList<Room> rooms = map.createDungeonMap();
        Room start = rooms.get(0);

        //Run the game
        Game game = new Game(start);
        game.run();
    }
}
