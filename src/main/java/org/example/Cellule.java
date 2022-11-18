package org.example;

public class Cellule {
    int positiveNeighbor = 0;
    boolean isInLife;
    static  String CELLULE_ALIVE = "X";
    static String DEAD_CELLULE = "-";

    public void Cellule(){}

    /**
     * @param isInLife
     */
    public void Cellule(boolean isInLife){
        this.isInLife = isInLife;
    }

    /**
     * @param square
     * @param i
     * @param j
     */
    public void checkCell(String[][] square, int i, int j){
        this.positiveNeighbor = 0;
        for(var x = Math.max(0, i-1); x <= Math.min(i+1, Game.WIDTH_AND_HEIGHT_SQUARE - 1); x++) {
            for(var y = Math.max(0, j-1); y <= Math.min(j+1, Game.WIDTH_AND_HEIGHT_SQUARE -1); y++) {
                if((x != i || y != j) && (square[x][y] == CELLULE_ALIVE )) {
                    this.positiveNeighbor += 1;
                }
            }
        }
        this.isInLife = false;
        if ((this.positiveNeighbor == 2 && square[i][j] == CELLULE_ALIVE) || this.positiveNeighbor == 3){
            this.isInLife = true;
        }
    }
}
