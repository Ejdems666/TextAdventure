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
public class Main
{
    public static void main(String[] args)
    {
        //Build the dungeon
        Room start = new Room("Start");
        Room a1 = new Room("A1");
        a1.setGold(5);
        Room a2 = new Room("A2");
        a2.setGold(3);
        Room a3 = new Room("A3");
        a3.setGold(6);
        Room b1 = new Room("B1");
        b1.setGold(1);
        Room b2 = new Room("B2");
        b2.setGold(7);
        Room b3 = new Room("B3");
        b3.setGold(7);
        Room c1 = new Room("C1");
        c1.setGold(8);
        Room c2 = new Room("C2");
        c2.setGold(1);
        Room c3 = new Room("C3");
        c3.setGold(1);
        
        start.connectNorth(b1);
        b1.connectWest(a1);
        a1.connectNorth(a2);
        c1.connectNorth(c2);
        a2.connectNorth(a3);
        a2.connectEast(b2);
        b2.connectEast(c2);
        c2.connectNorth(c3);
        a3.connectEast(b3);
        b3.connectEast(c3);
       
        start.getInventory().addToInventory(new Weapon ("sword", 10, 0, true));
        a1.getInventory().addToInventory(new HealthBoostItem("potion", 0, 10, true));
        a3.getInventory().addToInventory(new Weapon ("gun",20, 0, true));
        c3.getInventory().addToInventory(new HealthBoostItem("snack",0, 5, false));
        b2.getInventory().addToInventory(new Weapon("pen", 5, 0, false));
        a2.getInventory().addToInventory(new HealthBoostItem("life saver", 0, 20, true));
        
        //Run the game
        Game game = new Game(start);
        game.run();
        
    }
}
