package com.vijeth.geeksforgeeks.algorithms;

public class Sudoku {

    private static final int N = 9;

    private static class Coordinates{
        private int x;
        private int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static Coordinates findCoordinates(int[][]grid){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(grid[i][j]==0){
                    return new Coordinates(i, j);
                }
            }
        }
        return null;
    }

    public static boolean fillSudoku(int[][] grid){
        Coordinates coordinates = findCoordinates(grid);
        if(coordinates == null){
            return true;
        }
        for(int i=1;i<=N;i++){
            if(isSafe(grid, coordinates, i)){
                grid[coordinates.getX()][coordinates.getY()] = i;
                if(fillSudoku(grid)){
                    return true;
                }
                grid[coordinates.getX()][coordinates.getY()] = 0;
            }
        }
        return false;
    }


    public static boolean isSafe(int[][] grid, Coordinates coordinates, int i){
        int x = coordinates.getX();
        int y = coordinates.getY();
        return isRowSafe(grid, coordinates.getX(), i) && isColSafe(grid, coordinates.getY(), i) && isBoxSafe(grid, x-x%3, y-y%3, i);
    }


    public static boolean isRowSafe(int[][] grid, int x, int digit){

        for(int i=0;i<N;i++){
            if(grid[x][i] == digit){
                return false;
            }
        }
        return true;
    }

    public static boolean isColSafe(int[][] grid, int y, int digit){
        for(int i=0;i<N;i++){
            if(grid[i][y] == digit){
                return false;
            }
        }
        return true;
    }

    public static boolean isBoxSafe(int[][] grid, int startRow, int startCol, int digit){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
                if (grid[i+startRow][j+startCol] == digit) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] grid = {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}};

            if(fillSudoku(grid)){
                print(grid);
            }
    }

    public static void print(int[][] arr){
        for(int i=0;i<N;i++){
            System.out.print("{ ");
            for(int j=0;j<N;j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println(" }");
        }
    }

}
