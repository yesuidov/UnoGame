public class DeckTester
{
    public static void main(String[] args)
    {
        Deck d = new Deck();
        //System.out.println(d.getCard());
        System.out.println(d.getDeck());
        System.out.println(d.shuffleDeck());
        System.out.println(d.getNumCardsInDeck());
    }
}
