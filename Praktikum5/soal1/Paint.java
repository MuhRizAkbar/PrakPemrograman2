package soal1;

public class Paint
{
    private double coverage; 

    public Paint(double c)
    {
        coverage = c;
    }

    public double amount(Shape s)
    {

        double shapeArea = s.area(); 
        
        System.out.println ("\nComputing amount for " + s.toString());
        System.out.printf ("Area yang dicat: %.2f square feet\n", shapeArea);
        System.out.printf ("Daya sebar cat: %.2f square feet per unit\n", coverage);

        double paintAmount = shapeArea / coverage;
        
        return paintAmount;
    }
}