package com.blackjack;

/**
 * The Card class represents a playing card with a suit and rank.
 * Used in the Deck and Hand classes.
 *
 * @author Biniyam Yemane-Berhane
 */
public class Card {
    private Suit suit;
    private Rank rank;

    /**
     * Constructs a Card with the specified suit and rank.
     *
     * @param suit The suit of the card.
     * @param rank The rank of the card.
     */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Gets the suit of the card.
     *
     * @return The suit of the card.
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Gets the rank of the card.
     *
     * @return The rank of the card.
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Returns a string representation of the card.
     *
     * @return A string representing the card.
     */
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
