import java.util.ArrayList;

/**
 * @author Yesui Dovchinsuren
 */
public class Player
{
    private ArrayList<Card> pHand;
    private int points;
    private Deck deck;

    public Player()
    {
        pHand = new ArrayList<Card>();
        points = 0;
        deck = new Deck();
    }

    /**
     * @return the player's hand
     */
    public ArrayList<Card> getPHand()
    {
        return pHand;
    }

}
