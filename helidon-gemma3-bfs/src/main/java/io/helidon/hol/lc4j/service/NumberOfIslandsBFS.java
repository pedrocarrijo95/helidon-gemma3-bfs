package io.helidon.hol.lc4j.service;


public class NumberOfIslandsBFS {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If find land, start bfs search
                if (grid[i][j] == '1') {
                    count++;
                    callBFS(grid,i,j);  
                }
            }
        }

        return count;
    }

    public void callBFS(char[][] grid, int i, int j){
        if (i<0 || i>= grid.length || j<0 || j>= grid[i].length || grid[i][j] == 0){
            return;
        }
        grid[i][j] = '0';
        callBFS(grid, i-1,j); // up
        callBFS(grid, i+1,j); // down
        callBFS(grid, i,j-1); // left
        callBFS(grid, i,j+1); //right
    }
}
