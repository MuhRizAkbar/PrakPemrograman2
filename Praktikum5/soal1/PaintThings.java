package soal1;
import java.text.DecimalFormat;
public class PaintThings
{

    public static void main (String[] args)
    {
        final double COVERAGE = 350; 

        Paint paint = new Paint(COVERAGE); 
        
        Rectangle deck;
        Sphere bigBall;
        Cylinder tank;
        
        double deckAmt, ballAmt, tankAmt;

        deck = new Rectangle(20.0, 30.0);

        bigBall = new Sphere(15.0);

        tank = new Cylinder(10.0, 30.0);

        deckAmt = paint.amount(deck);
        ballAmt = paint.amount(bigBall);
        tankAmt = paint.amount(tank);

        DecimalFormat fmt = new DecimalFormat("0.#");
        
        System.out.println ("\n-------------------------------------------");
        System.out.println ("Number of gallons of paint needed..."); 
        System.out.println ("Deck: " + fmt.format(deckAmt) + " gallons");
        System.out.println ("Big Ball: " + fmt.format(ballAmt) + " gallons");
        System.out.println ("Tank: " + fmt.format(tankAmt) + " gallons");
        System.out.println ("-------------------------------------------");
    }
}