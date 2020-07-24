package com.company;
import java.util.Scanner;

public class Game {
    private Grid grid;
    public Game(){}
    public int start(Scanner scanner){
        while (initilizeGamingGrid(scanner) == -1) // initilizing the grid for the game
            initilizeGamingGrid(scanner);
        String[] userInput_result = scanner.nextLine().split(", "); // It could split it by pattern
        int x0 = Integer.parseInt(userInput_result[0]);
        int y0 = Integer.parseInt(userInput_result[1]);
        int N = Integer.parseInt(userInput_result[2]);
        int greenGenerations=grid.generateN(N,x0,y0);
        //grid.printGrid(); // final grid
        System.out.println("Result: " + greenGenerations);

        return 0;
    }

    private int initilizeGamingGrid(Scanner scanner){
        String[] userInput_sizeOfGrid = scanner.nextLine().split(", "); // It could split it by pattern
        int rows = Integer.parseInt(userInput_sizeOfGrid[0]);
        int cols = Integer.parseInt(userInput_sizeOfGrid[1]);
        if(rows>0 && cols>0) {
            grid = new Grid(rows, cols);
            grid.setGrid(scanner);
            //grid.printGrid();
            return 0;
        }
        System.err.println("X,Y must be greater than 0! Please, try again"); // It could be handled with Exception
        return -1;
    }
}
