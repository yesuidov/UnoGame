/**
 *
 * @author Yesui Dovchinsuren
 */
public class Card
{
    private String identity;
    private String color;
    private int value;
  
    /** 
     * Constructor that sets up values for each card
     * 
     * @param - Card identity and Card color
     * @return none
     */
    public Card(String ID,String c)
    {
        identity = ID;
        if (ID.equals("Draw Two") || ID.equals("Skip"))
        {
            value = 20; 
        }
        if (ID.equals("Zero"))
        {
            value = 0;
        }
        if (ID.equals("One"))
        {
            value = 1;
        }
        if (ID.equals("Two"))
        {
            value = 2;
        }
        if (ID.equals("Three"))
        {
            value = 3;
        }
        if (ID.equals("Four"))
        {
            value = 4;
        }
        if (ID.equals("Five"))
        {
            value = 5 ;
        }
        if (ID.equals("Six"))
        {
            value = 6;
        }
        if (ID.equals("Seven"))
        {
            value = 7;
        }
        if (ID.equals("Eight"))
        {
            value = 8;
        }
        if (ID.equals("Nine"))
        {
            value = 9;
        }
        color = " of " + c;
    }
    public Card(String ID)
    {
        identity = ID;
        if (ID.equals("Wild") || ID.equals("Wild Draw Four"))
        {
            value = 50;
        }
        if (ID.equals("Draw Two") || ID.equals("Skip"))
        {
            value = 20; 
        }
        color = "";
    }
     /**
     * allows public to see identity, color, and value
     */
    public String getID()
    {
        return identity;
    }
    public String getColor()
    {
        return color;
    }
    public void setColor(String c)
    {
        color = c;
    }
    public int getValue()
    {
        return value;
    }

     /**
     * prints card details
     */
    public String toString()
    {
         return identity + color;
    }
}
