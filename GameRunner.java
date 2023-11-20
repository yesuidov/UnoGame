import java.util.Scanner;
/**
 * 
 * @author Yesui Dovchinsuren
 */
public class GameRunner
{
    public static void main(String args[])
    {
        UnoRules uno = new UnoRules();
        int gameCount = 0;
        int game = 0;
        Scanner scan = new Scanner(System.in);
        while (gameCount == 0)
        {
            uno.start();
            uno.turn();
            System.out.print("A = DISCARD A CARD\nB = DRAW A CARD\nC = SAY UNO\nYour answer: ");
            String ans = scan.nextLine();
            while (game == 0)
            {
                if (ans.equals("B"))
                {
                    uno.drawCard();
                    System.out.print("A = DISCARD A CARD\nB = DRAW A CARD\nC = SAY UNO\nYour answer: ");
                    ans = scan.nextLine();
                }
                else if (ans.equals("A"))
                {
                    System.out.print("Enter your card: ");
                    String card = scan.nextLine();
                    uno.findCardFromPHand(card);
                    int i = uno.getCurrentPHand().indexOf(card);
                    if (uno.getCurrentPHand().size() == 0 && uno.checkUNO(i))
                    {
                        if (uno.countPoints() >= 100)
                            uno.win(i);
                        else
                        { 
                            gameCount = 0;
                        }
                    }
                    uno.switchTurn();
                    System.out.print("A = DISCARD A CARD\nB = DRAW A CARD\nC = SAY UNO\nYour answer: ");
                    ans = scan.nextLine();
                }
                else 
                {
                    uno.switchTurn();
                    System.out.print("A = DISCARD A CARD\nB = DRAW A CARD\nC = SAY UNO\nYour answer: ");
                    ans = scan.nextLine();
                }

            }
        }
        scan.close();
    }        

}

