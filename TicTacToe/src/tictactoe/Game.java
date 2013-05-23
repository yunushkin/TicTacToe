/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javax.swing.border.Border;
import org.jboss.netty.channel.Channel;

public class Game {
    enum State{
        winX,
        winO,
        draw,
        move
    }
    int scoreX;
    int scoreO;
    private int step;
    private Board board = new Board();
    public Game() {
        step = 0;
        scoreO = 0;
        scoreX = 0;
    }
    private int place2row(int place){
        return place/board.maxRow;
    }
    private int place2col(int place){
        return place%board.maxRow;
    }
    public boolean move(int place, Board.Type type) {
        if(type == Board.Type.X) { 
            if(step%2 == 0) {
                return false;
            }
        } else {
            if(step%2 == 0){
                return false;
            }
        }
        if(place < 0 &&  place > 8) {
            return false;
        }
        int row = place2row(place);
        int col = place2col(place);
        if(board.get(row, col) != Board.Type.NOT)
            return false;
        board.set(row, col, type);
        step++;
        return true;
    }
    public void newGame() {
        step = 0;
        board.clear();
    }
    public State getGameState() {
        return State.move;
    } 
}
