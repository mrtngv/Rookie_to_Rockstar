package com.company;
import java.util.Scanner;

public class Grid {
    private int x;
    private int y;
    private int[][] grid;

    public Grid(int x,int y){
        this.x = x;
        this.y = y;
        this.grid = new int[x][y];
    }

    public void setGrid(Scanner scanner) {
        int i,j;
        for(i =0;i<x;i++){
            String rowInput = scanner.nextLine();
            for(j =0;j<y;j++)
                grid[i][j] = (int) rowInput.charAt(j) -48;
        }
    }

    public void printGrid(){
        int i,j;
        for(i = 0;i<x;i++){
            for(j = 0;j<y;j++)
                System.out.print(grid[i][j]+ " ");
            System.out.println();
        }
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    private int calculateGreen8(int i,int j){ // calculates all green Neighbours
        int sumOfGreen = 0, a = i-1, b = j-1;
        sumOfGreen-= grid[i][j];
        for(int n =0;n<3;n++){
            for(int m =0;m<3;m++){
                try {
                    sumOfGreen += grid[a+n][b+m];
                }catch (Exception e){}
            }
        }
        return sumOfGreen;
    }

    public void test(){ // test function
        int[][] testGrid = new int[x][y];
        for(int i =0;i<x;i++){
            for(int j =0;j<y;j++){
                testGrid[i][j] = calculateGreen8(i,j);
            }
        }
        this.grid = testGrid;
    }

    public int generateN (int N,int y0,int x0){ // making all the calculations for N generations
        int[][] tempGrip = new int[x][y];
        copyGrid(tempGrip,grid);
        System.out.printf("GENERATION -%d-%n", 0);
        printGrid();
        int i,a,b,neighbours =0,sumGreenGenerations  = grid[x0][y0];
        for(i=0;i<N;i++){
            for(a=0;a<x;a++){
                for(b=0;b<y;b++){
                    neighbours = calculateGreen8(a,b);
                    if(grid[a][b]==0){
                        if(neighbours==3||neighbours ==6)
                            tempGrip[a][b] = 1;
                    }else{
                        if(neighbours!=3&&neighbours !=6&& neighbours!=2)
                            tempGrip[a][b] = 0;
                    }
                }
            }
            copyGrid(grid,tempGrip);
            sumGreenGenerations+=grid[x0][y0];
            System.out.printf("GENERATION -%d-%n", i+1);
            printGrid();
        }
        return sumGreenGenerations;
    }

    public void copyGrid(int[][] dest, int [][] source){ //function to copy grid to other grid
        for(int i =0;i<x;i++)
            for(int j =0;j<y;j++)
                dest[i][j] = source[i][j];
    }

}
