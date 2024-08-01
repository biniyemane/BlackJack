package com.blackjack;

import java.util.ArrayList;

/**
 * The Hand class represents a player's hand of cards in Blackjack.
 * Used to manage the cards held by a player or dealer.
 *
 * @author Biniyam Yemane-Berhane
 */
public class Hand {
    private ArrayList<Card> cards;

    /**
     * Constructs an empty Hand.
     */
    public Hand() {
        cards = new ArrayList<>();
    }

    /**
     * Adds a card to the hand.
     *
     * @param card The card to be added.
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Calculates and returns the value of the hand.
     *
     * @return The value of the hand.
     */
    public int getValue() {
        int value = 0;
        int numAces = 0;

        for (Card card : cards) {
            switch (card.getRank()) {
                case TWO: value += 2; break;
                case THREE: value += 3; break;
                case FOUR: value += 4; break;
                case FIVE: value += 5; break;
                case SIX: value += 6; break;
                case SEVEN: value += 7; break;
                case EIGHT: value += 8; break;
                case NINE: value += 9; break;
                case TEN:
                case JACK:
                case QUEEN:
                case KING: value += 10; break;
                case ACE: numAces++; value += 11; break;
            }
        }

        while (value > 21 && numAces > 0) {
            value -= 10;
            numAces--;
        }

        return value;
    }

    /**
     * Gets the list of cards in the hand.
     *
     * @return The list of cards in the hand.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Returns a string representation of the hand.
     *
     * @return A string representing the hand.
     */
    @Override
    public String toString() {
        return cards.toString();
    }
}
