import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Need improvements on: 
 * - enhance and connect the checkPCard method
 * - switchTurn method that prints both Players info
 * 
 * properly with the findCardFromPHand method
 * @author Yesui Dovchinsuren
 */
public class UnoRules
{
    private Deck fullDeck;
    private Player currentP;
    private Player p1,p2;

    public UnoRules()
    {
        p1 = new Player(); // "this" method is refering to UnoRules object 
        p2 = new Player();
        currentP = p1;
        fullDeck = new Deck();
    }

    /**
     *  places the card on the beggining card(s) of the disDeck through the 
     *  index (input)
     * 
     *  @return the card that is placed on the disDeck
     */
    public void findCardFromPHand(String card)
    {
        ArrayList<Card> pHand = getCurrentPHand();
        ArrayList<String> h = new ArrayList<String>();
        String s = "";
        /**
         * converting Card to String and adding these converted string cards 
         * to the ArrayList of Strings in order for the indexOf method 
         * to work
         */
        for (int i = 0; i < pHand.size(); i++)
        {
            s = "" + pHand.get(i);
            h.add(s);
        }
        int i = h.indexOf(card);
        // while (checkPCard(i) != true)
        // {
        // System.out.println("Error. Please enter a matching card.");
        // turn();
        // checkPCard(i);
        // }
        if (pHand.get(i).getID().equals("Wild"))

        {
            wild(i);
        }
        else if (pHand.get(i).getID().equals("Wild Draw Four"))
        {
            wildDraw(i);
        }
        else if 
        (pHand.get(i).getID().equals("Skip"))
        {
            fullDeck.getDDeck().add(pHand.get(i));
            pHand.remove(i);
            skip();
        }
        else if (pHand.get(i).getID().equals("Draw Two"))
        { 
            fullDeck.getDDeck().add(pHand.get(i));
            pHand.remove(i);
            drawTwo();
        }
        else
        {
            fullDeck.getDDeck().add(pHand.get(i));
            pHand.remove(i);
            skip();
        }

        checkUNO(i);
    }

    /**
     * (for convinience purposes)
     * getter for the currentP's arrayLists of cards
     */
    public ArrayList<Card> getCurrentPHand()
    {
        return currentP.getPHand();
    }

    public void switchTurn()
    {
        if (currentP == p1)
            {    

                System.out.print("\nPLAYER 2'S TURN\n" + "Your cards: " + p2.getPHand() 
                    + "\n");
                currentP = p2;
            }
            else 
            {

                System.out.print("\nPLAYER 1'S TURN\n" + "Your cards: " + p1.getPHand()
                    + "\n");
                currentP = p1;

            }
        }

    public void turn()
    {
        if (currentP == p1)
        {
            currentP = p1;
            System.out.print("PLAYER 1'S TURN\n" + "Your cards: " + p1.getPHand() 
                + "\n");
        }
        else 
        {
            currentP = p2;
            System.out.print("PLAYER 2'S TURN\n" + "Your cards: " + p2.getPHand()
                + "\n");
        }

    }

    public void start()
    {
        System.out.println("PLAY UNO GAME\n-------------");
        ArrayList<Card> deck = fullDeck.getDeck();
        fullDeck.shuffleDeck();
        for (int i = deck.size()-2; i > deck.size()-9; i--)
        {
            p1.getPHand().add(deck.get(i));
        }
        for (int i = deck.size()-9; i > deck.size()-16; i--)
        {
            p2.getPHand().add(deck.get(i));
        }
        System.out.println("\nDeck Card: " + fullDeck.lastCard());
    }

    /**
     * Skip - skips the next player's turn
     */
    public void skip()
    {
        if (currentP == p1)
            currentP = p2;
        else 
            currentP = p1;
        fullDeck.getLastCard();   
        switchTurn();
    }

    /**
     * wild - allows the player to choose color -- 
     * changes the color of the player's discarded card
     */
    public void wild(int i)
    {
        if (currentP == p1)
            currentP = p1;
        else 
            currentP = p2;
        System.out.print("Enter your color: ");
        Scanner wc = new Scanner(System.in);
        String c = wc.nextLine();
        Card dis = getCurrentPHand().get(i); ///////
        dis.setColor(c);
        fullDeck.getDDeck().add(getCurrentPHand().get(i));
        getCurrentPHand().remove(i);
        fullDeck.getLastCard();
        switchTurn();
        wc.close();
    }

    /**
     * drawTwo - the other player needs to draw two cards from the deck 
     * and skips his turn
     */
    public void drawTwo()
    {
        if (currentP == p1)
            currentP = p2;
        else 
            currentP = p1;
        getCurrentPHand().add(fullDeck.cardToHand());
        getCurrentPHand().add(fullDeck.cardToHand());
        skip();
    }

    /**
     * wildDrawFour - the other player needs to draw four cards 
     * from the deck and skips his turn and allows the player to place 
     * any colored card 
     */
    public void wildDraw(int i)
    {
        if (currentP == p1)
            currentP = p2;
        else
            currentP = p1;
        int x = 0;
        while (x < 4)
        {
            getCurrentPHand().add(fullDeck.cardToHand());
            x++;
        }

        skip();
        wild(i);
    }

    /**
     * checks player’s placed cards (findCardFromHand)
     */
    public boolean checkPCard(int i)
    {
        Card pCard = getCurrentPHand().get(i); 
        Card dCard = fullDeck.lastCard();
        if (pCard.getColor().equals(dCard.getColor()) || 
        pCard.getID().equals(dCard.getID()))
        {   
            return true;
        }
        return false;
    }

    /**
     * counts player hand's points
     */
    public int countPoints()
    {
        int sum = 0;
        if (currentP == p1)
            currentP = p2;
        else
            currentP = p1;
        for (int i = 0; i < getCurrentPHand().size(); i++)
        {
            int val = getCurrentPHand().get(i).getValue();
            sum += val;
        }
        return sum;
    }

    /**
     * if the player's single card is one of the following cards: 
     * a “Wild”, “Wild Draw Four”, “Draw Two” or “Skip”
     * return false. Else, the player gets two more cards from the deck. 
     */
    public boolean checkUNO(int i)
    {
        Card s = fullDeck.lastCard(); ///
        if (s.equals(new Card("Wild")) || 
        s.equals(new Card("Wild Draw Four")) ||
        s.equals(new Card("Skip")) ||
        s.equals(new Card("Draw Two")))
        {
            getCurrentPHand().add(fullDeck.cardToHand());
            return false;
        }
        win(i);
        return true;
    }

    /**
     *  If the player ran out of cards AND the method checkUno is true, 
     *  and the total points of the other player is more than and equal 
     *  to 100, return true.  Else call Uno’s start() and false; 
     *  @return boolean
     */
    public void win(int i)
    {
        if (currentP == p1)
            currentP = p1;
        else
            currentP = p2;
        if (getCurrentPHand().size() == 0)
        {
            if (countPoints() >= 100)
                System.out.println(currentP + " won by " + 
                    countPoints() + " points");
        }

    }

    /**
     * draw a card from the deck and add it into Player's hand
     */
    public void drawCard()
    {
        Card dis = fullDeck.getDeck().remove(fullDeck.getDeck().size()-1);
        getCurrentPHand().add(dis);
        turn();
    }
}
