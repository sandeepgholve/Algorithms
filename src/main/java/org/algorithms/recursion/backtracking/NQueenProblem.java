package org.algorithms.recursion.backtracking;

/**
 * Given NxN board place a N queen on this board so that they don't attack each other. One solution is to find any
 * placement of the queens which do not attack each other. Other solution is to fins all placements of queen on board
 *
 * Time Complexity: O(nxn)
 * Space Complexity: O(nxn)
 *
 * This is an implementation of BackTracking algorithm.
 * <p>
 *     BackTracking: BackTracking is an improvement of the Brute Force approach. And it is a form of Recursion. It
 *     systematically search for a solution to a problem among all available options. In BackTracking, we start with
 *     one possible option out of many available options and try to solve the problem. If we are able to solve the
 *     problem with the selected move then we will print the solution else we will backtrack and select some other
 *     option and try to solve it. If none of the options work out we will claim that there is no solution for the
 *     problem.
 * </p>
 *
 */
public class NQueenProblem {

    /**
     * Stores the X and Y position of the Queen within NxN board.
     */
    class Position {
        int row, col;
        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "(" + row + ", " + col + ")";
        }
    }

    public Position[] solvedNQueenOneSolution(int n) {
        Position[] positions = new Position[n];
        boolean hasSolution = solvedNQueenOneSolutionUntil(n, 0, positions);

        if (hasSolution) {
            return positions;
        } else {
            return new Position[0];
        }
    }

    private boolean solvedNQueenOneSolutionUntil(int n, int row, Position[] positions) {
        if (n == row) {
            return true;
        }

        int col;
        for (col=0 ; col<n ; col++) {
            boolean foundSafe = true;

            // Check if this row and col is not under attack from any previous queen.
            for (int queen = 0; queen < row; queen++) {
                if (positions[queen].col == col
                        || positions[queen].row - positions[queen].col == row - col
                        || positions[queen].row + positions[queen].col == row + col) {
                    foundSafe = false;
                    break;
                }
            }

            if (foundSafe) {
                positions[row] = new Position(row, col);
                if (solvedNQueenOneSolutionUntil(n, row+1, positions)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        NQueenProblem nQueenProblem = new NQueenProblem();
        Position[] positions = nQueenProblem.solvedNQueenOneSolution(4);

        for (Position position : positions) {
            System.out.println(position);
        }
    }
}
