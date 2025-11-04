package bby.algorithms.dynamic.programming;

public class GridTraveler {

    // Base cases
    // gridTraveler(0,1) = 0
    // gridTraveler(1,0) = 0
    // gridTraveler(1,1) = 1
    // grid(0, 0) = 0

    public static int gridTraveler(int n, int m) {
        if ( m == 1 && n == 1 ) { return 1; }
        if ( m == 0 || n == 0 ) { return 0; }

        return gridTraveler( m -1, n) + gridTraveler(m, n -1);
    }

}