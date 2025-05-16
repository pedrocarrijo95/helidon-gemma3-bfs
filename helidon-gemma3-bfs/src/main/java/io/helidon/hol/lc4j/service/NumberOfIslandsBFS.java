package io.helidon.hol.lc4j.service;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsBFS {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
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
        Queue<int[]> fila = new LinkedList<>();
        fila.add(new int[]{i, j});
        grid[i][j] = '0';
    
        int[][] direcoes = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    
        while (!fila.isEmpty()) {
            int[] ponto = fila.poll();
            for (int[] dir : direcoes) {
                int ni = ponto[0] + dir[0];
                int nj = ponto[1] + dir[1];
                if (ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length && grid[ni][nj] == '1') {
                    grid[ni][nj] = '0';
                    fila.add(new int[]{ni, nj});
                }
            }
        }
    }
}
