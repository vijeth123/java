package com.vijeth.geeksforgeeks.algorithms;

public class RatMaze {

    private static final int MAX = 4;

    public static boolean isSafe(int maze[][], int x, int y){
        if(x<MAX && y<MAX && maze[x][y]==1){
            return true;
        }else{
            return false;
        }
    }

    public static boolean move(int[][]maze, int x, int y, int[][] sol){
        if(x == MAX-1 && y == MAX-1){
            sol[x][y]=1;
            return true;
        }

        if(isSafe(maze, x, y)){
            sol[x][y]=1;
            if(move(maze, x+1, y, sol)){
                return true;
            }
            if(move(maze, x, y+1, sol)){
                return true;
            }else{
                sol[x][y]=0;
                return false;
            }
        }
        return false;

    }

    public static void print(int[][] arr){
        for(int i=0;i<MAX;i++){
            System.out.print("{ ");
            for(int j=0;j<MAX;j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println(" }");
        }
    }

    public static void main(String[] args) {

        int[][]maze = {
                            {1, 1, 0, 0},
                            {0, 1, 1, 1},
                            {1, 1, 0, 0},
                            {1, 1, 1, 1}
                      };

        int[][]sol = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };


        move(maze, 0, 0, sol);

        System.out.println("Maze:");
        print(maze);

        System.out.println("\n\nSolution:");
        print(sol);
    }

}
