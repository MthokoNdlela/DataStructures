public class Cell {

    public static void main(String[] args) {

        int M = 10, N = 10;

        //Initialize the grid. 0's represent dead cells and 1's alive cells.
        int[][] grid = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        //Display the grid
        System.out.println("Original generation");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0)
                    System.out.print("+");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
        System.out.println();
        nextGeneration(grid, M, N);
    }

    //Function to print next generation
    static void nextGeneration(int grid[][], int M, int N){
        int[][] future = new int[M][N];

        // Loop through every cell
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                // finding no Of Neighbours that are alive
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours += grid[l + i][m + j];

                // The cell needs to be subtracted from
                // its neighbours as it was counted before
                aliveNeighbours -= grid[l][m];

                // Implementing the Rules of Life

                // Cell is lonely and dies
                if ((grid[l][m] == 1) && (aliveNeighbours < 2))
                    future[l][m] = 0;

                    // Cell dies due to over population
                else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
                    future[l][m] = 0;

                    // A new cell is born
                else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
                    future[l][m] = 1;

                    // Remains the same
                else
                    future[l][m] = grid[l][m];
            }
        }

        System.out.println("Next generation");
            for (int i = 0; i < M; i++){
                for (int j = 0; j < N; j++) {
                    if (future[i][j] == 0)
                        System.out.print("+");
                    else
                        System.out.print("#");
                }
                System.out.println();
            }
        }

    private CellState state;

    public Cell(CellState state){

        this.state = state;
    }

    public CellState GetNextState(int i) {
        return i > 1  && i < 4 ? CellState.ALIVE : CellState.DEAD;
    }

    public enum CellState {
        ALIVE, DEAD
    }
}
