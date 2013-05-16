/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.List;
import java.util.ArrayList;
import org.jboss.netty.channel.Channel;
import java.util.ListIterator;
/**
 *
 * @author yunushkin
 */
public class GamePlay {
    class Players{
        public Players(Channel channelX_, Channel channelO_) {
            channelX = channelX_;
            channelO_ = channelO;
        }
        public Channel channelX;
        public Channel channelO;
    }
    
    public static final GamePlay INSTANCE = new GamePlay();
    private GamePlay() { 
        list = new ArrayList<Players>();
    }
    private Players findPlayer(final Channel channel) {
        ListIterator  it = list.listIterator();
        Players pair;
        while(it.hasNext()) {
            pair = (Players) it.next();
            if(pair.channelO == channel || pair.channelX == channel)  {
                return pair;
            }
        }
        return null;
    }
    public void beginNewGame(final Players players) {

    }
    
    public void addPlayer(Channel channel) {
        Players pair = findPlayer(null);
        if(pair != null) {
            if(pair.channelO == null) {
                pair.channelO = channel;
            } else {
                pair.channelX = channel;
            }
        } else {
            list.add(new Players(channel, null));
        }
    }
    
    public void deletePlayer(Channel channel) {
        Players pair = findPlayer(channel);
        if(pair == null) {
            return;
        }
        Channel chX = pair.channelX;
        Channel chO = pair.channelO;
        list.remove(pair);
        if(chO == channel && chX != null)  {
            addPlayer(chX);
        }
        if(chX == channel && chO != null)  {
            addPlayer(chO);
        }    
    }
    
    private List<Players> list;
}
