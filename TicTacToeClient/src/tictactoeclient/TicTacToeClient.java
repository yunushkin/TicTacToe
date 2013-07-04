package tictactoeclient;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicTacToeClient {
    
    public static void main(String[] args)  throws InterruptedException {
        System.out.println("Waiting connection...");
        NetworkService network  = new NetworkService();
        network.connect();
        while(true) {
            Thread.sleep(1000);
        }
        // TODO code application logic here
    }
}
