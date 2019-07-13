package geeksforgeeks.problems.matrix;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem2_Print_Sorted_Matrix_in_increasing_order {

    public static void main(String[] args) {
        int[][] A = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48,},
                {32, 33, 39, 50}};
        printSortedMatrix(A, 4);
    }


    static void printSortedMatrix(int A[][], int n) {
        boolean[][] visited = new boolean[n][n];

        PriorityQueue<Cell> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(value -> value.val));

        priorityQueue.add(new Cell(0,0, A[0][0]));
        visited[0][0] = true;

        int i = 0;
        while(i != n * n) {
            Cell cell = priorityQueue.poll();
            System.out.print(cell.val + " ");

            if(cell.row < n-1 && !visited[cell.row + 1][cell.col]) {
                visited[cell.row + 1][cell.col] = true;
                priorityQueue.add(new Cell(cell.row + 1, cell.col, A[cell.row +1][cell.col]));
            }
            if(cell.col < n-1 && !visited[cell.row ][cell.col + 1]) {
                visited[cell.row][cell.col + 1] = true;
                priorityQueue.add(new Cell(cell.row, cell.col +1, A[cell.row][cell.col +1]));
            }
            i++;
        }
    }
}

class Cell {
    int row;
    int col;
    int val;
    Cell(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}


