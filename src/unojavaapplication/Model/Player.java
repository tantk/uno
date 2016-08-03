/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unojavaapplication.Model;

import unojavaapplication.Model.*;

import java.util.*;
import java.lang.Object;

/**
 *
 * @author tan
 */
public class Player {

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.playerHand = new PlayerHand();
    }
    private int id;
    private String name;
    //use linkedlist because we draw cards more often than get card details in uno.
    private PlayerHand playerHand;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerHand getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(PlayerHand playerHand) {
        this.playerHand = playerHand;
    }

    public void drawCardFrom(pileOfCards piles) {
        this.playerHand.cardList.add(piles.removeCard());
    }

    public Card removeCardTo(int cardID, pileOfCards piles) {
        int indexN = 0;
        for (Card c : this.playerHand.cardList) {
            int i = 0;
            if (c.getId() == cardID) {
                indexN = i;
            }
            i++;
        }
        Card cardPlayed = this.playerHand.cardList.get(indexN);
        this.playerHand.cardList.remove(indexN);
        piles.cardList.add(cardPlayed);
        return cardPlayed;
    }

    public void showPlayerHand() {
        System.out.println("Player ID:" + this.getId() + " Name=" + this.getName() + ":");
        System.out.println("Player Total Card Score: "+this.playerHand.getHandValue());
        System.out.println("Card in hand:");
        for (Card c : this.getPlayerHand().cardList) {
            System.out.println(c.toString());
        }
    }
    public void removeRandomCardTo(pileOfCards pile)
    {
        removeCardTo(unojavaapplication.utility.utility.randInt(0, (this.playerHand.cardList.size() - 1)),pile);
    }
}
