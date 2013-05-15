/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.replay.ReplayingDecoder;
import tictactoe.Decoder.DecoderState;

/**
 *
 * @author yunushkin
 */
public class Decoder extends ReplayingDecoder<DecoderState>
{
    public enum DecoderState
    {
        READ_LENGTH,
        READ_CONTENT;
    }  

    private int length;

    public Decoder()
    {
        super( DecoderState.READ_LENGTH );
    }
    
    @Override
    protected Object decode( ChannelHandlerContext chc, Channel chnl, ChannelBuffer cb, DecoderState state ) throws Exception
    {
        switch ( state )
        {
            case READ_LENGTH:
                //length = cb.readInt();
                length = 1;
                cb.readBytes(1).array();
                checkpoint( DecoderState.READ_CONTENT );
                
            case READ_CONTENT:
                ChannelBuffer frame = cb.readBytes( length );
                checkpoint( DecoderState.READ_LENGTH );
                return frame;
                
            default:
                throw new Error( "Shouldn't reach here." );
        }
    }
}
