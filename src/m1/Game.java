/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import libs.FileIO;
import m1.cmd.CommandInterpretor;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author Tobias Grundtvig
 */
public class Game {
    private final Player player;
    private final CommandInterpretor cmdInt;
    private final Scanner scanner;
    FileIO fieIo;

    public Game(Room startRoom) {
        player = new Player(startRoom);
        cmdInt = new CommandInterpretor(player);
        scanner = new Scanner(System.in);
        fieIo = new FileIO();
    }

    public void run() {
        System.out.println("Welcome to the text adventure.");
        System.out.println("What is your name");
        player.setName(scanner.next());
        System.out.println(player.describe());
        while (true) {
            System.out.print(">");
            String cmd = scanner.nextLine().trim();
            String description = cmdInt.interpret(cmd);
            if (description == null) {
                System.out.println("\n\nGoodbye! " + player.getName() + ".\n");
                writeScore();
                readScores();
                return;
            }
            System.out.println(description); // in command interpreter class the interpret method contains at the end the description
        }                            // of the current room and of player status
    }

    public void writeScore() {
        fieIo.appendToFile("scores.txt", player.getName() + " won " + Player.asGold(player.getGold()));
    }

    public void readScores() {
        try {
            ArrayList<String> contents = fieIo.readFile("scores.txt");
            for (String content : contents) {
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}// game

