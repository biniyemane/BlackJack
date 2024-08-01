package com.blackjack;

import java.util.Scanner;

/**
 * The Game class manages the overall game logic for Blackjack.
 * It controls the flow of the game, including dealing cards, handling player and dealer turns, and determining the winner.
 *
 * @author Biniyam Yemane-Berhane
 */
public class Game {
    private Deck deck;
    private Dealer dealer;
    private Player player;
    private int wins;
    private int losses;
    private int pushes;

    /**
     * Constructs a Game with a deck, a dealer, a player, and initializes win/loss/push counters.
     */
    public Game() {
        deck = new Deck();
        dealer = new Dealer();
        player = new Player("Player");
        wins = 0;
        losses = 0;
        pushes = 0;
    }

    /**
     * Starts and manages the Blackjack game, handling multiple rounds.
     */
    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to Blackjack");

            // Reset hands for new round
            deck = new Deck();
            dealer.getHand().getCards().clear();
            player.getHand().getCards().clear();

            // Initial two cards for player and dealer
            player.getHand().addCard(deck.drawCard());
            player.getHand().addCard(deck.drawCard());
            dealer.getHand().addCard(deck.drawCard());
            dealer.getHand().addCard(deck.drawCard());

            System.out.println("The dealer's hand looks like this:");
            System.out.println(dealer.getHand().getCards().get(0) + " (" + getCardValue(dealer.getHand().getCards().get(0)) + ")");
            System.out.println("The second card is face down.");
            displayPlayerHand();

            // Player's turn
            boolean playerTurn = true;
            while (playerTurn) {
                System.out.println("Would you like to: 1) Hit or 2) Stand");
                String response = scanner.nextLine();
                if (response.equals("1")) {
                    player.getHand().addCard(deck.drawCard());
                    displayPlayerHand();
                    if (player.getHand().getValue() > 21) {
                        System.out.println("You busted! Dealer wins.");
                        losses++;
                        break;
                    }
                } else {
                    playerTurn = false;
                }
            }

            if (player.getHand().getValue() <= 21) {
                // Dealer's turn
                System.out.println("You stand.");
                displayDealerHand();
                while (dealer.getHand().getValue() < 17) {
                    System.out.println("Dealer gets a card");
                    dealer.getHand().addCard(deck.drawCard());
                    displayDealerHand();
                }

                if (dealer.getHand().getValue() > 21) {
                    System.out.println("Dealer busts. You win!");
                    wins++;
                } else {
                    int playerValue = player.getHand().getValue();
                    int dealerValue = dealer.getHand().getValue();
                    if (playerValue > dealerValue) {
                        System.out.println("You win!");
                        wins++;
                    } else if (playerValue < dealerValue) {
                        System.out.println("You lose.");
                        losses++;
                    } else {
                        System.out.println("It's a tie!");
                        pushes++;
                    }
                }
            }

            System.out.println("\nStarting Next Round... Wins: " + wins + " Losses: " + losses + " Pushes: " + pushes);
        }
    }

    /**
     * Displays the player's hand and its value.
     */
    private void displayPlayerHand() {
        System.out.print("Player's hand looks like this:\n");
        for (Card card : player.getHand().getCards()) {
            System.out.print("[" + card + "] (" + getCardValue(card) + ") - ");
        }
        System.out.println(" Valued at: " + player.getHand().getValue());
    }

    /**
     * Displays the dealer's hand and its value.
     */
    private void displayDealerHand() {
        System.out.print("Dealer's hand looks like this:\n");
        for (Card card : dealer.getHand().getCards()) {
            System.out.print("[" + card + "] (" + getCardValue(card) + ") - ");
        }
        System.out.println(" Valued at: " + dealer.getHand().getValue());
    }

    /**
     * Gets the value of a card based on its rank.
     *
     * @param card The card whose value is to be determined.
     * @return The value of the card.
     */
    private int getCardValue(Card card) {
        switch (card.getRank()) {
            case TWO: return 2;
            case THREE: return 3;
            case FOUR: return 4;
            case FIVE: return 5;
            case SIX: return 6;
            case SEVEN: return 7;
            case EIGHT: return 8;
            case NINE: return 9;
            case TEN:
            case JACK:
            case QUEEN:
            case KING: return 10;
            case ACE: return 11; // For display purposes, use 11 for Ace
            default: throw new IllegalArgumentException("Unknown card rank");
        }
    }
}
