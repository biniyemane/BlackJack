package com.blackjack;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The Deck class represents a deck of playing cards.
 * Used to manage the cards during a game of Blackjack.
 *
 * @author Biniyam Yemane-Berhane
 */
public class Deck {
    private ArrayList<Card> cards;

    /**
     * Constructs a Deck with 52 cards and shuffles them.
     */
    public Deck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
        shuffle();
    }

    /**
     * Shuffles the deck of cards.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Draws a card from the deck.
     *
     * @return The drawn card.
     * @throws IllegalStateException if the deck is empty.
     */
    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Deck is empty!");
        }
        return cards.remove(cards.size() - 1);
    }
}
