/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unojavaapplication;

import java.util.*;
import unojavaapplication.Model.*;

/**
 *
 * @author tan
 */
public class UnoJavaApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //5 players
        ArrayList<Player> players = new ArrayList<Player>();
        Player player1 = new Player(1, "Tom");
        Player player2 = new Player(2, "Peter");
        Player player3 = new Player(3, "Mary");
        Player player4 = new Player(4, "Harry");
        Player player5 = new Player(5, "Jane");
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        //create game
        UNOGame g = new UNOGame(players);
        //setup game by distributing 7 cards for ea players
        g.setupGame();
        g.displayGameSituation();
        //testing play card
        g.playRandomCard(player1);
        g.playRandomCard(player1);
        g.playRandomCard(player1);
        g.playRandomCard(player1);
        g.displayGameSituation();
        
    }

}
