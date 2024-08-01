package com.blackjack;

/**
 * The Person class represents a general person in the game of Blackjack.
 * It is inherited by the Player and Dealer classes.
 *
 * @author Biniyam Yemane-Berhane
 */
public class Person {
    protected Hand hand;
    protected String name;

    /**
     * Constructs a Person with a name and an empty hand.
     *
     * @param name The name of the person.
     */
    public Person(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    /**
     * Gets the hand of the person.
     *
     * @return The hand of the person.
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Gets the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }
}
