package org.example;

import java.util.Random;

public class Game {
    static int WIDTH_AND_HEIGHT_SQUARE = 10;
    private String[][] square;
    private String[][] stashSquare;
    private int count = 10;
    public Game (){
            this.stashSquare = this.createSquare(WIDTH_AND_HEIGHT_SQUARE);
            this.square = this.fillSquare(createSquare(WIDTH_AND_HEIGHT_SQUARE));
    }
    public void start(){
        while (this.count > 0) {
            System.out.println("------------------------------------------");
            System.out.println("--------------------" + this.count + "----------------------");
            System.out.println("------------------------------------------");
            this.checkSquare(this.square);
            this.updateSquare();
            this.count--;
        }
    }

    /**
     * @param size
     * @return
     */
    public String[][] createSquare(int size){
        String [][] arraySquare = new String[size][size];
        return arraySquare;
    }

    /**
     * @param square
     * @return
     */
    public String[][] fillSquare(String[][] square){
        for (int i = 0; i < square.length; i++){
            for (int j = 0; j< square[i].length; j++){
                String [] arr = {Cellule.CELLULE_ALIVE, Cellule.DEAD_CELLULE};
                Random random = new Random();
                int select = random.nextInt(arr.length);
                square[i][j] = arr[select];
                System.out.print(square[i][j] + "\t");
            }
            System.out.println("");
        }

        return square;
    }

    /**
     * @param square
     */
    public void checkSquare(String[][] square){
        for (int i = 0; i < square.length; i++){
            for (int j = 0; j < square[i].length; j++){
                Cellule cell = new Cellule();
                cell.checkCell(square, i, j);
                if (cell.isInLife){
                    this.stashSquare[i][j] = cell.CELLULE_ALIVE;
                } else {
                    this.stashSquare[i][j] = cell.DEAD_CELLULE;
                }
                System.out.print(square[i][j] + "\t");
            }
                System.out.println("");
        }

    }
    public void updateSquare(){
        this.square = this.stashSquare;
        this.stashSquare = this.createSquare(WIDTH_AND_HEIGHT_SQUARE);
    }
}
