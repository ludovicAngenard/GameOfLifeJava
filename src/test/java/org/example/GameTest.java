package org.example;


import junit.framework.TestCase;

public class GameTest extends TestCase {
    public void test_should_create_string_square_width_equal_5(){
        Game game = new Game();
        String [][] result = game.createSquare(5);
        String[][] resultIWant = new String[5][5];
        assertEquals(resultIWant.length, result.length);
    }
    public void test_should_create_string_square_height_equal_5(){
        Game game = new Game();
        String [][] result = game.createSquare(5);
        String[][] resultIWant = new String[5][5];
        assertEquals(resultIWant[0].length, result[0].length);
    }
    public void test_fill_square_should_only_have_strings_values(){
        Game game = new Game();
        String[][] square = game.fillSquare(game.createSquare(5));
        boolean result = true;
        for ( int i = 0; i < square.length; i++){
            for ( int j = 0; j < square.length; j++){
                if (square[i][j] != "-" || square[i][j] != "X"){
                    result = false;
                }
            }
        }
        assertTrue (result);
    }

}
