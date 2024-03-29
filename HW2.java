﻿package classwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: please add student ID and name here Try to write some comments
 *         for your codes (methods, 15 points)    Ｂ０５４４２３９ 黃仕豪
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn = sc.nextLine();

		int nDeck = Integer.parseInt(testn);
		Deck deck = new Deck(nDeck);
		// TODO: please check your output, make sure that you print all cards on
		// your screen (10 points)
		deck.printDeck();

		if (isAllCardsCorrect(deck.getAllCards(), nDeck)) {
			System.out.println("Well done!");
		} else {
			System.out.println("Error, please check your sourse code");
		}
	}

	
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards, int nDeck) {
		// check the output
		boolean isCorrect = true;
		;
		HashMap<String, Integer> checkHash = new HashMap<String, Integer>();
		for (Card card : allCards) {
			int suit = card.getSuit();
			int rank = card.getRank();
			if (suit > 4 || suit < 1 || rank > 13 || rank < 1) {
				isCorrect = false;
				break;
			}
			if (checkHash.containsKey(suit + "," + rank)) {
				checkHash.put(suit + "," + rank, checkHash.get(suit + "," + rank) + 1);
			} else {
				checkHash.put(suit + "," + rank, 1);
			}

		}
		if (checkHash.keySet().size() == 52) {
			for (int value : checkHash.values()) {
				if (value != nDeck) {
					isCorrect = false;
					break;
				}
			}
		} else {
			isCorrect = false;
		}
		return isCorrect;
	}

}

/**
 * Description: TODO: please add description here
 */
class Deck {
	private ArrayList<Card> cards;

	// TODO: Please implement the constructor (30 points)
	public Deck(int nDeck) {
		cards = new ArrayList<Card>();
		// 1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		// Hint: Use new Card(x,y) and 3 for loops to add card into deck
		// Sample code start
		// Card card=new Card(1,1); ->means new card as clubs ace
		// cards.add(card);
		// Sample code end
		for (int i = 1; i <= nDeck; i++) {         // need to now how many deck first
			for (int x = 1; x <= 4; x++) {         // write X as suit
				for (int y = 1; y <= 13; y++) {    // write y as rank
					Card card = new Card(x, y);
					cards.add(card);               // add all in to cards
				}
			}
		}
	}

	// TODO: Please implement the method to print all cards on screen (10
	// points)
	public void printDeck() {
		// Hint: print all items in ArrayList<Card> cards,
		// TODO: please implement and reuse printCard method in Card class (5
		// points)
		for (int i = 0; i < cards.size(); i++) {   //get place in cards
			cards.get(i).printCard();
		}
	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}
}

/**
 * Description: TODO: please add description here
 */
class Card {
	private int suit; // Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3,
						// Spades=4
	private int rank;// 1~13

	
	public Card(int s, int r) {
		suit = s;
		rank = r;
	}

	// TODO: 1. Please implement the printCard method (20 points, 10 for suit,
	// 10 for rank)
	public void printCard() {
		// Hint: print (System.out.println) card as suit,rank, for example:
		// print 1,1 as Clubs Ace
		if (rank == 1) {
			if (suit == 1)
				System.out.println("Clubs,Ace");
			else if (suit == 2)
				System.out.println("Diamonds,Ace");
			else if (suit == 3)
				System.out.println("Hearts,Ace");
			else if (suit == 4)
				System.out.println("Spades,Ace");
		}

		else {
			if (suit == 1)
				System.out.println("Clubs," + rank);
			else if (suit == 2)
				System.out.println("Diamonds," + rank);
			else if (suit == 3)
				System.out.println("Hearts," + rank);
			else if (suit == 4)
				System.out.println("Spades," + rank);
		}

	}

	public int getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}
}
