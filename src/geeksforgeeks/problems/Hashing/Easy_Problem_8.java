package geeksforgeeks.problems.Hashing;


/**
 * Count maximum points on same line
 *
 * Given N point on a 2D plane as pair of (x, y) co-ordinates,
 * we need to find maximum number of point which lie on the same line.
 *
 * Examples:
 *
 * Input : points[] = {-1, 1}, {0, 0}, {1, 1},
 *                     {2, 2}, {3, 3}, {3, 4}
 * Output : 4
 * Then maximum number of point which lie on same
 * line are 4, those point are {0, 0}, {1, 1}, {2, 2},
 * {3, 3}
 *
 *
 */
public class Easy_Problem_8 {
    public static void main(String[] args) {
        int points[][] = {{-1, 1}, {0, 0}, {1, 1}, {2, 2}, {3, 3}, {3, 4}};

        for(int i = 0; i < points.length; i++) {
            for(int j = i+1; j < points.length; j++) {
                int x = points[j][1] - points[i][1];
                int y = points[j][0] - points[i][0];

            }
        }
    }
}
