public class CardTester
{
    public static void main (String[] args)
    {
        Card c1 = new Card("Skip", "Yellow");
        Card c2 = new Card("Nine", "Blue");
        
        System.out.println(c1.getColor());
        System.out.println(c2.getValue());
        System.out.println(c1);
    }
}
