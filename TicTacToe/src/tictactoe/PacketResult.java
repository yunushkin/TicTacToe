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
public class PacketResult extends Packet {
    enum Result {
        win,
        loss,
        draw
    };
    private Result result;
    PacketResult(Result result_) {
        id = 3;
        result = result_;
    }
    @Override
    public ChannelBuffer serialize() {
        ChannelBuffer buffer = ChannelBuffers.dynamicBuffer();
        buffer.writeInt(id);
        buffer.writeInt(result.ordinal());
        return buffer;
    }
    @Override
    public void deserialize(ChannelBuffer buffer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
