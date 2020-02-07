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

        //Loop through every Cell
        for (int m = 1; m < N - 1; m++){
            //Finding numbers of neighbours alive
            int aliveNeighbours = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    aliveNeighbours += grid[1 + i][m + j];

                    //Cells need to be subtracted from their neighbours after they were counted
                    aliveNeighbours -= grid[1][m];

                    //Implement rules of the game

                    //Cell is lonely and dies
                    if ((grid[1][m] == 1) && (aliveNeighbours < 2))
                        future[1][m] = 0;

                        //Cell dies cos of over population
                    else if ((grid[1][m] == 1) && (aliveNeighbours > 3))
                        future[1][m] = 0;

                        //Cell is revived
                    else if ((grid[1][m] == 0) && (aliveNeighbours == 3))
                        future[1][m] = 1;

                        //Remains the same
                    else
                        future[1][m] = grid[1][m];
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
