import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

public class NQueens
{
    private NQueensWorld world;
    private Grid<Actor> board;

    /**
     * Constructs an object that solves the N Queens Problem.
     * @param n the number of queens to be placed on an n by n board
     */
    public NQueens(int n)
    {
        board = new BoundedGrid<Actor>(n, n);
        world = new NQueensWorld(board);
        world.show();
    }

    /**
     * Kicks off the recursion to solve the N Queens Problem.
     */
    public void solve()
    {
        placeQueen(0);
    }

    /**
     * Attempts to place the qth queen on the board.
     * Precondition: 0 <= q < board.getNumRows()
     * @param q row index of next queen to place
     * @return true if non-attacking queens were placed in all remaining rows;
     *         false otherwise.
     */
    private boolean placeQueen(int q)
    {
        // Base case: If q has reached the number of rows, all queens are placed!
        if (q >= board.getNumRows())
        {
            return true;
        }

        // TODO: Iterate through every column in row q
        // 1. Create a Location object for (q, col)
        // 2. Check if locationIsOK(loc)
        // 3. If OK, add Queen, pause briefly (Thread.sleep), and recursively attempt placeQueen(q + 1)
        // 4. If recursion returns true, return true!
        // 5. If recursion fails, backtrack: remove Queen, pause briefly, and try next column
        
        return false; // Return false if no valid column was found in this row
    }

    /**
     * Determines whether a queen can be placed at the specified location without
     * being attacked by previously placed queens in rows above it.
     * @param loc the location to test
     * @return true if this location is not attacked; false otherwise.
     */
    private boolean locationIsOK(Location loc)
    {
        int row = loc.getRow();
        int col = loc.getCol();
        int r, c;

        // TODO 1: Check all rows directly above loc (same column)
        // If board.get(new Location(r, col)) != null, return false


        // EXAMPLE: Check up and to the right diagonal (Provided for reference)
        for (r = row - 1, c = col + 1; r >= 0 && c < board.getNumCols(); r--, c++)
        {
            if (board.get(new Location(r, c)) != null)
                return false;
        }


        // TODO 2: Check up and to the left diagonal
        // Loop up and left while r >= 0 and c >= 0
        // If board.get(new Location(r, c)) != null, return false


        return true; // Location is safe from all existing queens above
    }

    /**
     * Adds a queen at the specified location and re-shows the world.
     * Precondition: loc is a valid location in grid
     * @param loc the location where the queen should be placed
     */
    private void addQueen(Location loc)
    {        
        new Queen().putSelfInGrid(board, loc);
        world.show();
    }

    /**
     * Removes a queen at the specified location and re-shows the world.
     * Precondition: loc is a valid location in grid
     * @param loc the location where the queen should be removed
     */
    private void removeQueen(Location loc)
    {
        board.get(loc).removeSelfFromGrid();
        world.show();
    }
}