package com.blackjack;

import java.util.ArrayList;

/**
 * The Player class represents a player in the game of Blackjack.
 * Inherits from the Person class.
 *
 * @author Biniyam Yemane-Berhane
 */
public class Player extends Person {
    private ArrayList<Hand> hands;
    private int currentHandIndex;

    /**
     * Constructs a Player with a name and initializes hands.
     *
     * @param name The name of the player.
     */
    public Player(String name) {
        super(name);
        hands = new ArrayList<>();
        hands.add(new Hand());
        currentHandIndex = 0;
    }

    /**
     * Gets the list of hands.
     *
     * @return The list of hands.
     */
    public ArrayList<Hand> getHands() {
        return hands;
    }

    /**
     * Gets the current hand being played.
     *
     * @return The current hand.
     */
    public Hand getCurrentHand() {
        return hands.get(currentHandIndex);
    }

    /**
     * Moves to the next hand if available.
     */
    public void moveToNextHand() {
        if (currentHandIndex < hands.size() - 1) {
            currentHandIndex++;
        }
    }

    /**
     * Splits the current hand into two hands if the first two cards have the same rank.
     *
     * @return true if the hand was split, false otherwise.
     */
    public boolean split() {
        Hand currentHand = getCurrentHand();
        if (currentHand.getCards().size() == 2 && currentHand.getCards().get(0).getRank() == currentHand.getCards().get(1).getRank()) {
            Hand newHand = new Hand();
            newHand.addCard(currentHand.getCards().remove(1));
            hands.add(newHand);
            return true;
        }
        return false;
    }

    /**
     * Resets hands for a new round.
     */
    public void resetHands() {
        hands.clear();
        hands.add(new Hand());
        currentHandIndex = 0;
    }
}
