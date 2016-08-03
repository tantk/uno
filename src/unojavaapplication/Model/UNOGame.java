/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unojavaapplication.Model;

import java.util.*;

import unojavaapplication.Model.*;
import java.util.Random;
import unojavaapplication.utility.utility;
/**
 *
 * @author tan
 */
public class UNOGame {

    private String gameID;
    private List<Player> playerList;
    private GameStatus gameStatus;
    private Deck gameDeck;
    private DiscardPile discardPile;

    public DiscardPile getDiscardPile() {
        return discardPile;
    }

    public void setDiscardPile(DiscardPile discardPile) {
        this.discardPile = discardPile;
    }

    public enum GameStatus {
        waiting,
        started,
        ended;
    }
//game is created when at least 1 player wants to play

    public UNOGame(List<Player> playerList) {
        this.gameID = UUID.randomUUID().toString().substring(0, 8);
        this.gameStatus = gameStatus.waiting;
        this.gameDeck = new Deck();
        this.discardPile = new DiscardPile();
        this.playerList = playerList;
    }

    public String getGameID() {
        return gameID;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }
//change game status



    public Deck getGameDeck() {
        return gameDeck;
    }

    public void playerDrawCardFromDeck(Player p) {
        p.drawCardFrom(this.gameDeck);
    }

    public Card discardCard(Player p, Card c) {
        this.discardPile.cardList.add(c);
        p.removeCardTo(c.getId(), this.discardPile);
        return c;
    }

    //assume draw first card from discardpile
    public void takeFromDiscardPile(pileOfCards DeckOrPlayerHand) {
        DeckOrPlayerHand.drawCardFrom(this.discardPile);
    }

    public void addPlayer(Player p) {
        this.playerList.add(p);
    }

    public void setupGame() {
        String startingPlayer = "";
        //this.gameDeck.Shuffle();

        for (int i = 0; i < 7; i++) {
            for (Player c : this.playerList) {
                c.drawCardFrom(this.gameDeck);
            }
        }
        //form discardpile
        this.discardPile.cardList.add(this.gameDeck.removeCard());
        System.out.println("Game ID:" + this.getGameID());
        //assume random player start first,get starting player:
        startingPlayer = this.playerList.get(unojavaapplication.utility.utility.randInt(0, this.playerList.size() - 1)).getName();
        System.out.println("The starting player is: " + startingPlayer);
    }

    public void displayGameSituation() {
        System.out.println("Cards in deck:" + this.getGameDeck().remainingCards());
        System.out.println("Discard: " + this.discardPile.showTopCard().toString());
        System.out.println();
        for (Player p : this.getPlayerList()) {

            p.showPlayerHand();
            System.out.println();
        }
    }
    
    public void changeToStarted()
    {
    this.gameStatus=GameStatus.started;
    }
    public void changeToEnded()
    {
    this.gameStatus=GameStatus.ended;
    }
    public void changeToWaiting()
    {
    this.gameStatus=GameStatus.waiting;
    }
    
    public void playRandomCard(Player p)
    {
    p.removeRandomCardTo(this.discardPile);
    }
    
}
