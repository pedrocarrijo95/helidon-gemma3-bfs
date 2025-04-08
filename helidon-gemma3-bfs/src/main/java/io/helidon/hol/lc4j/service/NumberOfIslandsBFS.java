package io.helidon.hol.lc4j.service;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsBFS {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // Direções para        baixo, cima, direita e esquerda
        int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Se encontrar terra, inicia uma busca em largura
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0'; // Marca como visitado
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] {i, j});

                    // Enquanto houver células na fila
                    while (!queue.isEmpty()) {
                        int[] pos = queue.poll();
                        for (int[] dir : directions) {
                            int r = pos[0] + dir[0];
                            int c = pos[1] + dir[1];

                            // Se for terra e dentro dos limites
                            if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == '1') {
                                grid[r][c] = '0'; // Marca como visitado
                                queue.offer(new int[] {r, c});
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}