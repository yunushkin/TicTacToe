/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

/**
 *
 * @author wolf
 */
public class PacketGetMove extends Packet {
    PacketGetMove(Board board_, Board.Type type_) {
        id = 1;
        board = board_;
        type = type_;
    }
    @Override
    public ChannelBuffer serialize() {
        ChannelBuffer buffer = ChannelBuffers.dynamicBuffer();
        buffer.writeInt(id);
        buffer.writeInt(type.ordinal());
        for(int col = 0 ; col < board.maxCol; col++) {
            for(int row = 0 ; row < board.maxRow; row++) {
                buffer.writeInt(board.get(row, col).ordinal());
            }
        }
        return buffer;
    }
    private Board board;
    private Board.Type type;

    @Override
    public void deserialize(ChannelBuffer buffer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

