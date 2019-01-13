package mustdo.Graph;

public class CountIsland {
    static class Island {
        int rowCount, colCount;
        int[][] island;

        public Island(int m, int n, int[][] island) {
            this.rowCount = m;
            this.colCount = n;
            this.island = island;
        }

        void DFS(int islandMatrix[][], int row, int col, boolean visited[][]) {
            // These arrays are used to get row and column numbers
            // of 8 neighbors of a given cell
            int rowNbr[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
            int colNbr[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

            // Mark this cell as visited
            visited[row][col] = true;

            // Recur for all connected neighbours
            for (int k = 0; k < 8; k++)
                if (isSafe(islandMatrix, row + rowNbr[k], col + colNbr[k], visited))
                    DFS(islandMatrix, row + rowNbr[k], col + colNbr[k], visited);
        }

        int countIslands() {
            boolean visited[][] = new boolean[rowCount][colCount];
            int islandCount = 0;

            for (int i = 0; i < rowCount; ++i) {
                for (int j = 0; j < colCount; ++j){
                    if (island[i][j]==1 && !visited[i][j]) {
                        DFS(island, i, j, visited);
                        ++islandCount;
                    }
                }
            }
            return islandCount;
        }

        boolean isSafe(int M[][], int row, int col, boolean visited[][]) {
            // row number is in range, column number is in range
            // and value is 1 and not yet visited
            return (row >= 0) && (row < rowCount) &&
                    (col >= 0) && (col < colCount) &&
                    (M[row][col] == 1 && !visited[row][col]);
        }
    }

    public static void main(String[] args) {
        int M[][] = new int[][]{{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        Island I = new Island(5, 5, M);
        System.out.println("Number of islands is: " + I.countIslands());

    }
}