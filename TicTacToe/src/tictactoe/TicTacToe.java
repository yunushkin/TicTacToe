/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.Channels;

//import org.jboss.netty.channel.group.ChannelGroup;
/**
 *
 * @author wolf
 */
public class TicTacToe {
    /**
     * @param args the command line arguments
     */
    public ServerBootstrap bootstrap;
    
    public void netInit() {
        final int sizeBossPool = 1;
        final int sizeWorkerPool = 4;
        Executor bossPool = Executors.newFixedThreadPool(sizeBossPool);
        Executor workerPool = Executors.newFixedThreadPool(sizeWorkerPool);
        
        ChannelFactory factory = new NioServerSocketChannelFactory(bossPool, workerPool);
        bootstrap = new ServerBootstrap(factory);
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
        
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                /*PacketFrameDecoder decoder = new PacketFrameDecoder();
                PacketFrameEncoder encoder = new PacketFrameEncoder();*/
                return Channels.pipeline(new StringDecoder(), new StringEncoder(), null);//new PlayerHandler(decoder, encoder));
            }
        });
        
        //channelGroup = new DefaultChannelGroup(id + "-all-channels");
    }
    
    public static void main(String[] args) {
        

        
        
        System.out.println("HELLO WORLD!!!");
        // TODO code application logic here
    }
}
