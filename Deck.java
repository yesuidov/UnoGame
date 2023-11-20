import java.util.ArrayList;

/**
 * Deck class is a dispense pile or total number of cards in UNO
 *
 * @author Yesui Dovchinsuren
 */
public class Deck
{
    private ArrayList<Card> deck;
    private ArrayList<Card> disDeck;
    
    /**
     * constructor that takes no input
     * sets up names of identity, color through
     * arraylists and creates a new deck of cards
     */
    public Deck()
    {
        String[] identity = {"Skip","Draw Two",
                "Zero", "One", "Two", "Three", "Four", "Five",
                "Six", "Seven", "Eight", "Nine"};
        String[] color = {"Yellow", "Blue", "Red", "Green"};
        deck = new ArrayList<Card>();
        for (int c = 0; c < color.length; c++)
        {
            for (int i = 0; i < identity.length; i++)
            {
                deck.add(new Card(identity[i],color[c]));
            }
        }
         for (int c = 0; c < color.length; c++)
        {
            for (int i = 0; i < identity.length; i++)
            {
                deck.add(new Card(identity[i],color[c]));
            }
        }
        int i = 0;
        while (i < 4)
        {
            deck.add(new Card("Wild"));
            deck.add(new Card("Wild Draw Four"));
            i++;
        }
        disDeck = new ArrayList<Card>();
    }
   
    /**
     * enables public to see the deck
     * @return deck of Uno cards or dispense pile
     */
    public ArrayList<Card> getDeck()
    {
        if (deck.size() == 0)
        {
            shuffleDDeck();
        }
        return deck;
    }
    
    /**
     * method that shuffles the deck
     * @return shuffled deck of cards
     */
    public ArrayList<Card> shuffleDeck()
    {
        for (int d = 0; d < deck.size(); d++)
        {
            deck.add((int)(Math.random() * deck.size()  + 0), deck.remove(d));
        }
        return deck;
    }
    /**
     * the method removes the last card from the deck pile 
     * @return the removed card 
     */
    public Card lastCard()
    {
        Card dis = deck.remove(deck.size()-1);
        int x = 0;
        while (x == 0)
           { if (dis.getID().equals("Wild") || dis.getID().equals("Wild Draw Four")
               || dis.getID().equals("Skip") || dis.getID().equals("Draw Two"))
                {
                  shuffleDeck();
                  dis = deck.remove(deck.size()-1);
            }
             else
                x++;
        }
        disDeck.add(dis);
        return dis;
    }
    public void getLastCard()
    {
        Card dis = disDeck.get(disDeck.size()-1);
        System.out.println("\nDeck Card: " + dis);
    }
    public Card cardToHand()
    {
        Card dis = deck.get(deck.size()-1);
        deck.remove(dis);
        return dis;
    }
    public ArrayList<Card> getDDeck()
    {
        return disDeck;
    }
    
    /**
     * the method that prints how many there are that are remained in the 
     * deck of cards or the total number of cards in the deck
     * @return the total number of cards
     */
    public String getNumCardsInDeck()
    {
        int count = 0;
        for (int i = 0; i < deck.size(); i++)
        {
            count++;
        }
        return "# of cards in the deck pile: "  + count;
    }
    /**
     * if there is no card left in the deck or not enough card for players 
     * to get,  the top ‘open’ card from the disDeck is set aside and the 
     * rest of the pile is shuffled to create a new deck
     * 
     * @return the reshuffled deck
     */
    public ArrayList<Card> shuffleDDeck()
    { 
        
        for (int i = disDeck.size()-1; i < 1; i--)
        {
            deck.add((int)(Math.random() * (disDeck.size()-2) + 0), disDeck.remove(i));
        } 
        return deck;
    }
    
}