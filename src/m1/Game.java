/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1;

import java.util.Scanner;

/**
 *
 * @author Tobias Grundtvig
 */
public class Game
{
    private final Player player;
    private final CommandInterpretor cmdInt;
    private final Scanner scanner;

    public Game(Room startRoom)
    {
        player = new Player(startRoom);
        cmdInt = new CommandInterpretor(player);
        scanner = new Scanner(System.in);
    }
    
    public void run()
    {
        System.out.println("Welcome to the text adventure.");
        System.out.println(player.describe());
        while(true)
        {
            System.out.print(">");
            String cmd = scanner.nextLine().trim();
            String desc = cmdInt.interpret(cmd);
            if(desc == null)
            {
                System.out.println("\n\nGoodbye!\n");
                return;
            }
            System.out.println(desc); // in command interpreter class the interpret method contains at the end the description
        }                            // of the current room and of player status
    }
    
    
}
